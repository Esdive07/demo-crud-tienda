package com.rah.demo.tienda.service.Impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.rah.demo.tienda.entity.CompraEntity;
import com.rah.demo.tienda.mapper.CompraMapper;
import com.rah.demo.tienda.model.CompraInventarioModel;
import com.rah.demo.tienda.model.CompraModel;
import com.rah.demo.tienda.model.InventarioModel;
import com.rah.demo.tienda.model.PageModel;
import com.rah.demo.tienda.repository.CompraRepository;
import com.rah.demo.tienda.service.CompraService;
import com.rah.demo.tienda.service.InventarioService;
import com.rah.demo.tienda.util.MapperUtil;

@Service
public class CompraServiceImpl implements CompraService {

	private CompraRepository compraRepository;
	private InventarioService inventarioService;
	private CompraMapper compraMapper;
	private MapperUtil mapperUtil;

	public CompraServiceImpl(CompraRepository compraRepository, InventarioService inventarioService,
			CompraMapper compraMapper, MapperUtil mapperUtil) {
		super();
		this.compraRepository = compraRepository;
		this.inventarioService = inventarioService;
		this.compraMapper = compraMapper;
		this.mapperUtil = mapperUtil;
	}

	@Override
	public CompraModel createCompra(CompraModel compraModel) {
		CompraEntity compraEntity = this.mapperUtil.mapperObject(compraModel, CompraEntity.class);
		CompraEntity compraSave = this.compraRepository.save(compraEntity);
		return this.mapperUtil.mapperObject(compraSave, CompraModel.class);
	}

	@Override
	public List<CompraModel> getAllCompra() {

		List<CompraEntity> listaEntity = this.compraRepository.findAll();
		List<CompraModel> listaModel = new ArrayList<>();

		for (CompraEntity compraEntity : listaEntity) {

			CompraModel compraModel = this.compraMapper.entityToModel(compraEntity);
			listaModel.add(compraModel);
		}

		return listaModel;
	}

	@Override
	public PageModel getAllCompraPaginada(Integer page, Integer size) {

		Pageable paginacion = PageRequest.of(page, size);
		Page<CompraEntity> responsePages = this.compraRepository.findAll(paginacion);
		return this.compraMapper.pageToModel(responsePages);
	}

	@Override
	public CompraModel updateCompra(CompraModel compraModel, Integer id) {
		CompraEntity compraEntity = this.compraMapper.ModelToEntity(compraModel);
		CompraEntity compraSave = this.compraRepository.save(compraEntity);
		return this.compraMapper.entityToModel(compraSave);
	}

	@Override
	public void deleteCompra(Integer id) {
		this.compraRepository.deleteById(id);

	}

	@Override
	public CompraModel getByIdCompra(Integer id) {
		CompraEntity compraEntity = this.compraRepository.findById(id).get();
		return this.compraMapper.entityToModel(compraEntity);
	}

	@Override
	public CompraInventarioModel createCompraInvenetario(CompraInventarioModel compraInventarioModel) {
		CompraModel compraModel = this.mapperUtil.mapperObject(compraInventarioModel, CompraModel.class);
		compraModel = this.createCompra(compraModel);
		InventarioModel inventarioModel = this.mapperUtil.mapperObject(compraInventarioModel, InventarioModel.class);
		this.inventarioService.createInventario(inventarioModel);
		compraInventarioModel.setId(compraModel.getId());
		return compraInventarioModel;
	}

}
