package com.rah.demo.tienda.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Data;

@Data
@JsonInclude(Include.NON_NULL)
public class CompraModel {

	private Integer id;
	private float valorCompra;
	private float valorVenta;
	private Integer cantidad;

	private ProductoModel producto;
}
