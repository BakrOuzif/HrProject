package com.example.hrproject.Repositories;

import com.example.hrproject.Entities.Collaborateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CollaborateurRepository extends
        JpaRepository <Collaborateur, Long> {
        List<Collaborateur> findCollaborateurByMatriculeRH(Long matricule);
        Collaborateur findByMatricule(Long matricule);

        @Query(value = "SELECT * FROM Collaborateur Where matricule in (SELECT DISTINCT matriculeRH FROM Collaborateur)", nativeQuery = true)
        List<Collaborateur> getManagers();

        @Query(value = "SELECT * FROM Collaborateur Where matricule not in (SELECT DISTINCT matriculeRH FROM Collaborateur where matriculeRH is not null)", nativeQuery = true)
        List<Collaborateur> getCollabsNonManagers();

        List<Collaborateur> getAllBySexeIs(char sexe);


}
