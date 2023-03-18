package com.semillero2023.practica3.ws;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.semillero2023.practica3.dto.CompaniaDto;
import com.semillero2023.mi_libreria.entity.Companias;
import com.semillero2023.practica3.repository.CompaniasRepository;
import com.semillero2023.practica3.wsint.CompaniasServiceInt;

@Component
public class CompaniasService implements CompaniasServiceInt{

	@Autowired
	CompaniasRepository companiaRepository;
	
	private ModelMapper modelMapper = new ModelMapper();
	
	@Override
	public String test() {
		return "Todo bien desde CompaniasService";
	}

	@Override
	public List<Companias> verTodos() {
		
		return companiaRepository.findAll();
	}

	@Override
	public Companias addCompania(CompaniaDto companiaDto) {
		Companias nuevo = modelMapper.map(companiaDto, Companias.class);
		return companiaRepository.save(nuevo);
	}

	@Override
	public Companias modificarCompania(CompaniaDto companiaDto) {
		return addCompania(companiaDto);
	}

	@Override
	public ResponseEntity<String> deleteCompania(String nombre) {
		Optional<Companias> comp = companiaRepository.findById(nombre.replace("+", " "));
		
		if(comp.isPresent()) {
			companiaRepository.delete(comp.get());
			return new ResponseEntity<>("La compania se ha eliminado exitosamente",  HttpStatus.OK);
		}
		
		return new ResponseEntity<>("La compania no existe",  HttpStatus.NOT_FOUND);
	}

	@Override
	public Companias busarPorNombreCompania(String nombre) {
		return companiaRepository.findByNombreCompaniaLike(nombre.replace("+", " "));
	}

	@Override
	public List<Companias> buscarPorCodPostal(Integer codPostal) {
		return companiaRepository.findByCodPostal(codPostal);
	}

}
