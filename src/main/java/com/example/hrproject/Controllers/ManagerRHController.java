package com.example.hrproject.Controllers;

import com.example.hrproject.Entities.Collaborateur;
import com.example.hrproject.Services.ManagerRHService;
import com.example.hrproject.modals.MatriculeRHDTO;
import com.example.hrproject.modals.Status;
import com.example.hrproject.modals.StatusDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class ManagerRHController {

    private final ManagerRHService managerRhService;

    @Autowired
    public ManagerRHController(ManagerRHService managerRhService) {
        this.managerRhService = managerRhService;
    }

    @GetMapping("/getManagers")
    public List<Collaborateur> getManagers (){
        return managerRhService.getManagers();
    }

    @GetMapping("/getCollabsNonManagers")
    public List<Collaborateur> getCollabsNonManagers (){
        return managerRhService.getCollabsNonManagers();
    }

    @PostMapping("/saveManager")
    public String saveManager (@RequestBody MatriculeRHDTO matricule){
        System.out.println(matricule.toString());
        managerRhService.saveCollabManager(matricule.getMatricule(), matricule.getMatriculeRH());
        return new StatusDTO(Status.Modified).getStatus();
    }
}
