package com.coderhouse.appFacturacion.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coderhouse.appFacturacion.entity.Producto;
import com.coderhouse.appFacturacion.exception.DbException;
import com.coderhouse.appFacturacion.repository.ProductoRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class ProductoServiceImpl implements ProductoService {

	@Autowired
	ProductoRepository productoRepository;

	public Producto crearProducto(Producto producto) {
		return productoRepository.save(producto);
	}

	public void modificarPrecioProducto(Long id, double precio) {
		
		Producto productoModificado = obtenerProductoPorId(id);
		
		if(precio > 0) {
			
			productoModificado.setPrecio(precio);
			log.info("Se ha modificado el precio del producto "+productoModificado.getNombre() + " a $" + precio);
			productoRepository.save(productoModificado);
			
		} else {
			
			throw new DbException("No se puede ingresar número negativo");
			
		}
		
	
	}

	public void borrarProducto(Long id)   {
		
		Producto producto = obtenerProductoPorId(id);
		productoRepository.deleteById(id);
		log.info("Se va a borrar el producto {}", producto.getNombre());
	}

	public List <Producto> obtenerProductosPorNombre(String nombre){
		
			return productoRepository.findAllByNombre(nombre);
						
	}
	
	public Producto obtenerProductoPorNombreYPlataforma(String nombre, String plataforma){
	
		Producto miProducto = null;
		List<Producto> misProductos = obtenerProductosPorNombre(nombre);
		
		for(Producto p: misProductos) {
			
			if(p.getPlataforma().equalsIgnoreCase(plataforma)) {
				miProducto = p;
			}
		}
		
		if(miProducto == null) {
			
			throw new DbException("No existe ese producto en la bd");
		}
		
		return miProducto;

}
		
	public Producto obtenerProductoPorId(Long id) {

		Optional <Producto> producto = productoRepository.findById(id);

		if (producto.isPresent()) {
			
			log.info("El producto "+producto.get().getNombre()+" está en la bd.");
			return producto.get();
			
		} else {
			
			throw new DbException("No existe ese producto en la bd");
		}

	}
	
	public List<Producto> obtenerTodosLosProductos() {
		return productoRepository.findAll();
	}
		
	
	public void restarStock(Long id, int cant)  {

		Optional<Producto> producto = productoRepository.findById(id);

		if (producto.isPresent()) {
			
			Producto productoModificado = producto.get();

			if (cant > 0) {
		

				if (productoModificado.getStock() >= cant) {

					productoModificado.setStock(productoModificado.getStock() - cant);
					productoRepository.save(productoModificado);
					
					
				} else {

					throw new DbException("No hay suficiente stock para "+productoModificado.getNombre()+" para la plataforma "+productoModificado.getPlataforma()+". Stock disponible: "
							+ productoModificado.getStock());
					
				}

			} else {
				
				throw new DbException("No se puede ingresar número negativo");
			}

		} else {

			throw new DbException("No existe ese producto en la bd");
		}

	
	}
	
	public List<Producto> obtenerProductosPorPlataforma(String plataforma) {
		return productoRepository.findAllByPlataforma(plataforma);
	}

	public List<Producto> obtenerProductosPorCategoria(String categoria) {
		return productoRepository.findAllByCategoria(categoria);
	}

	public Producto obtenerProductoPorNombre(String nombre) {

		return productoRepository.findByNombre(nombre);
	}


}
