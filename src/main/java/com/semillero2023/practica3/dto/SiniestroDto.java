package com.semillero2023.practica3.dto;

import java.util.Date;


public class SiniestroDto {
	
	private Integer idSiniestro;
	
	private Date fechaSiniestro;
	
	private String causas;
	
	private String aceptado;
	
	private Double indemnizacion;
	
	private Integer seguro;
	
	private Integer dniPerito;

	public Integer getIdSiniestro() {
		return idSiniestro;
	}

	public void setIdSiniestro(Integer idSiniestro) {
		this.idSiniestro = idSiniestro;
	}

	public Date getFechaSiniestro() {
		return fechaSiniestro;
	}

	public void setFechaSiniestro(Date fechaSiniestro) {
		this.fechaSiniestro = fechaSiniestro;
	}

	public String getCausas() {
		return causas;
	}

	public void setCausas(String causas) {
		this.causas = causas;
	}

	public String getAceptado() {
		return aceptado;
	}

	public void setAceptado(String aceptado) {
		this.aceptado = aceptado;
	}

	public Double getIndemnizacion() {
		return indemnizacion;
	}

	public void setIndemnizacion(Double indemnizacion) {
		this.indemnizacion = indemnizacion;
	}

	public Integer getSeguro() {
		return seguro;
	}

	public void setSeguro(Integer seguro) {
		this.seguro = seguro;
	}

	public Integer getDniPerito() {
		return dniPerito;
	}

	public void setDniPerito(Integer dniPerito) {
		this.dniPerito = dniPerito;
	}
	
	

}
