package fr.eql.ai113.mille.arts.back.service;

import fr.eql.ai113.mille.arts.back.entity.Decoration;

import java.util.List;

public interface CatalogService {

    List<Decoration> findAllDecorations();
    List<Decoration> findDecorationsByResearch(String research);
    Decoration findDecorationById(Long decorationId);
    List<Decoration> findNovelties();
    List<String> findAllTagsByIdDecoration(Long decorationId);
    Float findCurrentPriceByDecoration(Long decorationId);
    List<String> findPicturesByDecoration(Long decorationId);
    Decoration modifyDecoration(Long id, String name, List<String> pictures, String description, String weight, String dimensions, Long preparationDelay, Float price, List<String> tags);
    Decoration addDecoration(String name, List<String> pictures, String description, String weight, String dimensions, Long preparationDelay, Float price, List<String> tags);
    void deleteDecoration(Long id);
}
