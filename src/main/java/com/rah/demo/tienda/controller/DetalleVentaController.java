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

import com.rah.demo.tienda.model.DetalleVentaModel;
import com.rah.demo.tienda.service.DetalleVentaService;

@RestController
@RequestMapping("/detalleVentas")
public class DetalleVentaController {

	private DetalleVentaService detalleVentaService;

	public DetalleVentaController(DetalleVentaService detalleVentaService) {
		super();
		this.detalleVentaService = detalleVentaService;
	}

	@PostMapping
	public ResponseEntity<DetalleVentaModel> createDetalleVenta(@RequestBody DetalleVentaModel detalleVentaModel) {
		return ResponseEntity.status(HttpStatus.CREATED)
				.body(this.detalleVentaService.createDetalleVenta(detalleVentaModel));
	}

	@GetMapping
	public ResponseEntity<List<DetalleVentaModel>> getAllDetalleVenta() {
		return ResponseEntity.ok(this.detalleVentaService.getAllDetalleVenta());
	}

	@PutMapping("/{id}")
	public ResponseEntity<DetalleVentaModel> updateDetalleVenta(@RequestBody DetalleVentaModel detalleVentaModel,
			@PathVariable Integer id) {
		return ResponseEntity.status(HttpStatus.CREATED)
				.body(this.detalleVentaService.updateDetalleVenta(detalleVentaModel, id));
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteDetalleVenta(@PathVariable Integer id) {
		this.detalleVentaService.deleteDetalleVenta(id);
		return ResponseEntity.status(HttpStatus.CREATED).build();
	}

	@GetMapping("/{id}")
	public ResponseEntity<DetalleVentaModel> getByIdDetalleVenta(@PathVariable Integer id) {
		return ResponseEntity.ok(this.detalleVentaService.getByIdDetalleVenta(id));
	}
}
