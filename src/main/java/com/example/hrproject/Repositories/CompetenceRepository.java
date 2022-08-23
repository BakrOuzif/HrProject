package com.example.hrproject.Repositories;

import com.example.hrproject.Entities.Competence;
import com.example.hrproject.Entities.Diplome;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CompetenceRepository extends JpaRepository<Competence, Long> {
    List<Competence> findAllByCollaborateur_Matricule(Long matricule);

}
