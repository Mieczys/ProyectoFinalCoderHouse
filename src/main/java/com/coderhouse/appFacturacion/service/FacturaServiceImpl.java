package com.coderhouse.appFacturacion.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coderhouse.appFacturacion.dto.DetalleFacturaDto;
import com.coderhouse.appFacturacion.dto.FacturaDto;
import com.coderhouse.appFacturacion.entity.Cliente;
import com.coderhouse.appFacturacion.entity.DetalleFactura;
import com.coderhouse.appFacturacion.entity.Empresa;
import com.coderhouse.appFacturacion.entity.Factura;
import com.coderhouse.appFacturacion.entity.Producto;
import com.coderhouse.appFacturacion.exception.DbException;
import com.coderhouse.appFacturacion.repository.FacturaRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class FacturaServiceImpl implements FacturaService {

	@Autowired
	FacturaRepository facturaRepository;
	
	@Autowired
	EmpresaService empresaService;

	@Autowired
	ProductoService productoService;

	@Autowired
	ClienteService clienteService;

	public void borrarFactura(Long id) {
		Factura factura = obtenerFacturaPorId(id);
		facturaRepository.deleteById(id);
		log.info("Se va a borrar la factura {}", factura.getId());
	}

	public Factura obtenerFacturaPorId(Long id) {

		Optional<Factura> factura = facturaRepository.findById(id);

		if (factura.isPresent()) {

			return factura.get();

		} else {

			throw new DbException("No existe esa factura en la bd");
		}

	}

	public List<Factura> obtenerTodasLasFacturas() {
		return facturaRepository.findAll();
	}

	public Factura facturarCompra(FacturaDto compra) {
		
		Cliente cliente = clienteService.buscarOCrearCliente(compra.getCliente());
		
			
		Factura factura = new Factura();
		Date date = new Date();
		factura.setCliente(cliente);
		factura.setFecha(date);
		
		Empresa empresa = empresaService.obtenerEmpresaPorId(compra.getIdEmpresa());
		
		factura.setEmpresa(empresa);
		
		factura.setDetalleFactura(new HashSet<>());
		double totalCompra = 0;
		List<Producto> productosLista = new ArrayList<>();

		for (DetalleFacturaDto c : compra.getDetalleFacturaDtos()) {

			
			Producto miProducto = productoService.obtenerProductoPorNombreYPlataforma(c.getNombreProducto(), c.getPlataformaProducto());
			productosLista.add(miProducto);
			int cantidad = c.getCantidad();
			double precio = miProducto.getPrecio();
			double subTotal = precio * cantidad;
			productoService.restarStock(miProducto.getId(), cantidad);
			totalCompra += subTotal;
			DetalleFactura detalle = crearDetalleFacturaParam(c.getNombreProducto(), c.getPlataformaProducto(),
					cantidad, subTotal);
			factura.agregarDetalle(detalle);
			factura.setProductos(productosLista);
		}

		factura.setTotal(totalCompra);

		Factura miFactura = facturaRepository.save(factura);
		log.error("Información de factura warning {}", miFactura);

		return miFactura;

	}

	public DetalleFactura crearDetalleFacturaParam(String nombreProducto, String plataforma, int cantidad,
			double subTotal) {
		DetalleFactura detalleFacturaAGuardar = new DetalleFactura();

		detalleFacturaAGuardar.setNombreProducto(nombreProducto);
		detalleFacturaAGuardar.setPlataformaProducto(plataforma);
		detalleFacturaAGuardar.setCantidad(cantidad);
		detalleFacturaAGuardar.setPrecioSubTotal(subTotal);
		return detalleFacturaAGuardar;
	}

		
}
