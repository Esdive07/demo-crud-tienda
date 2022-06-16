package com.rah.demo.tienda.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rah.demo.tienda.entity.ProductoEntity;

public interface ProductoRepository extends JpaRepository<ProductoEntity, Integer> {

}
