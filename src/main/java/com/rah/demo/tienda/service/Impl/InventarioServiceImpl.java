package com.rah.demo.tienda.service.Impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.rah.demo.tienda.entity.InventarioEntity;
import com.rah.demo.tienda.entity.ProductoEntity;
import com.rah.demo.tienda.model.InventarioModel;
import com.rah.demo.tienda.model.ProductoModel;
import com.rah.demo.tienda.repository.InventarioRepository;
import com.rah.demo.tienda.service.InventarioService;
import com.rah.demo.tienda.util.MapperUtil;

@Service
public class InventarioServiceImpl implements InventarioService {

	private InventarioRepository inventarioRepository;
	private MapperUtil mapperUtil;

	public InventarioServiceImpl(InventarioRepository inventarioRepository, MapperUtil mapperUtil) {
		super();
		this.inventarioRepository = inventarioRepository;
		this.mapperUtil = mapperUtil;
	}

	@Override
	public InventarioModel createInventario(InventarioModel inventarioModel) {

		ProductoEntity productoEntity = this.mapperUtil.mapperObject(inventarioModel.getProducto(),
				ProductoEntity.class);

		Optional<InventarioEntity> inventarioExiste = inventarioRepository.findByProductoEntity(productoEntity);

		if (inventarioExiste.isPresent()) {

			Integer cantidadActual = inventarioExiste.get().getCantidad();
			Integer cantidadNueva = inventarioModel.getCantidad();

			inventarioModel.setId(inventarioExiste.get().getId());
			inventarioModel.setCantidad(cantidadNueva + cantidadActual);
		}

		InventarioEntity inventarioEntity = this.mapperUtil.mapperObject(inventarioModel, InventarioEntity.class);
		InventarioEntity inventarioSave = this.inventarioRepository.save(inventarioEntity);
		return this.mapperUtil.mapperObject(inventarioSave, InventarioModel.class);
	}

	@Override
	public List<InventarioModel> getAllInventario() {
		List<InventarioEntity> listaInventario = this.inventarioRepository.findAll();
		List<InventarioModel> listaInventarioModel = new ArrayList<>();

		for (InventarioEntity inventarioEntity : listaInventario) {

			InventarioModel inventarioModel = this.mapperUtil.mapperObject(inventarioEntity, InventarioModel.class);
			listaInventarioModel.add(inventarioModel);
		}

		return listaInventarioModel;
	}

	@Override
	public InventarioModel updateInventario(InventarioModel inventarioModel, Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteInventario(Integer id) {
		// TODO Auto-generated method stub

	}

	@Override
	public InventarioModel getByIdInventario(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public InventarioModel getInventarioByProduct(ProductoModel productoModel) {
		ProductoEntity productoEntity = this.mapperUtil.mapperObject(productoModel, ProductoEntity.class);
		InventarioEntity inventarioEntity = inventarioRepository.findByProductoEntity(productoEntity).get();
		return this.mapperUtil.mapperObject(inventarioEntity, InventarioModel.class);
	}

}
