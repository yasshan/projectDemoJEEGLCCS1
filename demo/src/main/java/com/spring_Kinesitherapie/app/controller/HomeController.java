package com.spring_Kinesitherapie.app.controller;

import com.spring_Kinesitherapie.app.model.Patient;
import com.spring_Kinesitherapie.app.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
public class HomeController {

    @GetMapping("/")
    public String root(){
        return "login";
    }

    @GetMapping("/patients")
    public String listePatients() {
        return "patients"; // Thymeleaf va afficher patients.html
    }
    @GetMapping("/fiches/{patientId}")
    public String Lfiches(@PathVariable Long patientId, Model model) {
        model.addAttribute("patientId", patientId);
        return "fiche"; // Thymeleaf va afficher fiche.html
    }

    @GetMapping("/rendezvous")
    public String rendezvous(){
        return "rendezvous";
    }

    @GetMapping("/paiement")
    public String paiement(){
        return "paiement";
    }

    @GetMapping("/rendezvous2")
    public String rendezvous2(){
        return "rendezvous2";
    }

    @GetMapping("/home")
    public String home(){
        return "home";
    }

    @GetMapping("/login")
    public String login(){
        return "login";
    }

    @GetMapping("/logout")
    public String logout(){
        return "login";
    }

}
