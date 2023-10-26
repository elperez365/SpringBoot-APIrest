package com.example.rubrica.rubrica.repository;

import com.example.rubrica.rubrica.entity.Colonna;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


import java.util.Optional;

@Repository
public interface ColonnaRepository extends JpaRepository<Colonna, Long> {

	@Query(nativeQuery = true, value = "SELECT * FROM colonne WHERE tipo_bevanda = :tipoBevanda")
	Optional<Colonna> findByTipoBevanda(String tipoBevanda);


	Colonna findById(long id);

}
