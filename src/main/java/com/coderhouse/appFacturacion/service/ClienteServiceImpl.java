package com.coderhouse.appFacturacion.service;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;
import java.util.Optional;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coderhouse.appFacturacion.entity.Cliente;
import com.coderhouse.appFacturacion.entity.Factura;
import com.coderhouse.appFacturacion.exception.DbException;
import com.coderhouse.appFacturacion.dto.ClienteDto;
import com.coderhouse.appFacturacion.repository.ClienteRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class ClienteServiceImpl implements ClienteService {

	@Autowired
	ClienteRepository clienteRepository;

	public Cliente crearCliente(Cliente cliente) {

		
		return clienteRepository.save(cliente);

	}

	public Cliente buscarOCrearCliente(Cliente cliente) {
		
		Optional<Cliente> miCliente = clienteRepository.findById(cliente.getId());
		
		if (miCliente.isPresent()) {

			return miCliente.get();

		} else {
			
			return this.crearCliente(cliente);
		}
		
	}

	public void modificarTelefonoCliente(Long id, String tel) {

		Cliente clienteModificado = obtenerClientePorId(id);

		if (Pattern.matches("^[0-9]{2,3}[0-9]{4}[0-9]{4}$", tel)) {
			clienteModificado.setTelefono(tel);
			log.info("Se modificó el telefono de " + clienteModificado.getApellido().toUpperCase() + ", "
					+ clienteModificado.getNombre());
			clienteRepository.save(clienteModificado);
		} else {

			throw new DbException(
					"Formato de teléfono no es valido. No debe contener espacios ni carácteres especiales.");
		}

	}

	public void borrarCliente(Long id) {
		Cliente cliente = obtenerClientePorId(id);
		log.info("Se va a borrar el cliente {}", cliente.getApellido().toUpperCase() + ", " + cliente.getNombre());
		clienteRepository.deleteById(id);
	}

	public Cliente obtenerClientePorId(Long id) {

		Optional<Cliente> cliente = clienteRepository.findById(id);

		if (cliente.isPresent()) {

			return cliente.get();

		} else {

			throw new DbException("No existe ese cliente en la BD");
		}

	}

	public List<Cliente> obtenerTodosLosClientes() {
		return clienteRepository.findAll();
	}

	public ClienteDto obtenerEdadClienteDto(Long id) {

		Cliente cliente = obtenerClientePorId(id);

		LocalDate fechaNacimiento = cliente.getFechaNacimiento();

		LocalDate hoy = LocalDate.now();

		Period periodo = Period.between(fechaNacimiento, hoy);

		int edad = periodo.getYears();

		return new ClienteDto(cliente.getNombre(), cliente.getApellido(), cliente.getFechaNacimiento(), edad);
	}

	public Cliente obtenerClientePorNombre(String nombre) {
		return clienteRepository.findByNombre(nombre);
	}

	public Cliente obtenerClientePorDni(Cliente cliente) {

		Optional<Cliente> clienteBuscado = Optional.ofNullable(clienteRepository.findByDni(cliente.getDni()));

		if (clienteBuscado.isPresent()) {
			log.info("Ya existe el cliente");
			return clienteBuscado.get();
		} else {
			log.info("Se guarda nuevo cliente");
			return this.crearCliente(cliente);
		}

	}

	public List<Factura> obtenerFacturasPorIdCliente(Long id) {
		
		Cliente cliente = obtenerClientePorId(id);
	
		return cliente.getFacturas();
	}

}
