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

import com.rah.demo.tienda.model.CompraInventarioModel;
import com.rah.demo.tienda.model.CompraModel;
import com.rah.demo.tienda.model.PageModel;
import com.rah.demo.tienda.service.CompraService;

@RestController
@RequestMapping("/compras")
public class CompraController {

	private CompraService compraService;

	public CompraController(CompraService compraService) {
		super();
		this.compraService = compraService;
	}

//	@PostMapping
//	public ResponseEntity<CompraModel> createCompra(@RequestBody CompraModel compraModel) {
//		return ResponseEntity.status(HttpStatus.CREATED).body(this.compraService.createCompra(compraModel));
//	}

	@PostMapping
	public ResponseEntity<CompraInventarioModel> createCompraInventario(
			@RequestBody CompraInventarioModel compraInventarioModel) {
		return ResponseEntity.status(HttpStatus.CREATED)
				.body(this.compraService.createCompraInvenetario(compraInventarioModel));
	}

	@GetMapping
	public ResponseEntity<List<CompraModel>> getAllCompra() {
		return ResponseEntity.ok(this.compraService.getAllCompra());
	}

	@GetMapping("/{page}/{size}")
	public ResponseEntity<PageModel> getAllCompraPaginada(@PathVariable Integer page, @PathVariable Integer size) {
		return ResponseEntity.ok(this.compraService.getAllCompraPaginada(page, size));
	}

	@PutMapping("/{id}")
	public ResponseEntity<CompraModel> updateCompra(@RequestBody CompraModel compraModel, @PathVariable Integer id) {
		return ResponseEntity.status(HttpStatus.CREATED).body(this.compraService.updateCompra(compraModel, id));
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteCompra(@PathVariable Integer id) {
		this.compraService.deleteCompra(id);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}

	@GetMapping("/{id}")
	private ResponseEntity<CompraModel> getByIdCompra(@PathVariable Integer id) {
		return ResponseEntity.ok(this.compraService.getByIdCompra(id));
	}
}
