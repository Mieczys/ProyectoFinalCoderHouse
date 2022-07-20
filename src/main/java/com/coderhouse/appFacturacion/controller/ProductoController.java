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

import com.coderhouse.appFacturacion.entity.Producto;
import com.coderhouse.appFacturacion.service.ProductoService;

import lombok.Data;

@Data
@RestController
public class ProductoController {

	@Autowired
	ProductoService productoService;

	@GetMapping("/getProductoByNombre")
	public ResponseEntity<List<Producto>> getProductoByNombre(@Param("nombre") String nombre) {
		List<Producto> producto = productoService.obtenerProductosPorNombre(nombre);
		return ResponseEntity.ok().body(producto);
	}
	
	@GetMapping("/getProductoById/{id}")
	public ResponseEntity<Producto> getProductoById(@PathVariable(value = "id") Long productoId) throws Exception {
		Producto producto = productoService.obtenerProductoPorId(productoId);
		return ResponseEntity.ok().body(producto);
	}

	@GetMapping("/getProductoByNombreYPlataforma")
	public ResponseEntity<Producto> getProductoByNombrePlataforma(@Param("nombre") String nombre, @Param("plataforma") String plataforma) throws Exception {
		Producto producto = productoService.obtenerProductoPorNombreYPlataforma(nombre, plataforma);
		return ResponseEntity.ok().body(producto);
	}
	
	@GetMapping("/getProductos")
	public ResponseEntity<List<Producto>> getAllProductos() {
		List<Producto> productoList = productoService.obtenerTodosLosProductos();
		return ResponseEntity.ok().body(productoList);
	}

	@GetMapping("/getProductosPlataforma")
	public ResponseEntity<List<Producto>> getAllProductosPlataforma(@Param("plataforma") String plataforma) {
		List<Producto> productoList = productoService.obtenerProductosPorPlataforma(plataforma);
		return ResponseEntity.ok().body(productoList);
	}
	
	@GetMapping("/getProductosCategoria")
	public ResponseEntity<List<Producto>> getAllProductosCategoria(@Param("categoria") String categoria) {
		List<Producto> productoList = productoService.obtenerProductosPorCategoria(categoria);
		return ResponseEntity.ok().body(productoList);
	}

	
	@PostMapping("/createProducto")
	public ResponseEntity<Producto> createProducto(@RequestBody Producto producto) {
		Producto nuevoProducto = productoService.crearProducto(producto);
		return ResponseEntity.ok().body(nuevoProducto);
	}

	@PutMapping("/updatePrecioProducto")
	public void updatePrecioProducto(@Param("id") Long id, @Param("precio") double precio) {
		productoService.modificarPrecioProducto(id, precio);
		
	}

	@DeleteMapping("/deleteProducto/{id}")
	public void deleteProducto(@PathVariable(value = "id") Long productoId) {
		productoService.borrarProducto(productoId);
	}

	@PutMapping("/updateStockProducto")
	public void restarStockProducto(@Param("id") Long id, @Param("cant") int cant) {
		productoService.restarStock(id, cant);
	}

}
