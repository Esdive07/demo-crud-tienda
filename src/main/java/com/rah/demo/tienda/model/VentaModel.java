package com.rah.demo.tienda.model;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.rah.demo.tienda.entity.ProductoEntity;

import lombok.Data;

@Data
@JsonInclude(Include.NON_NULL)
public class VentaModel {

	private Integer id;
	private float total;
	private Date fechaVenta;
	private ProductoEntity persona;
	private List<DetalleVentaModel> detalleVenta;
}
