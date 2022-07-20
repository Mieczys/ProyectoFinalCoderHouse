package com.coderhouse.appFacturacion.repository;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.coderhouse.appFacturacion.entity.Factura;

@Repository
public interface FacturaRepository  extends JpaRepository<Factura, Long>{

	public Factura findById(int id);

}
