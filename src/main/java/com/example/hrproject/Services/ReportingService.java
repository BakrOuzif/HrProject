package com.example.hrproject.Services;

import com.example.hrproject.Entities.*;
import com.example.hrproject.Repositories.*;
import com.example.hrproject.Services.CollaborateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ReportingService {
    @Autowired
    CollaborateurService collaborateurService;
    @Autowired
    CollaborateurRepository collabRepo;
    @Autowired
    CompetenceRepository competenceRepo;
    @Autowired
    DiplomeRepository diplomeRepo;

    public List<Salaire> getSalaires(Long id) {
        return collaborateurService.getSalaires(id);
    }
    public List<Poste> getPosts(Long id) {
        return collaborateurService.getPosts(id);
    }
    public List<PosteAPP> getPostAPPs(Long id) {
        return collaborateurService.getPostAPPs(id);
    }

    public List<Diplome> getDiplomes(Long id) {
        return collaborateurService.getDiplomes(id);
    }
    public List<Diplome> getDiplomes() {
        return diplomeRepo.findAll();
    }

    public List<Competence> getComptences(Long id) {
        return collaborateurService.getComptences(id);
    }
    public List<Competence> getComptences() {
        return competenceRepo.findAll();
    }

    public Map<Character,Integer> getSexe() {
        Map<Character,Integer> res = new HashMap<>(2);
        List<Collaborateur> collabF=collabRepo.getAllBySexeIs('F');
        List<Collaborateur> collabM=collabRepo.getAllBySexeIs('M');
        res.put('F',collabF.size());
        res.put('M',collabM.size());
        return res;
    }

}