package com.semillero2023.practica3.wsint;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.semillero2023.mi_libreria.entity.Usuario;

@CrossOrigin
@RestController
@RequestMapping("/publico")
public interface UsuarioServicesInt {
	
	@PostMapping("/login")
	public ResponseEntity<Object>loginUser(@RequestBody Usuario user);
}
