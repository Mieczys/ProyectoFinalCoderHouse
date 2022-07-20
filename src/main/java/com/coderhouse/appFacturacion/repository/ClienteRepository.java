package com.coderhouse.appFacturacion.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.coderhouse.appFacturacion.entity.Cliente;



@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {
	
	public Cliente findById(int id);
	public Cliente findByNombre(String nombre);
	public Cliente findByApellido(String apellido);
	public Cliente findByDni(String dni);
	
	
}
