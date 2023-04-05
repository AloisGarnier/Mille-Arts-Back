package fr.eql.ai113.mille.arts.back.service;

import fr.eql.ai113.mille.arts.back.entity.Decoration;
import fr.eql.ai113.mille.arts.back.entity.Tag;

import java.util.List;

public interface CatalogService {

    List<Decoration> findAllDecorations();
    List<String> findAllTagsByIdDecoration(Long decorationId);
    Float findCurrentPriceByDecoration(Long decorationId);
}
