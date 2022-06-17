package com.rah.demo.tienda.service;

import java.util.List;

import com.rah.demo.tienda.model.DetalleVentaModel;

public interface DetalleVentaService {

	public DetalleVentaModel createDetalleVenta(DetalleVentaModel detalleVentaModel);

	public List<DetalleVentaModel> getAllDetalleVenta();

	public DetalleVentaModel updateDetalleVenta(DetalleVentaModel detalleVentaModel, Integer id);

	public void deleteDetalleVenta(Integer id);

	public DetalleVentaModel getByIdDetalleVenta(Integer id);

}
