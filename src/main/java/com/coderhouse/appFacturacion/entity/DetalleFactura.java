package com.coderhouse.appFacturacion.entity;

import java.io.Serializable;

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

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name = "DETALLE_FACTURA")
@Entity(name = "DETALLE_FACTURA")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DetalleFactura implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Column(name = "ID_DETALLEFACTURA")
	@Id
	@JsonIgnore
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
	@JoinColumn(name="ID_FACTURA")
	@JsonBackReference
	private Factura factura;
	
	@Column(name="NOMBRE_PRODUCTO")
	private String nombreProducto;
	
	@Column(name="PLATAFORMA_PRODUCTO")
	private String plataformaProducto;
	
	@Min(1)
	@Column(name = "CANTIDAD")
	private int cantidad;
	
	@Min(0)
	@Column(name = "PRECIO_SUBTOTAL")
	private double precioSubTotal;
	
	
	
	
}
