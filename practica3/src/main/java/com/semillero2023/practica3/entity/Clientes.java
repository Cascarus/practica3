package com.semillero2023.practica3.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name="CLIENTES")
@DynamicUpdate @DynamicInsert
@Data
public class Clientes implements Serializable{
	
	private static final long serialVersionUID = 6266437026682503375L;

	@Id
	@Basic(optional = false)
	@Column(name="DNI_CL")
	private Integer dniCl;
	
	@Column(name="NOMBRE_CL")
	private String nombreCl;
	
	@Column(name="APELLIDO_1")
	private String apellido1;
	
	@Column(name="APELLIDO_2")
	private String apellido2;
	
	@Column(name="CLASE_VIA")
	private String claseVia;
	
	@Column(name="NOMBRE_VIA")
	private String nombreVia;
	
	@Column(name="NUMERO_VIA")
	private Integer numeroVia;
	
	@Column(name="COD_POSTAL")
	private Integer codPostal;
	
	@Column(name="CIUDAD")
	private String ciudad;
	
	@Column(name="TELEFONO")
	private String telefono;
	
	@Column(name="OBSERVACIONES")
	private String observaciones;
	
	@OneToMany(mappedBy ="dniCl", fetch = FetchType.EAGER)
	private List<Seguros> seguros = new ArrayList<>();

}
