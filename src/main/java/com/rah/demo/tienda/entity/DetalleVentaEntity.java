package com.rah.demo.tienda.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Entity
@Table(name = "detalleVentas")
@Data
@JsonInclude(Include.NON_NULL)
public class DetalleVentaEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idDetalle;
	private float valorUnidad;
	private Integer cantidad;

	@ManyToOne
	@JoinColumn(name = "venta_id", nullable = false)
	@JsonProperty("venta")
	@JsonBackReference
	private VentaEntity ventaEntity;

	@ManyToOne
	@JoinColumn(name = "producto_id")
	@JsonProperty("producto")
	private ProductoEntity productoEntity;
}
