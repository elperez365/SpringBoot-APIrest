package com.example.rubrica.rubrica.service;

import java.util.List;
import java.util.Optional;


import com.example.rubrica.rubrica.entity.Bevanda;
import com.example.rubrica.rubrica.repository.BevandaRepository;
import org.springframework.stereotype.Service;



import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class BevandaService {
    private final BevandaRepository bevandaRepository;

    public void deleteById(Long id) {
        bevandaRepository.deleteById(id);
    }

    public Bevanda save(Bevanda bevanda) {
        bevandaRepository.save(bevanda);
        return bevanda;
    }

    public Bevanda getById(Long id) {
        return bevandaRepository.findById(id).get();
    }

    public List<Bevanda> getAll() {
        return bevandaRepository.findAll();
    }

    public Optional<Bevanda> getByCodice(String codice) {
        return bevandaRepository.findByCodice(codice);
    }

}
