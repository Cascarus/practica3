package com.semillero2023.practica3.config;

import java.util.Map;

import com.semillero2023.practica3.entity.Usuario;

public interface JwtGeneratorInterface {
	Map<String, String> generateToken(Usuario user);
}
