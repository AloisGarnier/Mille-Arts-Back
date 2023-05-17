package fr.eql.ai113.mille.arts.back.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String streetNumber;
    private String street;
    @JsonIgnore
    @ManyToOne
    @JoinColumn(referencedColumnName = "id")
    private Customer customer;
    @ManyToOne
    @JoinColumn(referencedColumnName = "id")
    private City city;
    @JsonIgnore
    @OneToMany(mappedBy = "address", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Command> commands = new ArrayList<>();

    public Address() {

    }

    public Address(String streetNumber, String street, City city) {
        this.streetNumber = streetNumber;
        this.street = street;
        this.city = city;
    }

    /// Getters ///

    public String getName() {
        return name;
    }
    public String getStreetNumber() {
        return streetNumber;
    }
    public String getStreet() {
        return street;
    }
    public City getCity() {
        return city;
    }

    /// Setters ///
    public void setName(String name) {
        this.name = name;
    }
    public void setStreetNumber(String streetNumber) {
        this.streetNumber = streetNumber;
    }
    public void setStreet(String street) {
        this.street = street;
    }
    public void setCity(City city) {
        this.city = city;
    }
}
