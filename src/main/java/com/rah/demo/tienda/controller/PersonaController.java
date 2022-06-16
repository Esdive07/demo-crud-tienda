package com.rah.demo.tienda.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rah.demo.tienda.model.PersonaModel;
import com.rah.demo.tienda.service.PersonaService;

@RestController
@RequestMapping("/personas")
public class PersonaController {

	private PersonaService personaService;

	public PersonaController(PersonaService personaService) {
		super();
		this.personaService = personaService;
	}

	@PostMapping
	public ResponseEntity<PersonaModel> createPerson(@RequestBody PersonaModel personaModel) {
		return ResponseEntity.status(HttpStatus.CREATED).body(this.personaService.createPerson(personaModel));
	}

	@GetMapping
	public ResponseEntity<List<PersonaModel>> getAllPerson() {
		return ResponseEntity.ok(this.personaService.getAllPerson());
	}

	@PutMapping("/{id}")
	public ResponseEntity<PersonaModel> updatePerson(@RequestBody PersonaModel personaModel, @PathVariable Integer id) {
		return ResponseEntity.status(HttpStatus.CREATED).body(this.personaService.updatePerson(personaModel, id));
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deletePerson(@PathVariable Integer id) {
		this.personaService.deletePerson(id);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}

	@GetMapping("/{id}")
	public ResponseEntity<PersonaModel> getByIdPerson(@PathVariable Integer id) {
		return ResponseEntity.ok(this.personaService.getByIdPerson(id));
	}
}
