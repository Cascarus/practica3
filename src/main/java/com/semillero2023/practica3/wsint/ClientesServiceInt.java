package com.semillero2023.practica3.wsint;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.semillero2023.practica3.dto.ClientesDto;
import com.semillero2023.mi_libreria.entity.Clientes;

@CrossOrigin
@RestController
@RequestMapping("/clientes")
public interface ClientesServiceInt {
	
	@GetMapping("/")
	public String test();
	
	@GetMapping("/verTodos")
	public List<Clientes> verTodos();
	
	@PostMapping("/crearCliente")
	public Clientes addCliente(@RequestBody ClientesDto clientedto);
	
	@PutMapping("/modificarCliente")
	public Clientes modificarCliente(@RequestBody ClientesDto clientedto);
	
	@DeleteMapping("/eliminarCliente/{dni}")
	public ResponseEntity<String> deleteCliente(@PathVariable("dni") Integer dni);
	
	@GetMapping("/buscarPorNombre/{nombre}")
	public List<Clientes> buscarPorNombre(@PathVariable("nombre") String nombre);
	
	@GetMapping("/buscarPorCiudad/{ciudad}")
	public List<Clientes> buscarPorCiudad(@PathVariable("ciudad") String ciudad);
}
