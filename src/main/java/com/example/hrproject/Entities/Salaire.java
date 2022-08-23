package com.example.hrproject.Entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table()
@Getter
@Setter
public class Salaire {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String dateSalaire;
    @Column
    private Double salaire;

    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "matricule", nullable = false)
    private Collaborateur collaborateur;


}