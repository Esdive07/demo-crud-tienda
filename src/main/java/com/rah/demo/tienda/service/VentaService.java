package com.rah.demo.tienda.service;

import java.util.List;

import com.rah.demo.tienda.model.VentaModel;

public interface VentaService {

	public VentaModel createVenta(VentaModel ventaModel);

	public List<VentaModel> getAllVenta();

	public VentaModel updateVenta(VentaModel ventaModel, Integer id);

	public void deleteVenta(Integer id);

	public VentaModel getByIdVenta(Integer id);

}
