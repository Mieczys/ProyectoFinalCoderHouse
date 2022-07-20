package com.coderhouse.appFacturacion.service;

import java.util.List;

import com.coderhouse.appFacturacion.dto.FacturaDto;
import com.coderhouse.appFacturacion.entity.Factura;

public interface FacturaService {
	
	Factura facturarCompra(FacturaDto compra);

	void borrarFactura(Long id);

	Factura obtenerFacturaPorId(Long id) ;

	List<Factura> obtenerTodasLasFacturas();
	

}
