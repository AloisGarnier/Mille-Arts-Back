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
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
public class Command {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate orderDate;
    private LocalDate realizationDate;
    private LocalDate deliveryDate;
    @ManyToOne
    @JoinColumn(referencedColumnName = "id")
    private Address address;
    @ManyToOne
    @JoinColumn(referencedColumnName = "id")
    private Customer customer;
    @OneToMany(mappedBy = "command", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<CommandLine> commandLines = new HashSet<>();

    /// Getters ///
    public Customer getCustomer() {
        return customer;
    }
    public Set<CommandLine> getCommandLines() {
        return commandLines;
    }

    /// Setters ///
    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
    public void setCommandLines(Set<CommandLine> commandLines) {
        this.commandLines = commandLines;
    }
}
