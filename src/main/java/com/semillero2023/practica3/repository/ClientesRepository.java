package com.semillero2023.practica3.repository;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.semillero2023.mi_libreria.entity.Clientes;


@Repository("ClientesRepository")
public interface ClientesRepository extends JpaRepository<Clientes, Serializable>{
	
	public Optional<Clientes> findBydniCl(Integer dniCl);
	
	public List<Clientes> findByNombreClStartingWith(String nombreCl);
	
	public List<Clientes> findByCiudadLike(String ciudad);
}
