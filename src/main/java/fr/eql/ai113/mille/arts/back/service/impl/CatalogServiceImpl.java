package fr.eql.ai113.mille.arts.back.service.impl;

import fr.eql.ai113.mille.arts.back.entity.*;
import fr.eql.ai113.mille.arts.back.repository.*;
import fr.eql.ai113.mille.arts.back.service.CatalogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CatalogServiceImpl implements CatalogService {

    private DecorationDao decorationDao;
    private TagDao tagDao;
    private PriceDao priceDao;
    private DecorationTagDao decorationTagDao;
    private DecorationPriceDao decorationPriceDao;

    @Override
    public List<Decoration> findAllDecorations() {
        return decorationDao.findAll();
    }

    @Override
    public List<Decoration> findDecorationsByResearch(String research) {
        return decorationDao.findDecorationsByResearch(research);
    }

    @Override
    public Decoration findDecorationById(Long decorationId) {return decorationDao.findById(decorationId).get();}

    @Override
    public List<String> findAllTagsByIdDecoration(Long decorationId) {
        return decorationDao.findAllTagsByDecorationId(decorationId);
    }

    @Override
    public Float findCurrentPriceByDecoration(Long decorationId) {
        return decorationDao.findCurrentPriceByDecorationId(decorationId);
    }

    @Override
    public Decoration modifyDecoration(Long id, String name, String picture, String description, Long preparationDelay, Float price, List<String> tagNames) {

        // Modifying name, picture, description and/or preparation delay
        decorationDao.modifyDecoration(id, name, picture, description, preparationDelay);

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
        decorationDao.deleteCurrentPriceByDecorationId(decorationDao.findById(id).get(), decorationDao.findCurrentPriceClassByDecorationId(id));
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
    public Decoration addDecoration(String name, String picture, String description, Long preparationDelay, Float price, List<String> tags) {
        Decoration newDecoration = decorationDao.save(new Decoration());
        Long id = newDecoration.getId();
        newDecoration = modifyDecoration(id, name, picture, description, preparationDelay, price, tags);
        return newDecoration;
    }

    @Override
    public Decoration deleteDecoration(Long id) {
        return null;
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
}
