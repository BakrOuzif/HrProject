package com.example.hrproject.Controllers;

import com.example.hrproject.Entities.Collaborateur;
import com.example.hrproject.Services.CollaborateurService;
import com.example.hrproject.modals.CollabDTO;
import com.example.hrproject.modals.Status;
import com.example.hrproject.modals.StatusDTO;
import com.google.gson.JsonObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class CollaborateurController {

    private final CollaborateurService collaborateursService;

    @GetMapping
    public String welcome(){
        return "Bonjour !";
    }

    @Autowired
    public CollaborateurController(CollaborateurService collaborateursService) {
        this.collaborateursService = collaborateursService;
    }

    @GetMapping("/getCollabs")
    public List<Collaborateur> getCollabs (){
        return collaborateursService.getCollabs();
    }

    @PostMapping("/saveCollab")
    public String saveCollab (@RequestBody CollabDTO collabDTO){
        System.out.println(collabDTO);
        collaborateursService.saveCollab(collabDTO);
        return new StatusDTO(Status.Saved).getStatus();
    }

}
