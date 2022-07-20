package com.coderhouse.appFacturacion.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.coderhouse.appFacturacion.entity.Cliente;
import com.coderhouse.appFacturacion.entity.Empresa;

@Repository
public interface EmpresaRepository extends JpaRepository<Empresa, Long> {
	
	public Cliente findById(int id);
	public Cliente findByRazonSocial(String razonSocial);
	public Cliente findByCuit(String cuit);

}
