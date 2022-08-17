package com.example.hrproject.Entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Data
@Table()
@Entity
public class Competence {
    @Id
    @SequenceGenerator(
            name = "competence_sequence",
            sequenceName = "competence_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "competence_sequence"
    )
    private int competenceId;
    private String name;
    private int note;
    @ManyToOne(cascade = CascadeType.PERSIST,fetch = FetchType.LAZY)
    @JsonBackReference
    @JoinColumn(name = "matricule", nullable = false)
    private Collaborateur collaborateur;

    @PreRemove
    public void removeCollab() {
        this.collaborateur = null;
    }
}
