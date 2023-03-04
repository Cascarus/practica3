package com.semillero2023.practica3.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.semillero2023.practica3.entity.Peritos;

@Repository("PeritosRepository")
public interface PeritosRepository extends JpaRepository<Peritos, Serializable>{
	
	public Peritos findByTelefonoContacto(String telefono);
	
	public List<Peritos> findByCodPostal(Integer codPostal);
}
