package com.rah.demo.tienda.model;

import java.util.Date;

import lombok.Data;

@Data
public class PersonaModel {

	private Integer id;
	private String nombre;
	private String apellido;
	private Date fechaNacimiento;
}
