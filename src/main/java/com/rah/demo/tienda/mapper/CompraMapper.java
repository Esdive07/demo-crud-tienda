package com.rah.demo.tienda.mapper;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.rah.demo.tienda.entity.CompraEntity;
import com.rah.demo.tienda.model.CompraInventarioModel;
import com.rah.demo.tienda.model.CompraModel;
import com.rah.demo.tienda.model.PageModel;

@Component
public class CompraMapper {

	private ObjectMapper objectMapper;

	public CompraMapper() {
		this.objectMapper = new ObjectMapper();
		this.objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
	}

	public CompraEntity ModelToEntity(CompraModel compraModel) {
		return this.objectMapper.convertValue(compraModel, CompraEntity.class);
	}

	public CompraModel entityToModel(CompraEntity compraEntity) {
		return this.objectMapper.convertValue(compraEntity, CompraModel.class);
	}

	public PageModel pageToModel(Page<CompraEntity> page) {
		return this.objectMapper.convertValue(page, PageModel.class);
	}

	public CompraModel changeToModel(CompraInventarioModel compraInventarioModel) {
		// TODO Auto-generated method stub
		return this.objectMapper.convertValue(compraInventarioModel, CompraModel.class);
	}
}
