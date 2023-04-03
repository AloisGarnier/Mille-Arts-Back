package fr.eql.ai113.mille.arts.back.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Decoration {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Long preparationDelay;
    private LocalDate additionDate;
    private LocalDate withdrawalDate;
    @JsonIgnore
    @OneToMany(mappedBy = "decoration", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<DecorationPrice> decorationPrices = new ArrayList<>();
    @JsonIgnore
    @OneToMany(mappedBy = "decoration", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<DecorationStock> decorationStocks = new ArrayList<>();
    @JsonIgnore
    @OneToMany(mappedBy = "decoration", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<DecorationTag> decorationTags = new ArrayList<>();
}
