package com.example.lastDayProject.controllers;

import com.example.lastDayProject.entities.Acquisto;
import com.example.lastDayProject.entities.Utente;
import com.example.lastDayProject.exceptions.UtenteNotFoundException;
import com.example.lastDayProject.repositories.AcquistoRepository;
import com.example.lastDayProject.repositories.UtenteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/acquisto")
public class AcquistoController {

    @Autowired
    private AcquistoRepository acquistoRepository;

    // questo metodo prende il body di una API contenente i dati di un utente e lo salva nel db
    @PostMapping
    public Acquisto create(@RequestBody Acquisto a) {
        return acquistoRepository.saveAndFlush(a);
    }


    // questo metodo prende in input un id e ritorna l'utente con quell'id
    @GetMapping({"/{id}"})
    public Acquisto getAcquistoById(@PathVariable int id) throws UtenteNotFoundException {
        Optional<Acquisto> a = acquistoRepository.findById(id);
        Acquisto acquisto;
        if (a.isPresent())  { acquisto = a.get(); }
        else {
            throw new UtenteNotFoundException("l'utente con id = " + id + " non è stato trovato nel DB");
        }
        return acquisto;
    }

    // questo metodo ritorna una lista contenente tutti gli utenti
    @GetMapping("/all")
    public List<Acquisto> getAllUtenti() {
        return acquistoRepository.findAll();

    }

    @PutMapping
    public Acquisto updateAcquisto(@RequestBody Acquisto a) throws UtenteNotFoundException {
        return acquistoRepository.saveAndFlush(a);
    }

    @DeleteMapping({"/{id}"})
    public void deleteById(@PathVariable int id) {
        acquistoRepository.deleteById(id);
    }

}
