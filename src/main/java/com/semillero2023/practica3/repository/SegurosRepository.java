package com.semillero2023.practica3.repository;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.semillero2023.mi_libreria.entity.Seguros;

@Repository("SegurosRepository")
public interface SegurosRepository extends JpaRepository<Seguros, Serializable>{
	
	Page<Seguros> findByfechaVencimientoBefore(Date fecha, Pageable pageable);
	
	List<Seguros> findByRamoLike(String ramo);
	
	Page<Seguros> findByfechaInicio(Date fecha, Pageable pageable);
}
