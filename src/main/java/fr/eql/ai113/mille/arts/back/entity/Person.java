package fr.eql.ai113.mille.arts.back.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import java.time.LocalDate;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "person_type")
public abstract class Person implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String lastName;
    private String firstName;
    private LocalDate birthDate;
    private String email;
    @JsonIgnore
    private String password;
    private LocalDate additionDate;
    private LocalDate withdrawalDate;

    public Person() {
    }

    public Person(String email, String password) {
        this.email = email;
        this.password = password;
    }

    @Override
    public String getUsername() {
        return email;
    }

    /// Getters ///
    public Long getId() {
        return id;
    }
    public String getLastName() {
        return lastName;
    }
    public String getFirstName() {
        return firstName;
    }
    public String getEmail() {
        return email;
    }
    public String getPassword() {
        return password;
    }

    /// Setters ///
    public void setEmail(String email) {
        this.email = email;
    }
    public void setPassword(String password) {
        this.password = password;
    }

}
