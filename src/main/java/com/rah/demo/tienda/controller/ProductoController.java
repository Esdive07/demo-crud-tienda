package com.rah.demo.tienda.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rah.demo.tienda.model.ProductoModel;
import com.rah.demo.tienda.service.ProductoService;

@RestController
@RequestMapping("/productos")
public class ProductoController {

	private ProductoService productoService;

	public ProductoController(ProductoService productoService) {
		super();
		this.productoService = productoService;
	}

	@PostMapping
	public ResponseEntity<ProductoModel> createProduct(@RequestBody ProductoModel productoModel) {
		return ResponseEntity.status(HttpStatus.CREATED).body(this.productoService.createProduct(productoModel));
	}

	@GetMapping
	public ResponseEntity<List<ProductoModel>> getAllProduct() {
		return ResponseEntity.ok(this.productoService.getAllProduct());
	}

	@PutMapping("/{id}")
	public ResponseEntity<ProductoModel> updateProduct(@RequestBody ProductoModel productoModel,
			@PathVariable Integer id) {
		return ResponseEntity.status(HttpStatus.CREATED).body(this.productoService.updateProduct(productoModel, id));
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteProduct(@PathVariable Integer id) {
		this.productoService.deleteProduct(id);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}

	@GetMapping("/{id}")
	public ResponseEntity<ProductoModel> getByIdProduct(@PathVariable Integer id) {
		return ResponseEntity.ok(this.productoService.getByIdProduct(id));
	}
}
