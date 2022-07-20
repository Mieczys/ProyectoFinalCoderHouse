package com.coderhouse.appFacturacion.service;

import java.util.List;

import com.coderhouse.appFacturacion.entity.DetalleFactura;

public interface DetalleFacturaService {
	
	DetalleFactura crearDetalleFactura(DetalleFactura item);

	void modificarCantidadDetalleFacturaById(Long id, int cant);

	void borrarDetalleFactura(Long id);

	DetalleFactura obtenerDetalleFacturaPorId(Long id);

	List<DetalleFactura> obtenerTodosLosDetalleFactura();


}
