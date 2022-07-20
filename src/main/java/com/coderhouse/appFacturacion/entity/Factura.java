package com.coderhouse.appFacturacion.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Table(name = "FACTURAS")
@Entity(name= "FACTURA")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Factura implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="ID_FACTURA")
	private Long id;
	
	@ManyToOne
	@JoinColumn(name="ID_CLIENTE")
	private Cliente cliente;
	
	@JsonIgnore
	@OneToMany(mappedBy="factura", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private List <Producto> productos;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date fecha;
	
	@Min(0)
	@Column(name = "VALOR_TOTAL")
	@NotNull
	private double total;
	
	@ManyToOne
	private Empresa empresa;	
	
	@OneToMany(mappedBy="factura", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private Set<DetalleFactura> detalleFactura;
	
	public DetalleFactura agregarDetalle(DetalleFactura detalleFactura) {
		
		getDetalleFactura().add(detalleFactura);
		detalleFactura.setFactura(this);
		return detalleFactura;
		
	}
	
	public DetalleFactura removerDetalle(DetalleFactura detalleFactura) {
		
		getDetalleFactura().remove(detalleFactura);
		detalleFactura.setFactura(null);
		return detalleFactura;
	}


	
	

	

}
