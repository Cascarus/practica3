package com.semillero2023.practica3;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.fail;

import java.util.List;

import org.apache.juli.logging.Log;
import org.apache.juli.logging.LogFactory;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.semillero2023.practica3.dto.PeritoDto;
import com.semillero2023.mi_libreria.entity.Peritos;
import com.semillero2023.practica3.ws.PeritosService;

@SpringBootTest
class PeritosImpTests {

	@Autowired
	PeritosService peritosService;

	private static final Log LOG = LogFactory.getLog(PeritosService.class);

	@Test
	void verTodosPeritoTest() {

		List<Peritos> temp = peritosService.verTodo();
		assertNotNull(temp, "Las personas no existen");

	}

	@Test
	void loginTest() {

		try {
			PeritoDto nuevo = new PeritoDto();
			nuevo.setDniPerito(1000);

			Peritos temp = peritosService.addPeritos(nuevo);

			assertNotNull(temp, "Perito logeado exitosamaente");
		} catch (Exception e) {
			LOG.error(e.getMessage());
			fail("No se pudo logeado crear el perito");
		}

	}

}
