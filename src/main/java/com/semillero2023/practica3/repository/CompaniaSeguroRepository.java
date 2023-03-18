package com.semillero2023.practica3.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.semillero2023.mi_libreria.entity.CompaniaSeguro;

@Repository("Companias_SegurosRepository")
public interface CompaniaSeguroRepository extends JpaRepository<CompaniaSeguro, Serializable>{
	
}
