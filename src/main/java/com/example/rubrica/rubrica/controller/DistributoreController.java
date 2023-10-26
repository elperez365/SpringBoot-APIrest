package com.example.rubrica.rubrica.controller;


import com.example.rubrica.rubrica.entity.Bevanda;
import com.example.rubrica.rubrica.entity.Colonna;
import com.example.rubrica.rubrica.entity.Tessera;
import com.example.rubrica.rubrica.service.BevandaService;
import com.example.rubrica.rubrica.service.ColonnaService;
import com.example.rubrica.rubrica.service.TesseraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/distributore")
public class DistributoreController {

    @Autowired
    BevandaService bevandaService;

    @Autowired
    ColonnaService colonnaService;

    @Autowired
    TesseraService tesseraService;

    @GetMapping("/bevande")
    List<Bevanda> getBevande(){
        return bevandaService.getAll();
    }

    @GetMapping("/bevande/{id}")
    Bevanda getBevanda(@PathVariable Long id){
        return bevandaService.getById(id);
    }

    @PostMapping("/bevande")
    Bevanda addBevanda(Bevanda bevanda){
        return bevandaService.save(bevanda);
    }

    @PutMapping("/bevande/{id}")
    Bevanda editBevanda(@PathVariable Long id, @RequestBody Bevanda bevanda){
        bevanda.setId(id);
        return bevandaService.save(bevanda);
    }

    @DeleteMapping("/bevande/{id}")
    void deleteBevanda(@PathVariable Long id){
        bevandaService.deleteById(id);
    }

    @GetMapping("/tessere")
    List<Tessera> getTessere(){
        return tesseraService.getAll();
    }

    @GetMapping("/tessere/{codiceTessera}")
    Tessera getTessera(@PathVariable Long codiceTessera){

        Tessera tfound = tesseraService.getByCodice(codiceTessera).get();
        return tesseraService.getById(tfound.getId());

    }

    @PostMapping("/tessere")
    Tessera addTessera(Tessera tessera){
        return tesseraService.save(tessera);
    }

    @PutMapping("/tessere/{codiceTessera}")
    Tessera editTessera(@PathVariable Long codiceTessera, @RequestBody Tessera tessera){
        tessera.setCodice(codiceTessera);
        return tesseraService.save(tessera);
    }

    @DeleteMapping("/tessere/{codiceTessera}")
    void deleteTessera(@PathVariable Long codiceTessera){
        tesseraService.deleteById(codiceTessera);
    }

    @GetMapping("/colonne")
    List<Colonna> getColonne(){
        return colonnaService.getAll();
    }

    @GetMapping("/colonne/{idColonna}")
    Colonna getColonna(@PathVariable Long idColonna){
        return colonnaService.getById(idColonna);
    }

    @PostMapping("/colonne")
    Colonna addColonna(Colonna colonna){
        return colonnaService.save(colonna);
    }

    @PutMapping("/colonne/{idColonna}")
    Colonna editColonna(@PathVariable Long idColonna, @RequestBody Colonna colonna){
        colonna.setId(idColonna);
        return colonnaService.save(colonna);
    }

    @DeleteMapping("/colonne/{idColonna}")
    void deleteColonna(@PathVariable Long idColonna){
        colonnaService.deleteById(idColonna);
    }








}
