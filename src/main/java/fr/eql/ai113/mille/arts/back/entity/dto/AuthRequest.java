package fr.eql.ai113.mille.arts.back.entity.dto;

public class AuthRequest {

    private String firstName;
    private String lastName;
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
}
