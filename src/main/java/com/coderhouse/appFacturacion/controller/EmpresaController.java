package com.coderhouse.appFacturacion.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.coderhouse.appFacturacion.entity.Empresa;
import com.coderhouse.appFacturacion.service.EmpresaService;

import lombok.Data;

@Data
@RestController
public class EmpresaController {

	@Autowired
	EmpresaService empresaService;

	@GetMapping("/getEmpresaById/{id}")
	public ResponseEntity<Empresa> getEmpresa(@PathVariable(value = "id") Long empresaId) throws Exception {
		Empresa empresa = empresaService.obtenerEmpresaPorId(empresaId);
		return ResponseEntity.ok().body(empresa);
	}

	@GetMapping("/getEmpresasList")
	public ResponseEntity<List<Empresa>> getAllEmpresas() {
		List<Empresa> empresaList = empresaService.obtenerTodasLasEmpresas();
		return ResponseEntity.ok().body(empresaList);
	}

	@PostMapping("/createEmpresa")
	public ResponseEntity<Empresa> createEmpresa(@RequestBody Empresa empresa) {
		Empresa nuevaEmpresa = empresaService.crearEmpresa(empresa);
		return ResponseEntity.ok().body(nuevaEmpresa);
	}

	@DeleteMapping("/deleteEmpresa/{id}")
	public void deleteEmpresa(@PathVariable(value = "id") Long empresaId) throws Exception {
		empresaService.borrarEmpresa(empresaId);
	}

}
