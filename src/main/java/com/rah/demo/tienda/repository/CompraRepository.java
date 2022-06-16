package com.rah.demo.tienda.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rah.demo.tienda.entity.CompraEntity;

public interface CompraRepository extends JpaRepository<CompraEntity, Integer> {

}
