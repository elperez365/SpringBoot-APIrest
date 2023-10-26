package com.example.rubrica.rubrica.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "colonne")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Colonna {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private int numeroColonna;
	private String tipoBevanda;
	private int numeroLattine;

}
