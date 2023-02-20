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

import com.semillero2023.practica3.dto.PeritoDto;
import com.semillero2023.practica3.entity.Peritos;

@CrossOrigin
@RestController
@RequestMapping("/perito")
public interface PeritosServiceInt {
	
	@GetMapping("/")
	public String test();
	
	@GetMapping("/verTodos")
	public List<Peritos> verTodo();
	
	@PostMapping("/crearPeritos")
	public Peritos addPeritos(@RequestBody PeritoDto peritoDto);
	
	@PutMapping("/modificarPeritos")
	public Peritos modificarPeritos(@RequestBody PeritoDto peritoDto);
	
	@DeleteMapping("/eliminarPeritos/{id}")
	public ResponseEntity<String> deletePeritos(@PathVariable("id") Integer id);
	
	@GetMapping("/buscarPorTelefonoContacto/{telefono}")
	public Peritos buscarPorTelefonoContacto(@PathVariable("telefono") String telefono);
	
	@GetMapping("/buscarPorCodigoPostal/{postal}")
	public List<Peritos> buscarPorCodigoPostal(@PathVariable("postal") Integer postal);
	

}
