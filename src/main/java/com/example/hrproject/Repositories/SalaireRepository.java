package com.example.hrproject.Repositories;

import com.example.hrproject.Entities.Salaire;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SalaireRepository extends JpaRepository<Salaire, Long> {
    List<Salaire> findAllByCollaborateur_Matricule(Long id);
}