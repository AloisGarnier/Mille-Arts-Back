package fr.eql.ai113.mille.arts.back.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.time.LocalDate;

@Entity
public class DecorationStock {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate additionDate;
    private LocalDate withdrawalDate;
    @ManyToOne
    @JoinColumn(referencedColumnName = "id")
    private Decoration decoration;
    @ManyToOne
    @JoinColumn(referencedColumnName = "id")
    private Stock stock;
}
