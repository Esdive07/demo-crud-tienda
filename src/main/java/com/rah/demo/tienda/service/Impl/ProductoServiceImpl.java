package com.rah.demo.tienda.service.Impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.rah.demo.tienda.entity.ProductoEntity;
import com.rah.demo.tienda.mapper.ProductoMapper;
import com.rah.demo.tienda.model.ProductoModel;
import com.rah.demo.tienda.repository.ProductoRepository;
import com.rah.demo.tienda.service.ProductoService;

@Service
public class ProductoServiceImpl implements ProductoService {

	private ProductoRepository productoRepository;
	private ProductoMapper productoMapper;

	public ProductoServiceImpl(ProductoRepository productoRepository, ProductoMapper productoMapper) {
		super();
		this.productoRepository = productoRepository;
		this.productoMapper = productoMapper;
	}

	@Override
	public ProductoModel createProduct(ProductoModel productoModel) {
		ProductoEntity productoEntity = this.productoMapper.modelToEntity(productoModel);
		ProductoEntity productoSave = this.productoRepository.save(productoEntity);
		return this.productoMapper.entityToModel(productoSave);
	}

	@Override
	public List<ProductoModel> getAllProduct() {
		List<ProductoEntity> listaEntity = this.productoRepository.findAll();
		List<ProductoModel> listaModel = new ArrayList<>();

		for (ProductoEntity productoEntity : listaEntity) {
			ProductoModel productoModel = this.productoMapper.entityToModel(productoEntity);
			listaModel.add(productoModel);
		}
		return listaModel;
	}

	@Override
	public ProductoModel updateProduct(ProductoModel productoModel, Integer id) {
		productoModel.setId(id);
		ProductoEntity productoEntity = this.productoMapper.modelToEntity(productoModel);
		ProductoEntity productoSave = this.productoRepository.save(productoEntity);
		return this.productoMapper.entityToModel(productoSave);
	}

	@Override
	public void deleteProduct(Integer id) {
		this.productoRepository.deleteById(id);

	}

	@Override
	public ProductoModel getByIdProduct(Integer id) {
		ProductoEntity productoEntity = this.productoRepository.findById(id).get();
		return this.productoMapper.entityToModel(productoEntity);
	}

}
