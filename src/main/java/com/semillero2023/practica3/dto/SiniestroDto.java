package com.semillero2023.practica3.dto;

import java.util.Date;

import lombok.Data;

@Data
public class SiniestroDto {
	
	private Integer idSiniestro;
	
	private Date fechaSiniestro;
	
	private String causas;
	
	private String aceptado;
	
	private Double indemnizacion;
	
	private Integer seguro;
	
	private Integer dniPerito;	
	

}
