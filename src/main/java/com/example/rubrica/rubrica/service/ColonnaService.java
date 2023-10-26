package com.example.rubrica.rubrica.service;

import com.example.rubrica.rubrica.entity.Colonna;
import com.example.rubrica.rubrica.repository.ColonnaRepository;
import org.springframework.stereotype.Service;



import lombok.AllArgsConstructor;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ColonnaService {
    private final ColonnaRepository colonnaRepository;

    public Colonna save(Colonna colonna) {
        colonnaRepository.save(colonna);
		return colonna;
	}

	public List<Colonna> getAll() {
		return colonnaRepository.findAll();
	}

	public Optional<Colonna> getByTipoBevanda(String tipoBevanda) {
		return colonnaRepository.findByTipoBevanda(tipoBevanda);
	}


	public Colonna getById(Long id) {
		return colonnaRepository.findById(id).get();
	}


	public void deleteById(Long id) {
		colonnaRepository.deleteById(id);
	}
}
