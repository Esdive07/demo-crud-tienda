package com.rah.demo.tienda.service.Impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.rah.demo.tienda.entity.DetalleVentaEntity;
import com.rah.demo.tienda.mapper.DetalleVentaMapper;
import com.rah.demo.tienda.model.DetalleVentaModel;
import com.rah.demo.tienda.repository.DetalleVentaRepository;
import com.rah.demo.tienda.service.DetalleVentaService;

@Service
public class DetalleVentaServiceImpl implements DetalleVentaService {

	private DetalleVentaRepository detalleVentaRepository;
	private DetalleVentaMapper detalleVentaMapper;

	public DetalleVentaServiceImpl(DetalleVentaRepository detalleVentaRepository,
			DetalleVentaMapper detalleVentaMapper) {
		super();
		this.detalleVentaRepository = detalleVentaRepository;
		this.detalleVentaMapper = detalleVentaMapper;
	}

	@Override
	public DetalleVentaModel createDetalleVenta(DetalleVentaModel detalleVentaModel) {
		DetalleVentaEntity detalleVentaEntity = this.detalleVentaMapper.modelToEntity(detalleVentaModel);
		DetalleVentaEntity detalleVentaSave = this.detalleVentaRepository.save(detalleVentaEntity);
		return this.detalleVentaMapper.entityToModel(detalleVentaSave);
	}

	@Override
	public List<DetalleVentaModel> getAllDetalleVenta() {
		List<DetalleVentaEntity> listaEntity = this.detalleVentaRepository.findAll();
		List<DetalleVentaModel> listaModel = new ArrayList<>();

		for (DetalleVentaEntity detalleVentaEntity : listaEntity) {

			DetalleVentaModel detalleVentaModel = this.detalleVentaMapper.entityToModel(detalleVentaEntity);
			listaModel.add(detalleVentaModel);
		}
		return listaModel;
	}

	@Override
	public DetalleVentaModel updateDetalleVenta(DetalleVentaModel detalleVentaModel, Integer id) {
		detalleVentaModel.setIdDetalle(id);
		DetalleVentaEntity detalleVentaEntity = this.detalleVentaMapper.modelToEntity(detalleVentaModel);
		DetalleVentaEntity detalleVentaSave = this.detalleVentaRepository.save(detalleVentaEntity);
		return this.detalleVentaMapper.entityToModel(detalleVentaSave);
	}

	@Override
	public void deleteDetalleVenta(Integer id) {
		this.detalleVentaRepository.deleteById(id);

	}

	@Override
	public DetalleVentaModel getByIdDetalleVenta(Integer id) {
		DetalleVentaEntity listaEntity = this.detalleVentaRepository.findById(id).get();
		return this.detalleVentaMapper.entityToModel(listaEntity);
	}

}
