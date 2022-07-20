package com.coderhouse.appFacturacion.service;

import java.util.List;

import com.coderhouse.appFacturacion.entity.Empresa;

public interface EmpresaService {

	Empresa crearEmpresa(Empresa empresa);

	void borrarEmpresa(Long id) throws Exception;

	Empresa obtenerEmpresaPorId(Long id);

	List<Empresa> obtenerTodasLasEmpresas();


}
