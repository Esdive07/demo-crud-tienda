package com.rah.demo.tienda.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Entity
@Table(name = "inventarios")
@Data
@JsonInclude(Include.NON_NULL)
public class InventarioEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonProperty("id")
	private Integer id;
	private float valorVenta;
	private Integer cantidad;
	private Date fechaCreacion;
	private Date fechaModificacion;

	@OneToOne
	@JoinColumn(name = "product_id", nullable = false)
	@JsonProperty("producto")
	@JsonBackReference
	private ProductoEntity productoEntity;
}
