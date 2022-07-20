package com.coderhouse.appFacturacion.dto;

import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class ClienteDto {

	private String nombre;
	private String apellido;
	private LocalDate fechaNacimiento;
	private int edad;

	

	

	
}
