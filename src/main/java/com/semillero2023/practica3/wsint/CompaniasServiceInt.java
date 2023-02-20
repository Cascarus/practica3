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

import com.semillero2023.practica3.dto.CompaniaDto;
import com.semillero2023.practica3.entity.Companias;

@CrossOrigin
@RestController
@RequestMapping("/companias")
public interface CompaniasServiceInt {
	
	@GetMapping("/")
	public String test();
	
	@GetMapping("/verTodos")
	public List<Companias> verTodos();
	
	@PostMapping("/crearCompania")
	public Companias addCompania(@RequestBody CompaniaDto companiaDto);
	
	@PutMapping("/modificarCompania")
	public Companias modificarCompania(@RequestBody CompaniaDto companiaDto);
	
	@DeleteMapping("/eliminarCompania/{nombre}")
	public ResponseEntity<String> deleteCompania(@PathVariable("nombre") String nombre);
	
	@GetMapping("/busarPorNombreCompania/{nombre}")
	public Companias busarPorNombreCompania(@PathVariable("nombre") String nombre);
	
	@GetMapping("/buscarPorCodPostal/{cod}")
	public List<Companias> buscarPorCodPostal(@PathVariable("cod") Integer cod);
	
}
