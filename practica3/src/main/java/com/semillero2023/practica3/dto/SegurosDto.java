package com.semillero2023.practica3.dto;

import java.util.Date;

import lombok.Data;

@Data
public class SegurosDto {
	
	private Integer numeroPoliza;
	
	private String ramo;
	
	private Date fechaInicio;
	
	private Date fechaVencimiento;
	
	private String condicionesParticulares;
	
	private String observaciones;
	
	private Integer dniCl;
	
}
