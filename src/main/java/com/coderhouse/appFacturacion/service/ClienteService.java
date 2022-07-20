package com.coderhouse.appFacturacion.service;

import java.util.List;

import com.coderhouse.appFacturacion.entity.Cliente;
import com.coderhouse.appFacturacion.entity.Factura;
import com.coderhouse.appFacturacion.dto.ClienteDto;

public interface ClienteService {

	Cliente crearCliente(Cliente cliente);

	void modificarTelefonoCliente(Long id, String tel);

	void borrarCliente(Long id);

	Cliente buscarOCrearCliente(Cliente cliente);
	
	Cliente obtenerClientePorId(Long id);
	
	Cliente obtenerClientePorNombre(String nombre);
	
	Cliente obtenerClientePorDni(Cliente cliente);

	List<Cliente> obtenerTodosLosClientes();

	ClienteDto obtenerEdadClienteDto(Long id);

	List<Factura> obtenerFacturasPorIdCliente(Long id);

}
