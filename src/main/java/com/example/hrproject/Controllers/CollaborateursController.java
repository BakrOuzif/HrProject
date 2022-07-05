package com.example.hrproject.Controllers;

import com.example.hrproject.Entities.Collaborateur;
import com.example.hrproject.Services.CollaborateursService;
import com.example.hrproject.modals.CollabDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class CollaborateursController {

    private final CollaborateursService collaborateursService;

    @GetMapping
    public String welcome(@ModelAttribute CollabDTO collabDTO){
        return "AjoutCollab";
    }

    @Autowired
    public CollaborateursController(CollaborateursService collaborateursService) {
        this.collaborateursService = collaborateursService;
    }

    @GetMapping("/getAll")
    public List<Collaborateur> getCollabs (){
        return collaborateursService.getCollabs();
    }

    @PostMapping("/saveCollab")
    public String saveCollab (@ModelAttribute CollabDTO collabDTO){
        collaborateursService.saveCollab(collabDTO);
        return "Collab Saved !";
    }
}
