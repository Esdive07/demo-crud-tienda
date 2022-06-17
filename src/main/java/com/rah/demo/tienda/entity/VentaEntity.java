package com.rah.demo.tienda.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Entity
@Table(name = "ventas")
@Data
public class VentaEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonProperty("id")
	private Integer idVenta;
	@JsonProperty("total")
	private float totalVenta;
	@JsonProperty("fechaVenta")
	private Date fechaVenta;

	@ManyToOne
	@JoinColumn(name = "persona_id")
	@JsonProperty("persona")
	private PersonaEntity personaEntity;

	@OneToMany(mappedBy = "ventaEntity", cascade = CascadeType.ALL)
	@JsonProperty("detalleVenta")
	@JsonManagedReference
	private List<DetalleVentaEntity> detalleVentaEntities;

	@PrePersist
	public void prePersist() {
		this.fechaVenta = new Date();
	}

}
