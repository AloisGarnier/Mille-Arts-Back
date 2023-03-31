package fr.eql.ai113.mille.arts.back.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;

@Entity
public class Person {

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

}
