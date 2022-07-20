package com.coderhouse.appFacturacion.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.coderhouse.appFacturacion.entity.DetalleFactura;
import com.coderhouse.appFacturacion.exception.DbException;
import com.coderhouse.appFacturacion.repository.DetalleFacturaRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class DetalleFacturaServiceImpl implements DetalleFacturaService {
	

	@Autowired
	DetalleFacturaRepository detalleFacturaRepository;

	public DetalleFactura crearDetalleFactura(DetalleFactura item) {
		
		
		return detalleFacturaRepository.save(item);
	}

	public void modificarCantidadDetalleFacturaById(Long id, int cant) {
		DetalleFactura itemModificado = obtenerDetalleFacturaPorId(id);
		itemModificado.setCantidad(cant);
		detalleFacturaRepository.save(itemModificado);

	}

	public void borrarDetalleFactura(Long id) {
		DetalleFactura item = obtenerDetalleFacturaPorId(id);
		detalleFacturaRepository.deleteById(id);
		log.info("Se va a borrar el item {}",item.getId());
	}

	public DetalleFactura obtenerDetalleFacturaPorId(Long id){
		
		Optional <DetalleFactura> item = detalleFacturaRepository.findById(id);

		if (item.isPresent()) {
			
			return item.get();
			
		} else {
			
			throw new DbException("No existe ese item de compra en la bd");
		}

		
	}

	public List<DetalleFactura> obtenerTodosLosDetalleFactura() {
		return detalleFacturaRepository.findAll();
	}


}
