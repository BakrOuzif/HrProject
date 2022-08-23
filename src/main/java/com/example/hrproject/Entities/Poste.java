package com.example.hrproject.Entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@Setter
public class Poste {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String datePost;
    @Column
    private String postName;
    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "matricule", nullable = false)
    private Collaborateur collaborateur;

}