package fr.eql.ai113.mille.arts.back.controller.rest;

import fr.eql.ai113.mille.arts.back.entity.Decoration;
import fr.eql.ai113.mille.arts.back.service.CatalogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("catalog")
@CrossOrigin(origins = "${front.url}")
public class CatalogRestController {

    CatalogService catalogService;

    @GetMapping("/all")
    public List<Decoration> findAllDecorations() { return catalogService.findAllDecorations(); }

    @GetMapping("/{id}/tags")
    public List<String> findAllTagsByDecorationId(@PathVariable long id) { return catalogService.findAllTagsByIdDecoration(id); }

    @GetMapping("/{id}/price")
    public Float findCurrentPriceByDecoration(@PathVariable long id) { return catalogService.findCurrentPriceByDecoration(id); }

    @Autowired
    public void setCatalogService(CatalogService catalogService) {
        this.catalogService = catalogService;
    }
}
