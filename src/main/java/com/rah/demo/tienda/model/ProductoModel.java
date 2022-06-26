package com.rah.demo.tienda.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Data;

@Data
@JsonInclude(Include.NON_NULL)
public class ProductoModel {
	private Integer Id;
	private String nombre;
	private String tipo;
	private String descripcion;

	private InventarioModel inventario;
}
