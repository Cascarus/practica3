package com.semillero2023.practica3.dto;

import lombok.Data;

@Data
public class ClientesDto {

	private Integer dniCl;

	private String nombreCl;

	private String apellido1;

	private String apellido2;

	private String claseVia;

	private String nombreVia;

	private Integer numeroVia;

	private Integer codPostal;

	private String ciudad;

	private String telefono;

	private String observaciones;

}
