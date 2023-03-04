package com.semillero2023.practica3.wsint;

import java.text.ParseException;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.semillero2023.practica3.dto.SegurosDto;
import com.semillero2023.practica3.entity.Seguros;

@CrossOrigin
@RestController
@RequestMapping("/seguros")
public interface SegurosServicesInt {

	@GetMapping("/")
	public String test();

	@GetMapping("/verTodos")
	public List<Seguros> verTodos();

	@PostMapping("/crearSeguro")
	public Seguros addSeguro(@RequestBody SegurosDto seguroDto);

	@PutMapping("/modificarSeguro")
	public Seguros modificarSeguro(@RequestBody SegurosDto seguroDto);

	@DeleteMapping("/eliminarSeguro/{noPoliza}")
	public ResponseEntity<String> deleteSeguro(@PathVariable("noPoliza") Integer noPoliza);

	@GetMapping("/buscarPorFechaVencimiento")
	public Page<Seguros> buscarPorFechaVencimiento(
			@RequestParam(name = "fecha") String fecha,
			@RequestParam(name="page") Integer page,
			@RequestParam(name="size") Integer size) throws ParseException;
	
	@GetMapping("/buscarPorRamo/{ramo}")
	public List<Seguros> buscarPorRamo(@PathVariable("ramo") String ramo);
	
	@GetMapping("/buscarPorFechaInicio")
	public Page<Seguros> buscarPorFechaInicio(
			@RequestParam(name = "fecha") String fecha,
			@RequestParam(name="page") Integer page,
			@RequestParam(name="size") Integer size) throws ParseException;
}
