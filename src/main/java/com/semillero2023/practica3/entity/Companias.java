package com.semillero2023.practica3.entity;

import java.io.Serializable;
import java.util.List;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="COMPANIAS")
@DynamicUpdate @DynamicInsert
public class Companias implements Serializable {

	
	private static final long serialVersionUID = 5106925589967446155L;
	
	@Id
	@Column(name="NOMBRE_COMPANIA")
	private String nombreCompania;
	
	@Column(name="CLASE_VIA")
	private String claseVia;
	
	@Column(name="NOMBRE_VIA")
	private String nombreVia;
	
	@Column(name="NUMERO_VIA")
	private Integer numberoVia;
	
	@Column(name="COD_POSTAL")
	private Integer codPostal;
	
	@Column(name="TELEFONO_CONTRATACION")
	private String telefonoContratacion;
	
	@Column(name="TELEFONO_SINIESTROS")
	private String telefonoSiniestros;
	
	@Column(name="NOTAS")
	private String notas;
	
	@ManyToMany(mappedBy = "companiaSeguros")
	@JsonBackReference
	private List<Seguros> seguros;

	
}
