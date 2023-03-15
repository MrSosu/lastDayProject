package com.example.lastDayProject.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicInsert;

@Data // imposta in automatico getters e setters per la classe
@NoArgsConstructor // imposta in automatico un costruttore senza argomenti
@AllArgsConstructor // imposta in automatico un costruttore con tutti gli argomenti
@Entity // dico che è una entità del progetto
@Table // che metterò in una sua tabella
@DynamicInsert
public class Utente {

    private static final String DEFAULT_EMAIL = "dummy@email.com";

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(nullable = false)
    private String nome;
    @Column(nullable = false)
    private String cognome;
    @Column(nullable = false, unique = true)
    private String email;

}
