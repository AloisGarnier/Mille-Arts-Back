package fr.eql.ai113.mille.arts.back.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String streetNumber;
    private String street;
    @ManyToOne
    @JoinColumn(referencedColumnName = "id")
    private City city;
}
