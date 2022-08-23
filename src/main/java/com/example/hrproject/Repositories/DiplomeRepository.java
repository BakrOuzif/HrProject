package com.example.hrproject.Repositories;

import com.example.hrproject.Entities.Diplome;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DiplomeRepository extends JpaRepository<Diplome, Long> {
    List<Diplome> findAllByCollaborateur_Matricule(Long matricule);
}
