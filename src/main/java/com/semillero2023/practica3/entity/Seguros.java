package com.semillero2023.practica3.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name="SEGUROS")
@DynamicUpdate @DynamicInsert
public class Seguros implements Serializable{

	private static final long serialVersionUID = 3040026534004912818L;
	
	@Id
	@Basic(optional = false)
	@Column(name="NUMERO_POLIZA")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_SEGUROS")
    @SequenceGenerator(sequenceName = "seq_seguros", allocationSize = 1, name = "SEQ_SEGUROS")
	private Integer numeroPoliza;
	
	@Column(name="RAMO")
	private String ramo;
	
	@Column(name="FECHA_INICIO")
	private Date fechaInicio;
	
	@Column(name="FECHA_VENCIMIENTO")
	private Date fechaVencimiento;
	
	@Column(name="CONDICIONES_PARTICULARES")
	private String condicionesParticulares;
	
	@Column(name="OBSERVACIONES")
	private String observaciones;
	
	@Column(name="DNI_CL")
	private Integer dniCl;
	
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(
	  name = "COMPANIAS_SEGUROS",
	  joinColumns = @JoinColumn(name = "numero_poliza"), 
	  inverseJoinColumns = @JoinColumn(name = "nombre_compania"))
	@JsonManagedReference
	private List<Companias> companiaSeguros = new ArrayList<>();

	public Integer getNumeroPoliza() {
		return numeroPoliza;
	}

	public void setNumeroPoliza(Integer numeroPoliza) {
		this.numeroPoliza = numeroPoliza;
	}

	public String getRamo() {
		return ramo;
	}

	public void setRamo(String ramo) {
		this.ramo = ramo;
	}

	public Date getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public Date getFechaVencimiento() {
		return fechaVencimiento;
	}

	public void setFechaVencimiento(Date fechaVencimiento) {
		this.fechaVencimiento = fechaVencimiento;
	}

	public String getCondicionesParticulares() {
		return condicionesParticulares;
	}

	public void setCondicionesParticulares(String condicionesParticulares) {
		this.condicionesParticulares = condicionesParticulares;
	}

	public String getObservaciones() {
		return observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}

	public Integer getDniCl() {
		return dniCl;
	}

	public void setDniCl(Integer dniCl) {
		this.dniCl = dniCl;
	}

	public List<Companias> getCompaniaSeguros() {
		return companiaSeguros;
	}

	public void setCompaniaSeguros(List<Companias> companiaSeguros) {
		this.companiaSeguros = companiaSeguros;
	}

	
}
