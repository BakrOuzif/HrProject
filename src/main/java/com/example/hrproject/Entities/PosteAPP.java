package com.example.hrproject.Entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table()
@Data
public class PosteAPP {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String datePostAPP;
    @Column
    private String postAppName;
    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "matricule", nullable = false)
    private Collaborateur collaborateur;
}