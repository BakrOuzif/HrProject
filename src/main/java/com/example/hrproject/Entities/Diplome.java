package com.example.hrproject.Entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table
public class Diplome {
    @Id
    @SequenceGenerator(
            name = "diplomes_sequence",
            sequenceName = "diplomes_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "diplomes_sequence"
    )
    private int diplomeID;
    private String niveau;
    private String typeDiplome;
    private String ecole;
    private String typeEcole;
    private String promotion;

    @ManyToOne(cascade = CascadeType.PERSIST,fetch = FetchType.LAZY)
    @JoinColumn(name="matricule", nullable = false)
    private Collaborateur collaborateur;

}
