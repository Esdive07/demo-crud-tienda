package com.rah.demo.tienda.service.Impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.rah.demo.tienda.entity.PersonaEntity;
import com.rah.demo.tienda.mapper.PersonaMapper;
import com.rah.demo.tienda.model.PersonaModel;
import com.rah.demo.tienda.repository.PersonaRepository;
import com.rah.demo.tienda.service.PersonaService;

@Service
public class PersonaServiceImpl implements PersonaService {

	private PersonaRepository personaRepository;
	private PersonaMapper personaMapper;

	public PersonaServiceImpl(PersonaRepository personaRepository, PersonaMapper personaMapper) {
		super();
		this.personaRepository = personaRepository;
		this.personaMapper = personaMapper;
	}

	@Override
	public PersonaModel createPerson(PersonaModel personaModel) {
		PersonaEntity personaEntity = this.personaMapper.modelToEntity(personaModel);
		PersonaEntity personaSave = this.personaRepository.save(personaEntity);
		return this.personaMapper.entityToModel(personaSave);
	}

	@Override
	public List<PersonaModel> getAllPerson() {
		List<PersonaEntity> listaEntity = this.personaRepository.findAll();
		List<PersonaModel> listaModel = new ArrayList<>();

		for (PersonaEntity personaEntity : listaEntity) {
			PersonaModel personaModel = this.personaMapper.entityToModel(personaEntity);
			listaModel.add(personaModel);
		}

		return listaModel;
	}

	@Override
	public PersonaModel updatePerson(PersonaModel personaModel, Integer id) {
		personaModel.setId(id);
		PersonaEntity personaEntity = this.personaMapper.modelToEntity(personaModel);
		PersonaEntity personaSave = this.personaRepository.save(personaEntity);
		return this.personaMapper.entityToModel(personaSave);
	}

	@Override
	public void deletePerson(Integer id) {
		this.personaRepository.deleteById(id);

	}

	@Override
	public PersonaModel getByIdPerson(Integer id) {
		PersonaEntity personaEntity = this.personaRepository.findById(id).get();
		return this.personaMapper.entityToModel(personaEntity);
	}

}
