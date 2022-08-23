package com.example.hrproject.Services;

import com.example.hrproject.Entities.*;
import com.example.hrproject.Repositories.*;
import com.example.hrproject.modals.CollabDTO;
import com.example.hrproject.modals.CollabStatusDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class CollaborateurService {

    private final CollaborateurRepository collaborateursRepository;

    private final DiplomeRepository diplomeRepository;

    private final CompetenceRepository competenceRepository;

    private final SalaireRepository salaireRepository;
    private final PosteAPPRepository posteAppRepository;
    private final PosteRepository posteRepository;


    public List<Collaborateur> getCollabs() {
        return collaborateursRepository.findAll();
    }

    public CollabDTO getCollab(Long id) {
        return CollabDTO.builder().collab(collaborateursRepository.findByMatricule(id))
                .diplomes(diplomeRepository.findAllByCollaborateur_Matricule(id))
                .competences(competenceRepository.findAllByCollaborateur_Matricule(id))
                .salaires(salaireRepository.findAllByCollaborateur_Matricule(id)).build();
    }

    public List<Diplome> getDiplomes(Long matricule) {
        return diplomeRepository.findAllByCollaborateur_Matricule(matricule);
    }

    public List<Competence> getComptences(Long matricule) {
        return competenceRepository.findAllByCollaborateur_Matricule(matricule);
    }

    @Autowired
    public CollaborateurService(CollaborateurRepository collaborateursRepository, DiplomeRepository diplomeRepository, CompetenceRepository competenceRepository
            , SalaireRepository salaireRepository, PosteAPPRepository postAppRepository, PosteRepository postRepository) {
        this.collaborateursRepository = collaborateursRepository;
        this.diplomeRepository = diplomeRepository;
        this.competenceRepository = competenceRepository;
        this.salaireRepository = salaireRepository;
        this.posteAppRepository = postAppRepository;
        this.posteRepository = postRepository;
    }

    @Transactional
    public void saveCollab(CollabDTO newest) {
        Collaborateur collab = newest.getCollab();
        collab.removeDiplomes();
        diplomeRepository.deleteAll(collab.getDiplomes());
        collab.removeCompetences();
        competenceRepository.deleteAll(collab.getCompetences());
        collab.addDiplomes(newest.getDiplomes());
        collab.addCompetences(newest.getCompetences());
        collab.addSalaires(newest.getSalaires());
        collaborateursRepository.save(collab);
    }


    public List<Salaire> getSalaires(Long id) {
        return salaireRepository.findAllByCollaborateur_Matricule(id);
    }
    public List<Poste> getPosts(Long id) {
        return posteRepository.findAllByCollaborateur_Matricule(id);
    }
    public List<PosteAPP> getPostAPPs(Long id) {
        return posteAppRepository.findAllByCollaborateur_Matricule(id);
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

