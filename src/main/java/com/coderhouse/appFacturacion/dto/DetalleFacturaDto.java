package com.coderhouse.appFacturacion.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DetalleFacturaDto {
	

	private String nombreProducto;
	private String plataformaProducto;
	private int cantidad;
	


}
