package com.rah.demo.tienda.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rah.demo.tienda.entity.InventarioEntity;

public interface InventarioRepository extends JpaRepository<InventarioEntity, Integer> {

}
