package com.example.lastDayProject.controllers;

import com.example.lastDayProject.entities.Utente;
import com.example.lastDayProject.exceptions.UtenteNotFoundException;
import com.example.lastDayProject.repositories.UtenteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/utente")
public class UtenteController {

    @Autowired
    private UtenteRepository utenteRepository;

    // questo metodo prende il body di una API contenente i dati di un utente e lo salva nel db
    @PostMapping
    public Utente create(@RequestBody Utente u) {
        return utenteRepository.saveAndFlush(u);
    }


    // questo metodo prende in input un id e ritorna l'utente con quell'id
    @GetMapping({"/{id}"})
    public Utente getUtenteById(@PathVariable int id) throws UtenteNotFoundException {
        Optional<Utente> u = utenteRepository.findById(id);
        Utente utente;
        if (u.isPresent())  { utente = u.get(); }
        else {
            throw new UtenteNotFoundException("l'utente con id = " + id + " non è stato trovato nel DB");
        }
        return utente;
    }

    // questo metodo ritorna una lista contenente tutti gli utenti
    @GetMapping("/all")
    public List<Utente> getAllUtenti() {
        return utenteRepository.findAll();

    }

    @PutMapping
    public Utente updateUtente(@RequestBody Utente u) throws UtenteNotFoundException {
        Optional<Utente> optionalUtente =  utenteRepository.findById(u.getId());
        Utente utente;
        if (optionalUtente.isPresent())  { utente = optionalUtente.get(); }
        else {
            throw new UtenteNotFoundException("l'utente con id = " + u.getId() + " non è stato trovato nel DB");
        }
        return utenteRepository.saveAndFlush(utente);
    }

    @DeleteMapping({"/{id}"})
    public void deleteById(@PathVariable int id) {
        utenteRepository.deleteById(id);
    }

}
