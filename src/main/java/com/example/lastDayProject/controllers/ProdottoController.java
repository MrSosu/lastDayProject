package com.example.lastDayProject.controllers;

import com.example.lastDayProject.entities.Prodotto;
import com.example.lastDayProject.entities.Utente;
import com.example.lastDayProject.exceptions.UtenteNotFoundException;
import com.example.lastDayProject.repositories.ProdottoRepository;
import com.example.lastDayProject.repositories.UtenteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/prodotto")
public class ProdottoController {

    @Autowired
    private ProdottoRepository prodottoRepository;

    // questo metodo prende il body di una API contenente i dati di un utente e lo salva nel db
    @PostMapping
    public Prodotto create(@RequestBody Prodotto p) {
        return prodottoRepository.saveAndFlush(p);
    }


    // questo metodo prende in input un id e ritorna l'utente con quell'id
    @GetMapping({"/{id}"})
    public Prodotto getProdottoById(@PathVariable int id) throws UtenteNotFoundException {
        Optional<Prodotto> p = prodottoRepository.findById(id);
        Prodotto prodotto;
        if (p.isPresent())  { prodotto = p.get(); }
        else {
            throw new UtenteNotFoundException("l'utente con id = " + id + " non è stato trovato nel DB");
        }
        return prodotto;
    }

    // questo metodo ritorna una lista contenente tutti gli utenti
    @GetMapping("/all")
    public List<Prodotto> getAllProdotti() {
        return prodottoRepository.findAll();

    }

    @PutMapping
    public Prodotto updateProdotto(@RequestBody Prodotto p) throws UtenteNotFoundException {
        return prodottoRepository.saveAndFlush(p);
    }

    @DeleteMapping({"/{id}"})
    public void deleteById(@PathVariable int id) {
        prodottoRepository.deleteById(id);
    }

}
