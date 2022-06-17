package com.rah.demo.tienda.mapper;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.rah.demo.tienda.entity.VentaEntity;
import com.rah.demo.tienda.model.VentaModel;

@Component
public class VentaMapper {
	private ObjectMapper objectMapper;

	public VentaMapper() {
		this.objectMapper = new ObjectMapper();
		this.objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
	}

	public VentaEntity modelToEntity(VentaModel ventaModel) {
		return this.objectMapper.convertValue(ventaModel, VentaEntity.class);
	}

	public VentaModel entityToModel(VentaEntity ventaEntity) {
		return this.objectMapper.convertValue(ventaEntity, VentaModel.class);
	}
}
