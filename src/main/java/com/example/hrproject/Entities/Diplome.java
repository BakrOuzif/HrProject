package com.example.hrproject.Entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

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
    @JsonFormat(pattern="dd/MM/yyyy")
    private LocalDate promotion;

    @ManyToOne(cascade = CascadeType.PERSIST,fetch = FetchType.LAZY)
    @JsonBackReference
    @JoinColumn(name="matricule", nullable = false)
    private Collaborateur collaborateur;

    @PreRemove
    public void removeCollab() {
        this.collaborateur = null;
    }

}
