package com.rah.demo.tienda.service;

import java.util.List;

import com.rah.demo.tienda.model.InventarioModel;
import com.rah.demo.tienda.model.ProductoModel;

public interface InventarioService {

	public InventarioModel createInventario(InventarioModel inventarioModel);

	public List<InventarioModel> getAllInventario();

	public InventarioModel updateInventario(InventarioModel inventarioModel, Integer id);

	public void deleteInventario(Integer id);

	public InventarioModel getByIdInventario(Integer id);

//	public InventarioModel getInventarioByProduct(Integer idproducto);

	public InventarioModel getInventarioByProduct(ProductoModel productoModel);

}
