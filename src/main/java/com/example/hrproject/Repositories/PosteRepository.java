package com.example.hrproject.Repositories;

import com.example.hrproject.Entities.Poste;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PosteRepository extends JpaRepository<Poste, Long> {
    List<Poste> findAllByCollaborateur_Matricule(Long id);

}