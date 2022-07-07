package com.example.hrproject.Services;

import com.example.hrproject.Entities.Collaborateur;
import com.example.hrproject.Entities.Competence;
import com.example.hrproject.Entities.Diplome;
import com.example.hrproject.Repositories.CollaborateurRepository;
import com.example.hrproject.Repositories.CompetenceRepository;
import com.example.hrproject.Repositories.DiplomeRepository;
import com.example.hrproject.modals.CollabDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class CollaborateurService {

    private final CollaborateurRepository collaborateursRepository;

    private final DiplomeRepository diplomeRepository;

    private final CompetenceRepository competenceRepository;

    public List<Collaborateur> getCollabs() {
        return collaborateursRepository.findAll();
    }

    public List<Diplome> getDiplomes(int matricule) {
        return diplomeRepository.findAllByCollaborateur_Matricule(matricule);
    }

    public List<Competence> getComptences(int matricule) {
        return competenceRepository.findAllByCollaborateur_Matricule(matricule);
    }
    @Autowired
    public CollaborateurService(CollaborateurRepository collaborateursRepository, DiplomeRepository diplomeRepository, CompetenceRepository competenceRepository) {
        this.collaborateursRepository = collaborateursRepository;
        this.diplomeRepository = diplomeRepository;
        this.competenceRepository = competenceRepository;
    }

    public void saveCollab(CollabDTO newest){
        Collaborateur collab = newest.getCollab();
        collab.addDiplomes(newest.getDiplomes());
        collab.addCompetences(newest.getCompetences());
        collaborateursRepository.save(newest.getCollab());
        System.out.println("Saved :) ");
    }
}

