package com.rah.demo.tienda.service;

import java.util.List;

import com.rah.demo.tienda.model.ProductoModel;

public interface ProductoService {

	public ProductoModel createProduct(ProductoModel productoModel);

	public List<ProductoModel> getAllProduct();

	public ProductoModel updateProduct(ProductoModel productoModel, Integer id);

	public void deleteProduct(Integer id);

	public ProductoModel getByIdProduct(Integer id);

}