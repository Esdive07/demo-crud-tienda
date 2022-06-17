package com.rah.demo.tienda.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Data;

@Data
@JsonInclude(Include.NON_NULL)
public class DetalleVentaModel {

	private Integer idDetalle;
	private float valorUnidad;
	private Integer cantidad;

	private VentaModel venta;

	private ProductoModel producto;
}
