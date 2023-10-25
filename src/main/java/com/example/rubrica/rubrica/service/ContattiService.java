package com.example.rubrica.rubrica.service;

import com.example.rubrica.rubrica.entity.Contatto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.rubrica.rubrica.repository.ContattiRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ContattiService {

    @Autowired
    ContattiRepository contattiRepo;

    public List<Contatto> getContatti(){
        return contattiRepo.findAll();
    }

    public Contatto addContatto(Contatto contatto){
        return contattiRepo.save(contatto);
    }

    public Contatto editContatto(Contatto contatto){
        return contattiRepo.save(contatto);
    }

    public Contatto getContatto(Long id){
        Optional<Contatto> opt = contattiRepo.findById(id);
        return opt.orElse(null);
    }

    public List<Contatto> genericSearch(String nome, String cognome, String telefono, String email) {
        boolean nomeCheck = nome != null && !nome.trim().isEmpty();
        boolean cognomeCheck = cognome != null;
        boolean telefonoCheck = telefono != null;
        boolean emailCheck = email != null;

        if (nomeCheck && cognomeCheck && telefonoCheck && emailCheck)return contattiRepo.findByNomeAndCognomeAndTelefonoAndEmail(nome, cognome, telefono, email);
        if (nomeCheck && cognomeCheck && telefonoCheck) return contattiRepo.findByNomeAndCognomeAndTelefono(nome, cognome, telefono);
        if (nomeCheck && cognomeCheck && emailCheck) return contattiRepo.findByNomeAndCognomeAndEmail(nome, cognome, email);
        if (nomeCheck && telefonoCheck && emailCheck) return contattiRepo.findByNomeAndTelefonoAndEmail(nome, telefono, email);
        if (cognomeCheck && telefonoCheck && emailCheck) return contattiRepo.findByCognomeAndTelefonoAndEmail(cognome, telefono, email);
        if (nomeCheck && cognomeCheck) return contattiRepo.findByNomeAndCognome(nome, cognome);
        if (nomeCheck && telefonoCheck) return contattiRepo.findByNomeAndTelefono(nome, telefono);
        if (nomeCheck && emailCheck) return contattiRepo.findByNomeAndEmail(nome, email);
        if (cognomeCheck && telefonoCheck) return contattiRepo.findByCognomeAndTelefono(cognome, telefono);
        if (cognomeCheck && emailCheck) return contattiRepo.findByCognomeAndEmail(cognome, email);
        if (telefonoCheck && emailCheck) return contattiRepo.findByTelefonoAndEmail(telefono, email);
        if (nomeCheck) return contattiRepo.findByNome(nome);
        if (cognomeCheck) return contattiRepo.findByCognome(cognome);
        if (telefonoCheck) return contattiRepo.findByTelefono(telefono);
        if (emailCheck) return contattiRepo.findByEmail(email);

        return getContatti();
    }}
