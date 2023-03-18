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

import com.semillero2023.practica3.dto.CompaniaSeguroDto;
import com.semillero2023.mi_libreria.entity.CompaniaSeguro;

@CrossOrigin
@RestController
@RequestMapping("/companias_seguros")
public interface CompaniaSeguroServicesInt {
	
	@GetMapping("/")
	public String test();
	
	@GetMapping("/verTodos")
	public List<CompaniaSeguro> verTodos();
	
	@PostMapping("/crearCompaniaSeguro")
	public CompaniaSeguro addCompaniaSeguro(@RequestBody CompaniaSeguroDto companiaSeguroDto);
	
	@PutMapping("/modificarCompaniaSeguro")
	public CompaniaSeguro modificarCompaniaSeguro(@RequestBody CompaniaSeguroDto companiaSeguroDto);
	
	@DeleteMapping("/eliminarCompaniaSeguro/{id}")
	public ResponseEntity<String> deleteCompaniaSeguro(@PathVariable("id") Integer id);
}
