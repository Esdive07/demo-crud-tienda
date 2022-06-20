package com.rah.demo.tienda.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Entity
@Table(name = "compras")
@Data
@JsonInclude(Include.NON_NULL)
public class CompraEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private float valorCompra;
	private Integer cantidad;
	private Date fechaCompra;

	@ManyToOne
	@JoinColumn(name = "product_id", nullable = false)
	@JsonProperty("producto")
	private ProductoEntity productoEntity;
}
