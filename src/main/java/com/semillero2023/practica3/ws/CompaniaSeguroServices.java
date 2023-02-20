package com.semillero2023.practica3.ws;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.semillero2023.practica3.dto.CompaniaSeguroDto;
import com.semillero2023.practica3.entity.CompaniaSeguro;
import com.semillero2023.practica3.repository.CompaniaSeguroRepository;
import com.semillero2023.practica3.wsint.CompaniaSeguroServicesInt;

@Component
public class CompaniaSeguroServices implements CompaniaSeguroServicesInt{
	
	@Autowired
	CompaniaSeguroRepository compSegRepository;
	
	private ModelMapper modelMapper = new ModelMapper();

	@Override
	public String test() {
		return "Todo bien desde Companias_Seguros Service";
	}

	@Override
	public List<CompaniaSeguro> verTodos() {
		return compSegRepository.findAll();
	}

	@Override
	public CompaniaSeguro addCompaniaSeguro(CompaniaSeguroDto companiaSeguroDto) {
		CompaniaSeguro comSeg = modelMapper.map(companiaSeguroDto, CompaniaSeguro.class);
		return compSegRepository.save(comSeg);
	}

	@Override
	public CompaniaSeguro modificarCompaniaSeguro(CompaniaSeguroDto companiaSeguroDto) {	
		return addCompaniaSeguro(companiaSeguroDto);
	}

	@Override
	public ResponseEntity<String> deleteCompaniaSeguro(Integer id) {
		Optional<CompaniaSeguro> compSeg = compSegRepository.findById(id);
		
		if(compSeg.isPresent()) {
			compSegRepository.delete(compSeg.get());
			return new ResponseEntity<>("El detalle CompaniaSeguro se ha eliminado exitosamente",  HttpStatus.OK);
		}
		
		return new ResponseEntity<>("El detalle CompaniaSeguro no existe",  HttpStatus.NOT_FOUND);
	}

}
