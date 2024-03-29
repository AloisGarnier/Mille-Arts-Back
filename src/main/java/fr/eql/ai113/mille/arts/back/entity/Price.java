package fr.eql.ai113.mille.arts.back.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Price {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Float amount;
    @JsonIgnore
    @OneToMany(mappedBy = "price", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<DecorationPrice> decorationPrices = new ArrayList<>();

    public Price() {

    }

    public Price(Float amount) {
        this.amount = amount;
    }

    // Getters //
    public Float getAmount() {
        return amount;
    }

    // Setters //
    public void setAmount(Float amount) {
        this.amount = amount;
    }
}
