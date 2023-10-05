package fr.eql.ai113.mille.arts.back.service.impl;

import fr.eql.ai113.mille.arts.back.entity.*;
import fr.eql.ai113.mille.arts.back.repository.*;
import fr.eql.ai113.mille.arts.back.service.CatalogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class CatalogServiceImpl implements CatalogService {

    private DecorationDao decorationDao;
    private TagDao tagDao;
    private PriceDao priceDao;
    private DecorationTagDao decorationTagDao;
    private DecorationPriceDao decorationPriceDao;
    private PictureDao pictureDao;

    @Override
    public List<Decoration> findAllDecorations() {
        return decorationDao.findAllActiveDecorations();
    }

    @Override
    public List<Decoration> findDecorationsByResearch(String research) {
        return decorationDao.findDecorationsByResearch(research);
    }

    @Override
    public Decoration findDecorationById(Long decorationId) {return decorationDao.findSearchedDecorationById(decorationId);}

    @Override
    public List<Decoration> findNovelties() {
        return decorationDao.findAndSortDecorationsByAdditionDate().subList(0,5);
    }

    @Override
    public List<String> findAllTagsByIdDecoration(Long decorationId) {
        return decorationDao.findAllTagsByDecorationId(decorationId);
    }

    @Override
    public Float findCurrentPriceByDecoration(Long decorationId) {
        return decorationDao.findCurrentPriceByDecorationId(decorationId);
    }

    @Override
    public List<String> findPicturesByDecoration(Long decorationId) {
        return decorationDao.findPicturesByDecoration(decorationId);
    }

    @Override
    public Decoration modifyDecoration(Long id, String name, List<String> pictures, String description, String weight, String dimensions, Long preparationDelay, Float price, List<String> tagNames) {

        // Modifying name, description and/or preparation delay
        decorationDao.modifyDecoration(id, name, description, weight, dimensions, preparationDelay);

        // Modifying pictures
        Decoration d = findDecorationById(id);
        pictureDao.deleteAllByDecoration(d);
        for (String p : pictures) {
            Picture picture = new Picture();
            picture.setPath(p);
            picture.setDecoration(d);
            pictureDao.save(picture);
        }

        // Modifying tags
        decorationTagDao.deleteDTByDecorationId(decorationDao.findById(id).get());
        for (String tagName : tagNames) {
            Tag tag = decorationDao.findTagByName(tagName);
            if (tag == null) {
                tag = new Tag(tagName);
                tagDao.save(tag);
                tag = decorationDao.findTagByName(tagName);
            }
            DecorationTag decorationTag = new DecorationTag();
            decorationTag.setDecoration(decorationDao.findById(id).get());
            decorationTag.setTag(tag);
            decorationTagDao.save(decorationTag);
        }

        // Modifying current price
        decorationDao.deleteCurrentPriceByDecorationId(decorationDao.findById(id).get(), decorationDao.findCurrentPriceClassByDecorationId(id), LocalDate.now());
        Price priceClass = decorationDao.findPriceByAmount(price);
        if (priceClass == null) {
            priceClass = new Price(price);
            priceDao.save(priceClass);
            priceClass = decorationDao.findPriceByAmount(price);
        }
        DecorationPrice decorationPrice = new DecorationPrice();
        decorationPrice.setPrice(priceClass);
        decorationPrice.setDecoration(decorationDao.findById(id).get());
        decorationPriceDao.save(decorationPrice);

        return decorationDao.findById(id).get();
    }

    @Override
    public Decoration addDecoration(String name, List<String> pictures, String description, String weight, String dimensions, Long preparationDelay, Float price, List<String> tags) {
        Decoration newDecoration = decorationDao.save(new Decoration());
        Long id = newDecoration.getId();
        newDecoration = modifyDecoration(id, name, pictures, description, weight, dimensions, preparationDelay, price, tags);
        decorationDao.setCurrentDate(id, LocalDate.now());
        return newDecoration;
    }

    @Override
    public void deleteDecoration(Long id) {
        decorationDao.DisableDecorationById(id, LocalDate.now());
    }

    @Autowired
    public void setDecorationDao(DecorationDao decorationDao) {
        this.decorationDao = decorationDao;
    }
    @Autowired
    public void setTagDao(TagDao tagDao) {
        this.tagDao = tagDao;
    }
    @Autowired
    public void setPriceDao(PriceDao priceDao) {
        this.priceDao = priceDao;
    }
    @Autowired
    public void setDecorationTagDao(DecorationTagDao decorationTagDao) {
        this.decorationTagDao = decorationTagDao;
    }
    @Autowired
    public void setDecorationPriceDao(DecorationPriceDao decorationPriceDao) {
        this.decorationPriceDao = decorationPriceDao;
    }
    @Autowired
    public void setPictureDao(PictureDao pictureDao) {
        this.pictureDao = pictureDao;
    }
}
