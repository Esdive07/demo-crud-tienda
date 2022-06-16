package com.rah.demo.tienda.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rah.demo.tienda.entity.PersonaEntity;

public interface PersonaRepository extends JpaRepository<PersonaEntity, Integer> {

}
