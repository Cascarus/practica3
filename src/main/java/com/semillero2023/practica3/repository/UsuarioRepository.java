package com.semillero2023.practica3.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.semillero2023.practica3.entity.Usuario;

@Repository("UsuarioRepository")
public interface UsuarioRepository extends JpaRepository<Usuario, Serializable> {
	public Usuario findByUsernameAndPassword(String correo, String pass);
}
