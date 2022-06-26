package com.rah.demo.tienda.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Entity
@Table(name = "productos")
@Data
@JsonInclude(Include.NON_NULL)
public class ProductoEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonProperty("id")
	private Integer IdProducto;
	@JsonProperty("nombre")
	private String nombreProducto;
	@JsonProperty("tipo")
	private String tipoProducto;
	@JsonProperty("descripcion")
	private String descripcionProducto;

	@OneToOne(mappedBy = "productoEntity", cascade = CascadeType.DETACH)
	@JsonProperty("inventario")
	@JsonManagedReference
	private InventarioEntity inventarioEntity;
}
