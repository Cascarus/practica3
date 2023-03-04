package com.semillero2023.practica3.repository;

import java.io.Serializable;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.semillero2023.practica3.entity.Siniestros;

@Repository("SiniestrosRepository")
public interface SiniestrosRepository extends JpaRepository<Siniestros, Serializable>{
	
	public Page<Siniestros> findByAceptadoLike(String aceptado, Pageable pageable);
}
