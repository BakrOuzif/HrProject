package com.example.hrproject.Entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AccessLevel;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.security.NoSuchAlgorithmException;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.security.SecureRandom;

@Entity
@Table(name="Collaborateur")
@Getter
@Setter
public class Collaborateur {
    @Id
    private int matricule;
    private int matriculeRH;
    private String nom;
    private String prenom;
    @Getter(value = AccessLevel.NONE)
    @Setter(value = AccessLevel.NONE)
    @Transient
    private String abrev;
    private String ancienRH;
    private String nouveauRH;
    private String site;
    private String sexe;
    private String bu;
    @JsonFormat(pattern="dd/MM/yyyy")
    private LocalDate embauche;
    @Getter(value = AccessLevel.NONE)
    @Setter(value = AccessLevel.NONE)
    @Transient
    private int bap;
    @JsonFormat(pattern="dd/MM/yyyy")
    private LocalDate depart;
    private boolean ancienCollab;
    private boolean seminaire;
    private boolean active;
    @JsonFormat(pattern="dd/MM/yyyy")
    private LocalDate dateSeminaire;
    private  String poste;
    private  String posteAPP;
    private double salaire;
    @OneToMany(mappedBy = "collaborateur",cascade = CascadeType.ALL)
    @Getter(value = AccessLevel.NONE)
    @Setter(value = AccessLevel.NONE)
    private Set<Competence> competences = new HashSet<>();
    @OneToMany(mappedBy = "collaborateur",cascade = CascadeType.ALL)
    @Getter(value = AccessLevel.NONE)
    @Setter(value = AccessLevel.NONE)
    private Set<Diplome> diplomes = new HashSet<>();
    @Getter(value = AccessLevel.NONE)
    @Setter(value = AccessLevel.NONE)
    @Transient
    SecureRandom sr = new SecureRandom();
    public Collaborateur() throws NoSuchAlgorithmException {
        this.matricule = sr.nextInt();
    }

    public int getBap() {
        return embauche.getDayOfMonth()>= 15 ? embauche.getMonthValue()+1 :embauche.getMonthValue() ;
    }

    public void setBap(int bap) {
        this.bap = bap;
    }
    public void addCompetences(List<Competence> competences1){
        for(Competence com : competences1) {
            com.setCollaborateur(this);
            competences.add(com);
        }
    }
    public void removeCompetence(List<Competence> competences1){
        for(Competence com : competences1) {
            com.setCollaborateur(null);
            competences.remove(com);
        }
    }
    public void addDiplomes(List<Diplome> diplomes1){
        System.out.println(diplomes1.size());
        for(Diplome dip : diplomes1){
            dip.setCollaborateur(this);
            diplomes.add(dip);
        }
    }
    public void removeDiplome(List<Diplome> diplomes1){
        for(Diplome dip : diplomes1) {
            dip.setCollaborateur(null);
            diplomes.remove(dip);
        }
    }
    public String getAbrev() {
        return prenom.charAt(0)+nom.substring(0,2);
    }
    public void setAbrev(String abrev) {
        this.abrev = abrev;
    }
}
