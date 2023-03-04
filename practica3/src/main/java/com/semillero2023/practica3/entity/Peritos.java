package com.semillero2023.practica3.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "PERITOS")
@DynamicUpdate
@DynamicInsert
public class Peritos implements Serializable {

	private static final long serialVersionUID = 3930100777405108629L;

	@Id
	@Column(name = "DNI_PERITO")
	private Integer dniPerito;

	@Column(name = "NOMBRE_PERITO")
	private String nombrePerito;

	@Column(name = "APELLIDO_PERITO1")
	private String apellidoPerito1;

	@Column(name = "APELLIDO_PERITO2")
	private String apellidoPerito2;

	@Column(name = "TELEFONO_CONTACTO")
	private String telefonoContacto;

	@Column(name = "TELEFONO_OFICINA")
	private String telefonoOficina;

	@Column(name = "CLASE_VIA")
	private String claseVia;

	@Column(name = "NOMBRE_VIA")
	private String nombreVia;

	@Column(name = "NUMERO_VIA")
	private Integer numberoVia;

	@Column(name = "COD_POSTAL")
	private Integer codPostal;

	@Column(name = "CIUDAD")
	private String ciudad;

	@OneToMany(mappedBy = "dniPerito", fetch = FetchType.LAZY)
	private List<Siniestros> siniestros = new ArrayList<>();

}
