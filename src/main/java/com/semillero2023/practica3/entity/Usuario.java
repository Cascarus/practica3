package com.semillero2023.practica3.entity;

import java.io.Serializable;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name="USUARIO")
@DynamicUpdate @DynamicInsert
@Data
public class Usuario implements Serializable{

	private static final long serialVersionUID = -7357818840310232642L;

	@Id
	@Column(name="USERNAME")
	private String username;
	
	@Column(name="password")
	private String password;


}
