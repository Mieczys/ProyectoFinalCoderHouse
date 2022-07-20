package com.coderhouse.appFacturacion.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.coderhouse.appFacturacion.entity.Producto;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Long>{
	
	public Producto findById(int id);
	public List<Producto> findAll();
	public List<Producto> findAllByNombre(String nombre);
	public List<Producto> findByPlataforma(String plataforma);
	public Producto findByPrecio(double precio);
	public List<Producto> findByCategoria(String categoria);
	public Producto findByStock(int stock);
	public List<Producto> findAllByPlataforma(String plataforma);
	public List<Producto> findAllByCategoria(String categoria);
	public Producto findByNombre(String nombre);
	
	
	
	

}
