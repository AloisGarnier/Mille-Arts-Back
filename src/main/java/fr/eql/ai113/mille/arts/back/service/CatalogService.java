package fr.eql.ai113.mille.arts.back.service;

import fr.eql.ai113.mille.arts.back.entity.Decoration;

import java.util.List;

public interface CatalogService {

    List<Decoration> findAllDecorations();
    List<Decoration> findDecorationsByResearch(String research);
    Decoration findDecorationById(Long decorationId);
    List<String> findAllTagsByIdDecoration(Long decorationId);
    Float findCurrentPriceByDecoration(Long decorationId);
}
