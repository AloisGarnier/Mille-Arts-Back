package fr.eql.ai113.mille.arts.back.entity.dto;

import fr.eql.ai113.mille.arts.back.entity.City;

public class AddressDto {

    private Long id;
    private String name;
    private String streetNumber;
    private String street;
    private String zipCode;
    private String cityName;

    /// Getters ///

    public Long getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public String getStreetNumber() {
        return streetNumber;
    }
    public String getStreet() {
        return street;
    }
    public String getZipCode() {
        return zipCode;
    }
    public String getCityName() {
        return cityName;
    }

    /// Setters ///
    public void setId(Long id) {
        this.id = id;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setStreetNumber(String streetNumber) {
        this.streetNumber = streetNumber;
    }
    public void setStreet(String street) {
        this.street = street;
    }
    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }
    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

}
