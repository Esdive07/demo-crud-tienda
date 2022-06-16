package com.rah.demo.tienda.mapper;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.rah.demo.tienda.entity.ProductoEntity;
import com.rah.demo.tienda.model.ProductoModel;

@Component
public class ProductoMapper {

	private ObjectMapper objectMapper;

	public ProductoMapper() {
		this.objectMapper = new ObjectMapper();
		// permite campos nullos
		this.objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
	}

	public ProductoEntity modelToEntity(ProductoModel productoModel) {
		return this.objectMapper.convertValue(productoModel, ProductoEntity.class);
	}

	public ProductoModel entityToModel(ProductoEntity productoEntity) {
		return this.objectMapper.convertValue(productoEntity, ProductoModel.class);
	}

}
