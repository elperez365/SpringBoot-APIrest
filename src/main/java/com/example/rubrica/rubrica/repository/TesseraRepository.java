package com.example.rubrica.rubrica.repository;

import com.example.rubrica.rubrica.entity.Tessera;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;



import java.util.Optional;

@Repository
public interface TesseraRepository extends JpaRepository<Tessera, Long> {

    @Query(nativeQuery = true, value = "SELECT * FROM tessere WHERE codice = :codiceTessera")
    Optional<Tessera> findByCodiceTessera(Long codiceTessera);

    Tessera findById(long id);

    void deleteById(long id);
}
