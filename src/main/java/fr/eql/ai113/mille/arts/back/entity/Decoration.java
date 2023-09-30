package fr.eql.ai113.mille.arts.back.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
public class Decoration {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @OneToMany(mappedBy = "decoration", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Picture> pictures = new ArrayList<>();
    private String description;
    private String weight;
    private String dimensions;
    private Long preparationDelay;
    private LocalDate additionDate;
    private LocalDate withdrawalDate;
    @OneToMany(mappedBy = "decoration", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<DecorationPrice> decorationPrices = new HashSet<>();
    @JsonIgnore
    @OneToMany(mappedBy = "decoration", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<CommandLine> commandLines = new HashSet<>();
    @JsonIgnore
    @OneToMany(mappedBy = "decoration", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<DecorationStock> decorationStocks = new HashSet<>();;
    @OneToMany(mappedBy = "decoration", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<DecorationTag> decorationTags = new HashSet<>();

    public Float getPriceAtDate(LocalDate date) {
        for (DecorationPrice price : decorationPrices) {
            if ((price.getWithdrawalDate() == null && date.isAfter(price.getAdditionDate()))
                    || (date.isBefore(price.getWithdrawalDate()) && date.isAfter(price.getAdditionDate()))) {
                return price.getPrice().getAmount();
            }
        }
        return null;
    }

    /// Accesseurs ///
    public Long getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public Long getPreparationDelay() {
        return preparationDelay;
    }
    public LocalDate getAdditionDate() {
        return additionDate;
    }
    public LocalDate getWithdrawalDate() {
        return withdrawalDate;
    }
    public Set<DecorationPrice> getDecorationPrices() {
        return decorationPrices;
    }
    public Set<DecorationStock> getDecorationStocks() {
        return decorationStocks;
    }
    public Set<DecorationTag> getDecorationTags() {
        return decorationTags;
    }
    public String getDescription() {
        return description;
    }
    public List<Picture> getPictures() {
        return pictures;
    }
    public String getWeight() {
        return weight;
    }
    public String getDimensions() {
        return dimensions;
    }


    /// Mutateurs ///
    public void setId(Long id) {
        this.id = id;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setPreparationDelay(Long preparationDelay) {
        this.preparationDelay = preparationDelay;
    }
    public void setAdditionDate(LocalDate additionDate) {
        this.additionDate = additionDate;
    }
    public void setWithdrawalDate(LocalDate withdrawalDate) {
        this.withdrawalDate = withdrawalDate;
    }
    public void setDecorationPrices(Set<DecorationPrice> decorationPrices) {
        this.decorationPrices = decorationPrices;
    }
    public void setDecorationStocks(Set<DecorationStock> decorationStocks) {
        this.decorationStocks = decorationStocks;
    }
    public void setDecorationTags(Set<DecorationTag> decorationTags) {
        this.decorationTags = decorationTags;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public void setPictures(List<Picture> pictures) {
        this.pictures = pictures;
    }
    public void setWeight(String weight) {
        this.weight = weight;
    }
    public void setDimensions(String dimensions) {
        this.dimensions = dimensions;
    }
}
