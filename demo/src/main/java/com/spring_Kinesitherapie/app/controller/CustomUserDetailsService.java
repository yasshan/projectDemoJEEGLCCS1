package com.spring_Kinesitherapie.app.controller;

import com.spring_Kinesitherapie.app.model.Utilisateur;
import com.spring_Kinesitherapie.app.repository.UtilisateurRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {


    @Autowired
    private UtilisateurRepository utilisateurRepository;

    @PostConstruct
    public void init() {
        System.out.println("✅ CustomUserDetailsService chargé !");
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        System.out.println("🔍 Vérification de l'utilisateur: " + username);
        Utilisateur user = utilisateurRepository.findByLogin(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));

        System.out.println("✅ Utilisateur trouvé: " + user.getLogin());

        return org.springframework.security.core.userdetails.User
                .withUsername(user.getLogin())
                .password(user.getMotDePasse())
                .authorities("ROLE_" + user.getRole())
                .build();
    }
}

