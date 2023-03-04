package com.semillero2023.practica3.entity;

import java.io.Serializable;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "COMPANIAS_SEGUROS")
@DynamicUpdate
@DynamicInsert
public class CompaniaSeguro implements Serializable {

	private static final long serialVersionUID = -7476246797823899059L;

	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_COMP_SEGUROS")
	@SequenceGenerator(sequenceName = "seq_comp_seguros", allocationSize = 1, name = "SEQ_COMP_SEGUROS")
	private Integer id;

	@Column(name = "NUMERO_POLIZA")
	private Integer numeroPoliza;

	@Column(name = "NOMBRE_COMPANIA")
	private String nombreCompania;

}
