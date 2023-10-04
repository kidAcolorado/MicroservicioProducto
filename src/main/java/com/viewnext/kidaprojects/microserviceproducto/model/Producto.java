package com.viewnext.kidaprojects.microserviceproducto.model;

import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


/**
 * La clase {@code Producto} representa un producto que puede ser almacenado en la base de datos.
 * Contiene información como el código del producto, el nombre del producto, el precio por unidad
 * y la cantidad en stock.
 *
 * <p>
 * El autor de esta clase es Víctor Colorado "Kid A".
 * </p>
 *
 * @version 1.0
 * @since 3 de Octubre de 2023
 */
@Entity
@Table(name = "productos")
public class Producto {

	@Id
	private int codigo;
	private String producto;
	private double precioUnidad;
	private int stock;
	
	public Producto(int codigo, String producto, double precioUnidad, int stock) {
		super();
		this.codigo = codigo;
		this.producto = producto;
		this.precioUnidad = precioUnidad;
		this.stock = stock;
	}

	public Producto() {
		super();
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getProducto() {
		return producto;
	}

	public void setProducto(String producto) {
		this.producto = producto;
	}

	public double getPrecioUnidad() {
		return precioUnidad;
	}

	public void setPrecioUnidad(double precioUnidad) {
		this.precioUnidad = precioUnidad;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	@Override
	public int hashCode() {
		return Objects.hash(codigo);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Producto other = (Producto) obj;
		return codigo == other.codigo;
	}

	@Override
	public String toString() {
		return "Producto [codigo=" + codigo + ", producto=" + producto + ", precioUnidad=" + precioUnidad + ", stock="
				+ stock + "]";
	}
	
	
	
	
}
