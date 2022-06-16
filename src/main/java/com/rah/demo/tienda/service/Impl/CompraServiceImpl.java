package com.rah.demo.tienda.service.Impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.rah.demo.tienda.entity.CompraEntity;
import com.rah.demo.tienda.mapper.CompraMapper;
import com.rah.demo.tienda.model.CompraModel;
import com.rah.demo.tienda.model.PageModel;
import com.rah.demo.tienda.repository.CompraRepository;
import com.rah.demo.tienda.service.CompraService;

@Service
public class CompraServiceImpl implements CompraService {

	private CompraRepository compraRepository;
	private CompraMapper compraMapper;

	public CompraServiceImpl(CompraRepository compraRepository, CompraMapper compraMapper) {
		super();
		this.compraRepository = compraRepository;
		this.compraMapper = compraMapper;
	}

	@Override
	public CompraModel createCompra(CompraModel compraModel) {
		CompraEntity compraEntity = this.compraMapper.ModelToEntity(compraModel);
		CompraEntity compraSave = this.compraRepository.save(compraEntity);
		return this.compraMapper.entityToModel(compraSave);
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

}
