package com.semillero2023.practica3.ws;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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

import com.semillero2023.practica3.dto.SegurosDto;
import com.semillero2023.mi_libreria.entity.Seguros;
import com.semillero2023.practica3.repository.SegurosRepository;
import com.semillero2023.practica3.wsint.SegurosServicesInt;

@Component
public class SegurosService implements SegurosServicesInt{

	@Autowired
	SegurosRepository segurosRepository;
	
	private ModelMapper modelMapper = new ModelMapper();
	
	@Override
	public String test() {
		return "Todo bien desde Seguros Services :D";
	}

	@Override
	public List<Seguros> verTodos() {
		
		return segurosRepository.findAll();
	}

	@Override
	public Seguros addSeguro(SegurosDto seguroDto) {
		Seguros nuevo = modelMapper.map(seguroDto, Seguros.class);
		return segurosRepository.save(nuevo);
	}

	@Override
	public Seguros modificarSeguro(SegurosDto seguroDto) {
		return addSeguro(seguroDto);
	}

	@Override
	public ResponseEntity<String> deleteSeguro(Integer noPoliza) {
		Optional<Seguros> seguro = segurosRepository.findById(noPoliza);
		
		if(seguro.isPresent()) {
			segurosRepository.delete(seguro.get());
			return new ResponseEntity<>("El seguro se ha eliminado exitosamente",  HttpStatus.OK);
		}
		
		return new ResponseEntity<>("El seguro no existe",  HttpStatus.NOT_FOUND);
	}

	@Override
	public Page<Seguros> buscarPorFechaVencimiento(String fecha, Integer page, Integer size) throws ParseException {
		Date temp = new SimpleDateFormat("yyyy-MM-dd").parse(fecha);
		Pageable paging = PageRequest.of(page, size);
		return segurosRepository.findByfechaVencimientoBefore(temp, paging);
	}

	@Override
	public List<Seguros> buscarPorRamo(String ramo) {
		return segurosRepository.findByRamoLike(ramo);
	}
	
	@Override
	public Page<Seguros> buscarPorFechaInicio(String fecha, Integer page, Integer size) throws ParseException {
		Date temp = new SimpleDateFormat("yyyy-MM-dd").parse(fecha);
		Pageable paging = PageRequest.of(page, size);
		return segurosRepository.findByfechaInicio(temp, paging);
	}

}
