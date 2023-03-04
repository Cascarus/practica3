package com.semillero2023.practica3;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.fail;

import java.util.List;

import org.apache.juli.logging.Log;
import org.apache.juli.logging.LogFactory;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import com.semillero2023.practica3.dto.ClientesDto;
import com.semillero2023.practica3.entity.Clientes;
import com.semillero2023.practica3.ws.ClientesService;

@SpringBootTest
class ClientesImpTests {

	@Autowired
	ClientesService clienteService;

	private static final Log LOG = LogFactory.getLog(ClientesService.class);

	@Test
	void verTodosClientesTest() {

		List<Clientes> temp = clienteService.verTodos();
		assertNotNull(temp, "Las personas no existen");

	}

	@Test
	void GrearClientesTest() {

		try {
			ClientesDto cliTemp = new ClientesDto();

			cliTemp.setDniCl(1000);
			cliTemp.setNombreCl("GrearClientesTest");
			
			Clientes c = clienteService.addCliente(cliTemp);
			
			assertNotNull(c, "Cliente guardado");
			
			ResponseEntity<String> del = clienteService.deleteCliente(cliTemp.getDniCl());
			assertNotNull(del, "cliente eliminado");
		} catch (Exception e) {
			LOG.error(e.getMessage());
			fail("No se pudo guardar el usuario");
		}

	}
	
	@Test
	void buscarPorNombreTest() {

		List<Clientes> temp = clienteService.buscarPorNombre("Ana");
		assertNotNull(temp, "Las buscar por nombre funciona");

	}
	
	@Test
	void buscarPorCiudadTest() {

		List<Clientes> temp = clienteService.buscarPorCiudad("Guatemala");
		assertNotNull(temp, "Las buscar por ciudad funciona");

	}

}
