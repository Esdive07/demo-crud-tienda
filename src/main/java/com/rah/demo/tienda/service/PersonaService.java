package com.rah.demo.tienda.service;

import java.util.List;

import com.rah.demo.tienda.model.PersonaModel;

public interface PersonaService {

	public PersonaModel createPerson(PersonaModel personaModel);

	public List<PersonaModel> getAllPerson();

	public PersonaModel updatePerson(PersonaModel personaModel, Integer id);

	public void deletePerson(Integer id);

	public PersonaModel getByIdPerson(Integer id);

}
