package com.coderhouse.appFacturacion.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.coderhouse.appFacturacion.dto.FacturaDto;
import com.coderhouse.appFacturacion.entity.Factura;
import com.coderhouse.appFacturacion.service.FacturaService;


@RestController
public class FacturaController {
	
	
	@Autowired
	FacturaService facturaService;
	
	
	@PostMapping("/facturarCompraDto")
	public Factura facturarCompraDto(@RequestBody FacturaDto compra) {
		return facturaService.facturarCompra(compra);
	}
	
	@GetMapping("/getFacturasList")
	public ResponseEntity<List<Factura>> getAllFacturas() {
		List<Factura> facturasList = facturaService.obtenerTodasLasFacturas();
		return ResponseEntity.ok().body(facturasList);
	}
	
	@GetMapping("/getFacturaById/{id}")
	public ResponseEntity<Factura> getFacturaById(@PathVariable(value = "id") Long facturaId) {
		Factura factura = facturaService.obtenerFacturaPorId(facturaId);
	       return ResponseEntity.ok().body(factura);
	}


}
