package com.example.rubrica.rubrica.repository;

import com.example.rubrica.rubrica.entity.Bevanda;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;



import java.util.Optional;

@Repository
public interface BevandaRepository extends JpaRepository<Bevanda, Long> {

	@Query(nativeQuery = true, value = "SELECT * FROM bevande WHERE codice = :codice")
	Optional<Bevanda> findByCodice(String codice);

	Bevanda findById(long id);

}
