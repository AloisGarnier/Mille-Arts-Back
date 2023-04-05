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
import java.util.List;

@Entity
public class Decoration {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String picture;
    private Long preparationDelay;
    private LocalDate additionDate;
    private LocalDate withdrawalDate;
    @JsonIgnore
    @OneToMany(mappedBy = "decoration", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<DecorationPrice> decorationPrices = new ArrayList<>();
    @JsonIgnore
    @OneToMany(mappedBy = "decoration", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<DecorationStock> decorationStocks = new ArrayList<>();
    @JsonIgnore
    @OneToMany(mappedBy = "decoration", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<DecorationTag> decorationTags = new ArrayList<>();

    /// Accesseurs ///
    public Long getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public String getPicture() {
        return picture;
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
    public List<DecorationPrice> getDecorationPrices() {
        return decorationPrices;
    }
    public List<DecorationStock> getDecorationStocks() {
        return decorationStocks;
    }

    /// Mutateurs ///
    public void setId(Long id) {
        this.id = id;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setPicture(String picture) {
        this.picture = picture;
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
    public void setDecorationPrices(List<DecorationPrice> decorationPrices) {
        this.decorationPrices = decorationPrices;
    }
    public void setDecorationStocks(List<DecorationStock> decorationStocks) {
        this.decorationStocks = decorationStocks;
    }
    public void setDecorationTags(List<DecorationTag> decorationTags) {
        this.decorationTags = decorationTags;
    }
}
