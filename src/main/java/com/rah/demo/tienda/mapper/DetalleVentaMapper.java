package com.rah.demo.tienda.mapper;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.rah.demo.tienda.entity.DetalleVentaEntity;
import com.rah.demo.tienda.model.DetalleVentaModel;

@Component
public class DetalleVentaMapper {

	private ObjectMapper objectMapper;

	public DetalleVentaMapper() {
		this.objectMapper = new ObjectMapper();
		this.objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
	}

	public DetalleVentaEntity modelToEntity(DetalleVentaModel detalleVentaModel) {
		return this.objectMapper.convertValue(detalleVentaModel, DetalleVentaEntity.class);
	}

	public DetalleVentaModel entityToModel(DetalleVentaEntity detalleVentaEntity) {
		return this.objectMapper.convertValue(detalleVentaEntity, DetalleVentaModel.class);
	}

}
