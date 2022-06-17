package com.rah.demo.tienda.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rah.demo.tienda.entity.DetalleVentaEntity;

public interface DetalleVentaRepository extends JpaRepository<DetalleVentaEntity, Integer> {

}
