package com.example.rubrica.rubrica.service;


import com.example.rubrica.rubrica.entity.Tessera;
import com.example.rubrica.rubrica.repository.TesseraRepository;
import org.springframework.stereotype.Service;



import lombok.AllArgsConstructor;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class TesseraService {
    private final TesseraRepository tesseraRepository;

    public Tessera save(Tessera tessera) {

        tesseraRepository.save(tessera);
        return tessera;
    }

    public List<Tessera> getAll() {
        return tesseraRepository.findAll();
    }

	public Optional<Tessera> getByCodice(Long codiceTessera) {
		return tesseraRepository.findByCodiceTessera(codiceTessera);
	}

    public Tessera getById(Long id) {
        return tesseraRepository.findById(id).get();
    }

    public void deleteById(Long id) {
        tesseraRepository.deleteById(id);
    }
}
