package fr.eql.ai113.mille.arts.back.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
public class Picture {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String path;
    @JsonIgnore
    @ManyToOne
    @JoinColumn(referencedColumnName = "id")
    private Decoration decoration;

    /// Getters
    public Long getId() {
        return id;
    }
    public String getPath() {
        return path;
    }
    public Decoration getDecoration() {
        return decoration;
    }

    /// Setters
    public void setId(Long id) {
        this.id = id;
    }
    public void setPath(String path) {
        this.path = path;
    }
    public void setDecoration(Decoration decoration) {
        this.decoration = decoration;
    }
}
