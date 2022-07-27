package com.example.hrproject.Services;

import com.example.hrproject.Entities.Collaborateur;
import com.example.hrproject.Repositories.CollaborateurRepository;
import com.example.hrproject.modals.StatusDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class ManagerRHService {

    private final CollaborateurRepository collaborateursRepository;

    @Autowired
    public ManagerRHService(CollaborateurRepository collaborateursRepository) {
        this.collaborateursRepository = collaborateursRepository;
    }


    public List<Collaborateur> getManagers() {
        return collaborateursRepository.getManagers();
    }
    public List<Collaborateur> getCollabsNonManagers() {
        return collaborateursRepository.getCollabsNonManagers();
    }
    public List<Collaborateur> getCollabsofManager(int matriculeRH) {
        return collaborateursRepository.findCollaborateurByMatriculeRH(matriculeRH);
    }

    public void saveCollabManager(int matricule, int matriculeRH) {
        Collaborateur collab = collaborateursRepository.findByMatricule(matricule);
        collab.setMatriculeRH(matriculeRH);
        collab.setNouveauRH(collab.getNom()+"  "+collab.getPrenom() );
        collaborateursRepository.save(collab);
    }
}
