package com.example.rubrica.rubrica.repository;

import com.example.rubrica.rubrica.entity.Contatto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ContattiRepository extends JpaRepository<Contatto, Long> {
    List<Contatto> findByNomeAndCognomeAndTelefonoAndEmail(String nome, String cognome, String telefono, String email);

    List<Contatto> findByNomeAndCognomeAndTelefono(String nome, String cognome, String telefono);

    List<Contatto> findByNomeAndCognomeAndEmail(String nome, String cognome, String email);

    List<Contatto> findByNomeAndTelefonoAndEmail(String nome, String telefono, String email);

    List<Contatto> findByCognomeAndTelefonoAndEmail(String cognome, String telefono, String email);

    List<Contatto> findByNomeAndCognome(String nome, String cognome);

    List<Contatto> findByNomeAndTelefono(String nome, String telefono);

    List<Contatto> findByNomeAndEmail(String nome, String email);

    List<Contatto> findByCognomeAndTelefono(String cognome, String telefono);

    List<Contatto> findByCognomeAndEmail(String cognome, String email);

    List<Contatto> findByTelefonoAndEmail(String telefono, String email);

    List<Contatto> findByNome(String nome);

    List<Contatto> findByCognome(String cognome);

    List<Contatto> findByTelefono(String telefono);

    List<Contatto> findByEmail(String email);
}
