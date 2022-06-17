package com.rah.demo.tienda.service.Impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.rah.demo.tienda.entity.DetalleVentaEntity;
import com.rah.demo.tienda.entity.VentaEntity;
import com.rah.demo.tienda.mapper.VentaMapper;
import com.rah.demo.tienda.model.VentaModel;
import com.rah.demo.tienda.repository.VentaRepository;
import com.rah.demo.tienda.service.VentaService;

@Service
public class VentaServiceImpl implements VentaService {

	private VentaRepository ventaRepository;
	private VentaMapper ventaMapper;

	public VentaServiceImpl(VentaRepository ventaRepository, VentaMapper ventaMapper) {
		super();
		this.ventaRepository = ventaRepository;
		this.ventaMapper = ventaMapper;
	}

	@Override
	public VentaModel createVenta(VentaModel ventaModel) {
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
