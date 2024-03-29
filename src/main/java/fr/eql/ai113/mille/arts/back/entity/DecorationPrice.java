package fr.eql.ai113.mille.arts.back.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.time.LocalDate;

@Entity
public class DecorationPrice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate additionDate;
    private LocalDate withdrawalDate;
    @JsonIgnore
    @ManyToOne
    @JoinColumn(referencedColumnName = "id")
    private Decoration decoration;
    @ManyToOne
    @JoinColumn(referencedColumnName = "id")
    private Price price;

    // Getters //
    public Price getPrice() {
        return price;
    }
    public LocalDate getWithdrawalDate() {
        return withdrawalDate;
    }
    public LocalDate getAdditionDate() {
        return additionDate;
    }
    public Decoration getDecoration() {
        return decoration;
    }

    // Setters //
    public void setPrice(Price price) {
        this.price = price;
    }
    public void setWithdrawalDate(LocalDate withdrawalDate) {
        this.withdrawalDate = withdrawalDate;
    }
    public void setAdditionDate(LocalDate additionDate) {
        this.additionDate = additionDate;
    }
    public void setDecoration(Decoration decoration) {
        this.decoration = decoration;
    }
}
