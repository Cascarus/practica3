package com.semillero2023.practica3.ws;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.semillero2023.practica3.config.JwtGeneratorInterface;
import com.semillero2023.practica3.repository.UsuarioRepository;
import com.semillero2023.practica3.wsint.UsuarioServicesInt;
import com.semillero2023.practica3.entity.Usuario;

@Component
public class UsuarioServices implements UsuarioServicesInt{
	
	private static final Log LOG = LogFactory.getLog(UsuarioServices.class);

	@Autowired
	UsuarioRepository usuarioRepository;
	
	@Autowired
	JwtGeneratorInterface jwtGenerator;
	
	@Override
	public ResponseEntity<Object> loginUser(Usuario user) {
		try {
			if (user.getUsername() == null || user.getPassword() == null) {
				return new ResponseEntity<>("UserName or Password is Empty", HttpStatus.NOT_ACCEPTABLE);
			}
			Usuario userData = usuarioRepository.findByUsernameAndPassword(user.getUsername(), user.getPassword());
			if (userData == null) {
				return new ResponseEntity<>("UserName or Password is Invalid", HttpStatus.NOT_ACCEPTABLE);
			}
			return new ResponseEntity<>(jwtGenerator.generateToken(user), HttpStatus.OK);
		} catch (Exception e) {
			LOG.error(e.getStackTrace());
			return new ResponseEntity<>(e.getMessage(), HttpStatus.CONFLICT);
		}
	}

}
