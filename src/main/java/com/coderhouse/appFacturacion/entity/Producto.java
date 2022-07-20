package com.coderhouse.appFacturacion.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.*;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name = "PRODUCTOS")
@Entity(name= "PRODUCTO")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer", "referenceList"})
public class Producto {
	
	@Column(name = "ID_PRODUCTO")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonIgnore
	private Long id;
	
	@NotBlank(message = "Nombre de producto obligatorio")
	@Column(name = "NOMBRE")
	private String nombre;
	
	@Column(name = "DESCRIPCION")
	private String descripcion;
	
	@NotBlank(message = "Plataforma obligatoria")
	@Column(name = "PLATAFORMA")
	private String plataforma;	
	
	@Min(1)
	@Column(name = "PRECIO_UNITARIO")
	private double precio;
	
	@NotBlank(message = "Categoria obligatoria")
	@Column(name = "CATEGORIA")
	private String categoria;
	
	@Min(0)
	@Column(name = "STOCK")
	private int stock;
	
	@ManyToOne
	@JoinColumn(name="ID_FACTURA")
	@JsonBackReference
	private Factura factura;

}
