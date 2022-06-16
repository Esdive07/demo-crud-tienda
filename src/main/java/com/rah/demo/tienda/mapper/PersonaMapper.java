package com.rah.demo.tienda.mapper;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.rah.demo.tienda.entity.PersonaEntity;
import com.rah.demo.tienda.model.PersonaModel;

@Component
public class PersonaMapper {

	private ObjectMapper objectMapper;

	public PersonaMapper() {
		this.objectMapper = new ObjectMapper();
		this.objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
	}

	public PersonaEntity modelToEntity(PersonaModel personaModel) {
		return this.objectMapper.convertValue(personaModel, PersonaEntity.class);
	}

	public PersonaModel entityToModel(PersonaEntity personaEntity) {
		return this.objectMapper.convertValue(personaEntity, PersonaModel.class);

	}

}
