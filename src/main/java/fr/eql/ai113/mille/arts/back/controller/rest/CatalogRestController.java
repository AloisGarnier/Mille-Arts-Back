package fr.eql.ai113.mille.arts.back.controller.rest;

import fr.eql.ai113.mille.arts.back.entity.Decoration;
import fr.eql.ai113.mille.arts.back.entity.dto.DecorationDto;
import fr.eql.ai113.mille.arts.back.service.CatalogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("catalog")
@CrossOrigin(origins = "${front.url}")
public class CatalogRestController {

    CatalogService catalogService;

    @GetMapping("/all")
    public List<Decoration> findAllDecorations() { return catalogService.findAllDecorations(); }

    @GetMapping("/novelties")
    public List<Decoration> findNovelties() { return catalogService.findNovelties(); }

    @GetMapping("/{research}")
    public List<Decoration> findDecorationsByResearch(@PathVariable String research) {return catalogService.findDecorationsByResearch(research); }

    @GetMapping("/{id}/all")
    public Decoration findDecorationById(@PathVariable long id) { return catalogService.findDecorationById(id);}

    @GetMapping("/{id}/tags")
    public List<String> findAllTagsByDecorationId(@PathVariable long id) { return catalogService.findAllTagsByIdDecoration(id); }

    @GetMapping("/{id}/price")
    public Float findCurrentPriceByDecoration(@PathVariable long id) { return catalogService.findCurrentPriceByDecoration(id); }

    @GetMapping("/{id}/pictures")
    public List<String> findPicturesByDecoration(@PathVariable long id) { return catalogService.findPicturesByDecoration(id); }

    @PutMapping("/modify")
    public Decoration modifyDecoration(@RequestBody DecorationDto decorationDto) { return catalogService.modifyDecoration(
            decorationDto.getId(),
            decorationDto.getName(),
            decorationDto.getPictures(),
            decorationDto.getDescription(),
            decorationDto.getWeight(),
            decorationDto.getDimensions(),
            decorationDto.getPreparationDelay(),
            decorationDto.getPrice(),
            decorationDto.getTags()
            );
    }

    @PostMapping("/create")
    public Decoration createNewDecoration(@RequestBody DecorationDto decorationDto) {
        return catalogService.addDecoration(
                decorationDto.getName(),
                decorationDto.getPictures(),
                decorationDto.getDescription(),
                decorationDto.getWeight(),
                decorationDto.getDimensions(),
                decorationDto.getPreparationDelay(),
                decorationDto.getPrice(),
                decorationDto.getTags()
        );
    }

    @DeleteMapping("/{id}/delete")
    public void deleteDecoration(@PathVariable long id) { catalogService.deleteDecoration(id);}

    @Autowired
    public void setCatalogService(CatalogService catalogService) {
        this.catalogService = catalogService;
    }
}
