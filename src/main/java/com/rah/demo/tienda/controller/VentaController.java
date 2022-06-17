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

import com.rah.demo.tienda.model.VentaModel;
import com.rah.demo.tienda.service.VentaService;

@RestController
@RequestMapping("/ventas")
public class VentaController {

	private VentaService ventaService;

	public VentaController(VentaService ventaService) {
		super();
		this.ventaService = ventaService;
	}

	@PostMapping
	public ResponseEntity<VentaModel> createVenta(@RequestBody VentaModel ventaModel) {
		return ResponseEntity.status(HttpStatus.CREATED).body(this.ventaService.createVenta(ventaModel));
	}

	@GetMapping
	public ResponseEntity<List<VentaModel>> getAllVenta() {
		return ResponseEntity.ok(this.ventaService.getAllVenta());
	}

	@PutMapping("/{id}")
	public ResponseEntity<VentaModel> updateVenta(@RequestBody VentaModel ventaModel, @PathVariable Integer id) {
		return ResponseEntity.status(HttpStatus.CREATED).body(this.ventaService.updateVenta(ventaModel, id));
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteVenta(@PathVariable Integer id) {
		this.ventaService.deleteVenta(id);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}

	@GetMapping("/{id}")
	public ResponseEntity<VentaModel> getByIdVenta(@PathVariable Integer id) {
		return ResponseEntity.ok(this.ventaService.getByIdVenta(id));
	}
}
