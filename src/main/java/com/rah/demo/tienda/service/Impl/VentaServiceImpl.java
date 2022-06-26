package com.rah.demo.tienda.service.Impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.rah.demo.tienda.entity.DetalleVentaEntity;
import com.rah.demo.tienda.entity.VentaEntity;
import com.rah.demo.tienda.mapper.VentaMapper;
import com.rah.demo.tienda.model.DetalleVentaModel;
import com.rah.demo.tienda.model.ProductoModel;
import com.rah.demo.tienda.model.VentaModel;
import com.rah.demo.tienda.repository.VentaRepository;
import com.rah.demo.tienda.service.ProductoService;
import com.rah.demo.tienda.service.VentaService;

@Service
public class VentaServiceImpl implements VentaService {

	private VentaRepository ventaRepository;
	private VentaMapper ventaMapper;
	private ProductoService productoService;

	public VentaServiceImpl(VentaRepository ventaRepository, VentaMapper ventaMapper, ProductoService productoService) {
		super();
		this.ventaRepository = ventaRepository;
		this.ventaMapper = ventaMapper;
		this.productoService = productoService;
	}

	public void crearVentaValidacion(List<DetalleVentaModel> detalleVentaModels) {
		for (DetalleVentaModel detalleVentaModel : detalleVentaModels) {

			ProductoModel productoModel = this.productoService.getByIdProduct(detalleVentaModel.getProducto().getId());

			if (productoModel.getInventario().getCantidad() < detalleVentaModel.getCantidad()) {
				throw new IllegalArgumentException("No hay cantidades suficientes para esta venta");
			}

			if (productoModel.getInventario().getValorVenta() > detalleVentaModel.getValorUnidad()) {
				throw new IllegalArgumentException("El valor unitario no corresponde al valor del producto");
			}
		}
	}

	@Override
	public VentaModel createVenta(VentaModel ventaModel) {

		this.crearVentaValidacion(ventaModel.getDetalleVenta());

		VentaEntity ventaEntity = this.ventaMapper.modelToEntity(ventaModel);

		float totalVenta = 0;
		for (DetalleVentaEntity detalleVenta : ventaEntity.getDetalleVentaEntities()) {
			float subtotal = detalleVenta.getCantidad() * detalleVenta.getValorUnidad();
			totalVenta += subtotal;
		}

		ventaEntity.setTotalVenta(totalVenta);
		VentaEntity ventasave = this.ventaRepository.save(ventaEntity);
		return this.ventaMapper.entityToModel(ventasave);
	}

	@Override
	public List<VentaModel> getAllVenta() {
		List<VentaEntity> listaVenta = this.ventaRepository.findAll();
		List<VentaModel> VentaModel = new ArrayList<>();

		for (VentaEntity ventaEntity : listaVenta) {
			VentaModel listaModel = this.ventaMapper.entityToModel(ventaEntity);
			VentaModel.add(listaModel);
		}
		return VentaModel;
	}

	@Override
	public VentaModel updateVenta(VentaModel ventaModel, Integer id) {
		ventaModel.setId(id);
		VentaEntity ventaEntity = this.ventaMapper.modelToEntity(ventaModel);
		VentaEntity ventaSave = this.ventaRepository.save(ventaEntity);
		return this.ventaMapper.entityToModel(ventaSave);
	}

	@Override
	public void deleteVenta(Integer id) {
		this.ventaRepository.deleteById(id);

	}

	@Override
	public VentaModel getByIdVenta(Integer id) {
		VentaEntity listaVenta = this.ventaRepository.findById(id).get();
		return this.ventaMapper.entityToModel(listaVenta);
	}

}
