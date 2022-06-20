package com.rah.demo.tienda.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rah.demo.tienda.entity.InventarioEntity;
import com.rah.demo.tienda.entity.ProductoEntity;

public interface InventarioRepository extends JpaRepository<InventarioEntity, Integer> {

	Optional<InventarioEntity> findByProductoEntity(ProductoEntity productoEntity);
}
