package com.coderhouse.appFacturacion.dto;


import java.util.List;

import com.coderhouse.appFacturacion.entity.Cliente;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FacturaDto {
	

	private Cliente cliente;
	
	private List<DetalleFacturaDto> detalleFacturaDtos;
	
	private Long idEmpresa;
	

	
}
