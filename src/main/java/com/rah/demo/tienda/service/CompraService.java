package com.rah.demo.tienda.service;

import java.util.List;

import com.rah.demo.tienda.model.CompraInventarioModel;
import com.rah.demo.tienda.model.CompraModel;
import com.rah.demo.tienda.model.PageModel;

public interface CompraService {

	public CompraModel createCompra(CompraModel compraModel);

	public List<CompraModel> getAllCompra();

	public CompraModel updateCompra(CompraModel compraModel, Integer id);

	public void deleteCompra(Integer id);

	public CompraModel getByIdCompra(Integer id);

	PageModel getAllCompraPaginada(Integer page, Integer size);

	public CompraInventarioModel createCompraInvenetario(CompraInventarioModel compraInventarioModel);

}
