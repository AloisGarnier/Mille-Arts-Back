package fr.eql.ai113.mille.arts.back.entity.dto;

import fr.eql.ai113.mille.arts.back.entity.Address;

import java.time.LocalDate;

public class AuthRequest {

    private String firstName;
    private String lastName;
    private String phoneNumber;
    private LocalDate birthDate;
    private Address address;
    private String username;
    private String password;

    /// Getters ///

    public String getFirstName() {
        return firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public String getUsername() {
        return username;
    }
    public String getPassword() {
        return password;
    }
    public String getPhoneNumber() {
        return phoneNumber;
    }
    public LocalDate getBirthDate() {
        return birthDate;
    }
    public Address getAddress() {
        return address;
    }


    /// Setters ///
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }
    public void setAddress(Address address) {
        this.address = address;
    }
}
