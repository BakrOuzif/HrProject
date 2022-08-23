package com.example.hrproject.Controllers;

import com.example.hrproject.Entities.*;
import com.example.hrproject.Services.ReportingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping(value="/rapports")
public class ReportingController {
    @Autowired
    ReportingService reportingService;

    @GetMapping("/salaire/{id}")
    public List<Salaire> getSalaires(@PathVariable(value="id")Long id) {
        return reportingService.getSalaires(id);
    }

    @GetMapping("/postApp/{id}")
    public List<PosteAPP> getPostAPPs(@PathVariable(value="id")Long id) {
        return reportingService.getPostAPPs(id);
    }

    @GetMapping("/poste/{id}")
    public List<Poste> getPosts(@PathVariable(value="id")Long id) {
        return reportingService.getPosts(id);
    }

    @GetMapping("/competence/{id}")
    public List<Competence> getCompetences(@PathVariable(value="id") Long id) {
        return reportingService.getComptences(id);
    }
    @GetMapping("/competences")
    public List<Competence> getCompetences() {
        return reportingService.getComptences();
    }
    @GetMapping("/diplomes")
    public List<Diplome> getDiplomes() {
        return reportingService.getDiplomes();
    }

    @GetMapping("/sexe")
    public Map<Character,Integer> getSexe() {
        return reportingService.getSexe();
    }




}