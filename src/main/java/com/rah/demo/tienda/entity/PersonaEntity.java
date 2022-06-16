package com.rah.demo.tienda.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Entity
@Table(name = "personas")
@Data
public class PersonaEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonProperty("id")
	private Integer idPersona;
	@JsonProperty("nombre")
	private String nombrePersona;
	@JsonProperty("apellido")
	private String apellidoPersona;
	@JsonProperty("fechaNacimiento")
	private Date fechaNacimientoPersona;

}
