package com.semillero2023.practica3.ws;

import java.util.List;
import java.util.Optional;

import org.apache.juli.logging.Log;
import org.apache.juli.logging.LogFactory;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.semillero2023.practica3.config.JwtGeneratorImpl;
import com.semillero2023.practica3.dto.ClientesDto;
import com.semillero2023.mi_libreria.entity.Clientes;
import com.semillero2023.practica3.repository.ClientesRepository;
import com.semillero2023.practica3.repository.SegurosRepository;
import com.semillero2023.practica3.wsint.ClientesServiceInt;

@Component
public class ClientesService implements ClientesServiceInt {
	private static final Log LOG = LogFactory.getLog(JwtGeneratorImpl.class);
	@Autowired
	ClientesRepository clientesRepository;

	@Autowired
	SegurosRepository segurosRepository;

	private ModelMapper modelMapper = new ModelMapper();

	@Override
	public String test() {
		return "Todo bien todo correcto desde clientes";
	}

	@Override
	public List<Clientes> verTodos() {
		return clientesRepository.findAll();
	}

	@Override
	public Clientes addCliente(ClientesDto cliente) {
		Clientes nuevo = modelMapper.map(cliente, Clientes.class);
		LOG.info(String.format("Se ha creado un nuevo cliente con el nombre %s y telefono %s", nuevo.getNombreCl(),
				nuevo.getTelefono()));
		return clientesRepository.save(nuevo);
	}

	@Override
	public Clientes modificarCliente(ClientesDto clientedto) {

		return addCliente(clientedto);

	}

	@Override
	public ResponseEntity<String> deleteCliente(Integer dni) {
		Optional<Clientes> client = clientesRepository.findBydniCl(dni);

		if (client.isPresent()) {
			segurosRepository.deleteAll(client.get().getSeguros());
			clientesRepository.delete(client.get());
			return new ResponseEntity<>("El cliente se ha eliminado exitosamente", HttpStatus.OK);
		}

		return new ResponseEntity<>("El cliente no existe", HttpStatus.NOT_FOUND);
	}

	@Override
	public List<Clientes> buscarPorNombre(String nombre) {
		return clientesRepository.findByNombreClStartingWith(nombre.replace("+", " "));
	}

	@Override
	public List<Clientes> buscarPorCiudad(String ciudad) {
		return clientesRepository.findByCiudadLike(ciudad.replace("+", " "));
	}

}
