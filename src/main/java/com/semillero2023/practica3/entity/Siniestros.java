package com.semillero2023.practica3.entity;

import java.io.Serializable;
import java.util.Date;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name="SINIESTROS")
@DynamicUpdate @DynamicInsert
public class Siniestros implements Serializable{

	private static final long serialVersionUID = 4416017807660615873L;
	
	@Id
	@Basic(optional = false)
	@Column(name="ID_SINIESTRO")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_SINIESTROS")
    @SequenceGenerator(sequenceName = "seq_siniestros", allocationSize = 1, name = "SEQ_SINIESTROS")
	private Integer idSiniestro;
	
	@Column(name="FECHA_SINIESTRO")
	private Date fechaSiniestro;
	
	@Column(name="CAUSAS")
	private String causas;
	
	@Column(name="ACEPTADO")
	private String aceptado;
	
	@Column(name="INDEMNIZACION")
	private Double indemnizacion;
	
	@ManyToOne
	@JoinColumn(name = "NUMERO_POLIZA")
	private Seguros seguro;
	
	@Column(name="DNI_PERITO")
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

	public Seguros getSeguro() {
		return seguro;
	}

	public void setSeguro(Seguros seguro) {
		this.seguro = seguro;
	}

	public Integer getDniPerito() {
		return dniPerito;
	}

	public void setDniPerito(Integer dniPerito) {
		this.dniPerito = dniPerito;
	}

	
	
}
