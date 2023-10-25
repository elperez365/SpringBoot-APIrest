package com.example.rubrica.rubrica.controller;

import com.example.rubrica.rubrica.entity.Contatto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.rubrica.rubrica.service.ContattiService;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1")
public class RubricaApiController {

    @Autowired
    ContattiService contattiService;

    @GetMapping("/contatti")
    List<Contatto> getContatti(){
        return contattiService.getContatti();
    }

    @GetMapping("/contatti/{id}")
    Contatto getContatto(@PathVariable Long id){
        return contattiService.getContatto(id);
    }

    @PostMapping("/contatti")
    Contatto addContatto(@RequestBody Contatto contatto){
        return contattiService.addContatto(contatto);
    }


    @PostMapping("/contatti/{id}")
    Contatto editContatto(@PathVariable Long id, @RequestBody Contatto contatto){
        contatto.setId(id);
        return contattiService.editContatto(contatto);
    }

    @GetMapping("/search")
    List<Contatto> search(
            @RequestParam(required = false) String nome,
            @RequestParam(required = false) String cognome,
            @RequestParam(required = false) String telefono,
            @RequestParam(required = false) String email
    ) {
        return contattiService.genericSearch(nome, cognome, telefono, email);
    }

    @PostMapping("/search")
    List<Contatto> search(@RequestBody Contatto contatto) {
        return contattiService.genericSearch(contatto.getNome(), contatto.getCognome(), contatto.getTelefono(), contatto.getEmail());
    }

    @PostMapping("/searchmap")
    List<Contatto> search(@RequestBody Map<String, String> map) {
        return contattiService.genericSearch(map.get("nome"), map.get("cognome"), map.get("telefono"), map.get("email"));
    }


}
