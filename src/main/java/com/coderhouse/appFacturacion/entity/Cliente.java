package com.coderhouse.appFacturacion.entity;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name = "CLIENTES")
@Entity(name = "CLIENTE")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Cliente {
	
	@Column(name = "ID_CLIENTE")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank(message = "Nombre obligatorio")
	@Column(name = "NOMBRE")
	private String nombre;

	@NotBlank(message = "Apellido  obligatorio")
	@Column(name = "APELLIDO")
	private String apellido;

	@Column(name = "FECHA_NACIMIENTO")
	private LocalDate fechaNacimiento;

	@NotBlank(message = "DNI obligatorio")
	@Column(name = "DNI")
	private String dni;
	
	@NotBlank(message = "Dirección obligatoria")
	@Column(name = "DIRECCION")
	private String direccion;

	@NotBlank(message = "Teléfono obligatorio")
	@Column(name = "TELEFONO")
	private String telefono;

	@Email(message = "Debe ingresar un email")
	@Column(name = "EMAIL")
	private String email;
	
	@JsonIgnore
	@OneToMany(mappedBy="cliente", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private List<Factura> facturas;	



}
