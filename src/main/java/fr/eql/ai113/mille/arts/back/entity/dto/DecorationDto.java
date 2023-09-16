package fr.eql.ai113.mille.arts.back.entity.dto;

import java.util.List;

public class DecorationDto {

    private Long id;
    private String name;
    private String picture;
    private String description;
    private Long preparationDelay;
    private Float price;
    private List<String> tags;

    /// Getters ///
    public Long getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public String getPicture() {
        return picture;
    }
    public String getDescription() {
        return description;
    }
    public Long getPreparationDelay() {
        return preparationDelay;
    }
    public Float getPrice() {
        return price;
    }
    public List<String> getTags() {
        return tags;
    }

    /// Setters ///
    public void setId(Long id) {
        this.id = id;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setPicture(String picture) {
        this.picture = picture;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public void setPreparationDelay(Long preparationDelay) {
        this.preparationDelay = preparationDelay;
    }
    public void setPrice(Float price) {
        this.price = price;
    }
    public void setTags(List<String> tags) {
        this.tags = tags;
    }
}
