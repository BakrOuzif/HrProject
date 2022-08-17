package com.example.hrproject.Services;

import com.example.hrproject.Entities.Collaborateur;
import com.example.hrproject.Entities.Competence;
import com.example.hrproject.Entities.Diplome;
import com.example.hrproject.Repositories.CollaborateurRepository;
import com.example.hrproject.Repositories.CompetenceRepository;
import com.example.hrproject.Repositories.DiplomeRepository;
import com.example.hrproject.modals.CollabDTO;
import com.example.hrproject.modals.CollabStatusDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CollaborateurService {

    private final CollaborateurRepository collaborateursRepository;

    private final DiplomeRepository diplomeRepository;

    private final CompetenceRepository competenceRepository;

    public List<Collaborateur> getCollabs() {
        return collaborateursRepository.findAll();
    }

    public CollabDTO getCollab(int id) {
        return CollabDTO.builder().collab(collaborateursRepository.findByMatricule(id))
                .diplomes(diplomeRepository.findAllByCollaborateur_Matricule(id))
                .competences(competenceRepository.findAllByCollaborateur_Matricule(id)).build();
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

    public void saveCollab(CollabDTO newest) {
        Collaborateur collab = newest.getCollab();
        collab.removeDiplomes();
        diplomeRepository.deleteAll(collab.getDiplomes());
        collab.removeCompetences();
        competenceRepository.deleteAll(collab.getCompetences());
        collab.addDiplomes(newest.getDiplomes());
        collab.addCompetences(newest.getCompetences());
        collaborateursRepository.save(collab);
        System.out.println("Saved :) ");
    }

    @Autowired
    public JavaMailSender emailSender;

    public String sendmail() {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo("afarhane321@gmail.com");
        message.setSubject("Test Simple Email");
        message.setText("Hello, Im testing Simple Email");
        this.emailSender.send(message);

        return "Email Sent!";
    }

    public void saveStatus(CollabStatusDTO status) {
        Collaborateur collab = collaborateursRepository.findByMatricule(status.getMatricule());
        collab.setStatusActif(status.isStatus());
        collaborateursRepository.save(collab);
    }
}

