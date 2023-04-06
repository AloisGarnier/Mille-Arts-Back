package fr.eql.ai113.mille.arts.back.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class DecorationTag {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @JsonIgnore
    @ManyToOne
    @JoinColumn(referencedColumnName = "id")
    private Decoration decoration;
    @ManyToOne
    @JoinColumn(referencedColumnName = "id")
    private Tag tag;

    // Getters //
    public Tag getTag() {
        return tag;
    }

    // Setters //
    public void setTag(Tag tag) {
        this.tag = tag;
    }
}
