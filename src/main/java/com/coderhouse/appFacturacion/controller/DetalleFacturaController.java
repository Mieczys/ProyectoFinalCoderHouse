package com.coderhouse.appFacturacion.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.coderhouse.appFacturacion.entity.DetalleFactura;
import com.coderhouse.appFacturacion.service.DetalleFacturaService;

import lombok.Data;

@Data
@RestController
public class DetalleFacturaController {
	
	
	@Autowired
	DetalleFacturaService itemService;

	@GetMapping("/getItemById/{id}")
	public ResponseEntity<DetalleFactura> getItem(@PathVariable(value = "id") Long itemId) throws Exception {
		DetalleFactura item = itemService.obtenerDetalleFacturaPorId(itemId);
		return ResponseEntity.ok().body(item);
	}

	@GetMapping("/getItemsList")
	public ResponseEntity<List<DetalleFactura>> getAllItems() {
		List<DetalleFactura> itemList = itemService.obtenerTodosLosDetalleFactura();
		return ResponseEntity.ok().body(itemList);
	}

	@PostMapping("/createItem")
	public ResponseEntity<DetalleFactura> createItem(@RequestBody DetalleFactura item) {
		DetalleFactura nuevoItem = itemService.crearDetalleFactura(item);
		return ResponseEntity.ok().body(nuevoItem);
	}


	@PutMapping("/updateCantidadItem")
	public void updateCantidadItem(@Param("id") Long id, @Param("cant") int cant) throws Exception {
		itemService.modificarCantidadDetalleFacturaById(id, cant);
		
	}

	@DeleteMapping("/deleteItem/{id}")
	public void deleteItem(@PathVariable(value = "id") Long itemId) throws Exception {
		itemService.borrarDetalleFactura(itemId);
	}


}
