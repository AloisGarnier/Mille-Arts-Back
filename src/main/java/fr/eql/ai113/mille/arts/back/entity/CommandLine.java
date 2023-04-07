package fr.eql.ai113.mille.arts.back.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class CommandLine {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long quantity;
    @ManyToOne
    @JoinColumn(referencedColumnName = "id")
    private Decoration decoration;
    @ManyToOne
    @JoinColumn(referencedColumnName = "id")
    private Command command;

    /// Getters ///
    public Long getQuantity() {
        return quantity;
    }
    public Decoration getDecoration() {
        return decoration;
    }

    /// Setters ///
    public void setQuantity(Long quantity) {
        this.quantity = quantity;
    }
    public void setDecoration(Decoration decoration) {
        this.decoration = decoration;
    }

}
