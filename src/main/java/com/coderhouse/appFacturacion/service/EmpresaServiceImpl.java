package com.coderhouse.appFacturacion.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coderhouse.appFacturacion.entity.Empresa;
import com.coderhouse.appFacturacion.exception.DbException;
import com.coderhouse.appFacturacion.repository.EmpresaRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class EmpresaServiceImpl implements EmpresaService{
	
	@Autowired
	EmpresaRepository empresaRepository;

	public Empresa crearEmpresa(Empresa empresa) {
		return empresaRepository.save(empresa);
	}

	public void borrarEmpresa(Long id) throws Exception {
		Empresa empresa =  obtenerEmpresaPorId(id);
		empresaRepository.deleteById(id);
		log.info("Se va a borrar la empresa {}",empresa.getRazonSocial().toUpperCase());
	}

	public Empresa obtenerEmpresaPorId(Long id) {
		
		Optional <Empresa> empresa = empresaRepository.findById(id);

		if (empresa.isPresent()) {
			
			return empresa.get();
			
		} else {
			
			throw new DbException("No existe esa empresa en la bd");
		}
		
	}

	public List<Empresa> obtenerTodasLasEmpresas() {
		return empresaRepository.findAll();
	}


	

}
