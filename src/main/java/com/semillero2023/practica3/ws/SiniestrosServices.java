package com.semillero2023.practica3.ws;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.semillero2023.practica3.dto.SiniestroDto;
import com.semillero2023.practica3.entity.Seguros;
import com.semillero2023.practica3.entity.Siniestros;
import com.semillero2023.practica3.repository.SegurosRepository;
import com.semillero2023.practica3.repository.SiniestrosRepository;
import com.semillero2023.practica3.wsint.SiniestrosServicesInt;

@Component
public class SiniestrosServices implements SiniestrosServicesInt{
	
	@Autowired
	SiniestrosRepository siniestroRepository;
	
	@Autowired
	SegurosRepository seguroRepository;
	
	private ModelMapper modelMapper = new ModelMapper();

	@Override
	public String test() {
		return "Todo bien desde Siniestros Services xD";
	}

	@Override
	public List<Siniestros> verTodos() {
		
		return siniestroRepository.findAll();
	}

	@Override
	public Siniestros addSiniestro(SiniestroDto siniestroDto) {
		Siniestros nuevo = modelMapper.map(siniestroDto, Siniestros.class);
		Optional<Seguros> temp = seguroRepository.findById(siniestroDto.getSeguro());
		
		if(temp.isPresent()) {
			nuevo.setSeguro(temp.get());
			return siniestroRepository.save(nuevo);
		}
		return null;
		
	}

	@Override
	public Siniestros modificarSiniestro(SiniestroDto siniestroDto) {
		return addSiniestro(siniestroDto);
	}

	@Override
	public ResponseEntity<String> deleteSiniestro(Integer id) {
		Optional<Siniestros> sin = siniestroRepository.findById(id);
		
		if(sin.isPresent()) {
			siniestroRepository.delete(sin.get());
			return new ResponseEntity<>("El detalle se ha elimidnado exitosamente",  HttpStatus.OK);
		}
		
		return new ResponseEntity<>("El detalle no existe",  HttpStatus.NOT_FOUND);
	}

	@Override
	public Page<Siniestros> buscarPorAceptado(String estado, Integer page, Integer size) {
		Pageable paging = PageRequest.of(page, size);

		if(estado.equalsIgnoreCase("aceptado")) {
			return siniestroRepository.findByAceptadoLike("1", paging);
		}else if(estado.equalsIgnoreCase("rechazado")) {
			return siniestroRepository.findByAceptadoLike("0", paging);
		}
		return null;
	}

}
