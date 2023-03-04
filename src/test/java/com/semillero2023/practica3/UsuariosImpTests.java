package com.semillero2023.practica3;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.fail;

import org.apache.juli.logging.Log;
import org.apache.juli.logging.LogFactory;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import com.semillero2023.practica3.entity.Usuario;
import com.semillero2023.practica3.ws.ClientesService;
import com.semillero2023.practica3.ws.UsuarioServices;

@SpringBootTest
class UsuariosImpTests {
	
	@Autowired
	UsuarioServices usuarioService;

	private static final Log LOG = LogFactory.getLog(ClientesService.class);
	
	
	@Test
	void loginTest() {

		try {
			Usuario temp = new Usuario();
			temp.setUsername("test");
			temp.setPassword("test");

			
			ResponseEntity<Object> c = usuarioService.loginUser(temp);
			
			assertNotNull(c, "Cliente logeado exitosamaente");
		} catch (Exception e) {
			LOG.error(e.getMessage());
			fail("No se pudo logeado el usuario");
		}

	}
	
}
