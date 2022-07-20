package com.coderhouse.appFacturacion.service;

import java.util.List;
import com.coderhouse.appFacturacion.entity.Producto;

public interface ProductoService {
	
	Producto crearProducto(Producto producto);

	void modificarPrecioProducto(Long id, double precio);

	void borrarProducto(Long id);
	
	List<Producto> obtenerProductosPorNombre(String nombre);
	
	Producto obtenerProductoPorNombreYPlataforma(String nombre, String plataforma);
	
	Producto obtenerProductoPorNombre(String nombre);
	
	Producto obtenerProductoPorId(Long id);
	
	List<Producto> obtenerTodosLosProductos();
	
	List<Producto> obtenerProductosPorPlataforma(String plataforma);
	
	List<Producto> obtenerProductosPorCategoria(String categoria);

	void restarStock(Long id, int cant);



}
