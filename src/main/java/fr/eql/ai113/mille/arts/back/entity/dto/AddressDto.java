package fr.eql.ai113.mille.arts.back.entity.dto;

import fr.eql.ai113.mille.arts.back.entity.City;

public class AddressDto {

    private String streetNumber;
    private String street;
    private City city;

    /// Getters ///
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
