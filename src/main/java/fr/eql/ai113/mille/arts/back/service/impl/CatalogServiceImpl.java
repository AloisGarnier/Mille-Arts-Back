package fr.eql.ai113.mille.arts.back.service.impl;

import fr.eql.ai113.mille.arts.back.entity.Decoration;
import fr.eql.ai113.mille.arts.back.entity.Tag;
import fr.eql.ai113.mille.arts.back.repository.DecorationDao;
import fr.eql.ai113.mille.arts.back.service.CatalogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CatalogServiceImpl implements CatalogService {

    private DecorationDao decorationDao;

    @Override
    public List<Decoration> findAllDecorations() {
        return decorationDao.findAll();
    }

    @Override
    public List<String> findAllTagsByIdDecoration(Long decorationId) {
        return decorationDao.findAllTagsByDecorationId(decorationId);
    }

    @Override
    public Float findCurrentPriceByDecoration(Long decorationId) {
        return decorationDao.findCurrentPriceByDecorationId(decorationId);
    }

    @Autowired
    public void setDecorationDao(DecorationDao decorationDao) {
        this.decorationDao = decorationDao;
    }
}
