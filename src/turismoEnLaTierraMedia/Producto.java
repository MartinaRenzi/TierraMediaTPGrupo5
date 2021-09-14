package turismoEnLaTierraMedia;

import java.util.List;

public abstract class Producto {

	protected String nombre;
	protected double costo;
	protected double duracion;
	protected TipoDeAtraccion tipo;

	public Producto(String nombre, double costo, double duracion, TipoDeAtraccion tipo) {
		super();
		this.nombre = nombre;
		this.costo = costo;
		this.duracion = duracion;
		this.tipo = tipo;
	}

	public Producto() {

	}

	public String getNombre() {
		return nombre;
	}

	public double getDuracion() {
		return duracion;
	}

	public TipoDeAtraccion getTipo() {
		return tipo;
	}

	public double getCosto() {
		return costo;
	}

	 public abstract List<TipoDeAtraccion> getListaDeTiposAtraccion();

	@Override
	public String toString() {

		return "[ Nombre: " + this.nombre + ", Costo: " + this.costo + ", Duracion: " + this.duracion + ", Tipo: "
				+ this.tipo;
	}

	public boolean esPromo() {
		return false;
	}

}
