package com.example.hrproject.Repositories;

import com.example.hrproject.Entities.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PosteAPPRepository extends JpaRepository<PosteAPP, Long> {
    List<PosteAPP> findAllByCollaborateur_Matricule(Long id);

}