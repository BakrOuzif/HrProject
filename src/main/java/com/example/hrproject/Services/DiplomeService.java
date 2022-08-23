package com.example.hrproject.Services;

import com.example.hrproject.Entities.Diplome;
import com.example.hrproject.Repositories.DiplomeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DiplomeService {

    private final DiplomeRepository diplomeRepository;

    public List<Diplome> getDiplomes(Long matricule) {
        return diplomeRepository.findAllByCollaborateur_Matricule(matricule);
    }
    @Autowired
    public DiplomeService(DiplomeRepository diplomeRepository) {
        this.diplomeRepository = diplomeRepository;
    }
}

