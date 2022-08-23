package com.example.hrproject.Controllers;

import com.example.hrproject.Entities.Collaborateur;
import com.example.hrproject.Services.CollaborateurService;
import com.example.hrproject.modals.CollabDTO;
import com.example.hrproject.modals.CollabStatusDTO;
import com.example.hrproject.modals.Status;
import com.example.hrproject.modals.StatusDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
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

    @GetMapping("/getCollab/{id}")
    public CollabDTO getCollab (@PathVariable Long id){
        return collaborateursService.getCollab(id);
    }

    @PostMapping("/saveCollab")
    public String saveCollab (@RequestBody CollabDTO collabDTO){
        System.out.println(collabDTO);
        collaborateursService.saveCollab(collabDTO);

        return new StatusDTO(Status.Saved).getStatus();
    }

    @PostMapping("/saveStatus")
    public String saveStatus (@RequestBody CollabStatusDTO status){
        collaborateursService.saveStatus(status);
        return new StatusDTO(Status.Saved).getStatus();
    }

    @PostMapping("/saveNewCollab")
    public String saveNewCollab (@RequestBody CollabDTO collabDTO){
        collaborateursService.saveCollab(collabDTO);
        System.out.println(collaborateursService.sendmail());
        return new StatusDTO(Status.Saved).getStatus();
    }



}
