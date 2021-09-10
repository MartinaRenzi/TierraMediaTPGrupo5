package turismoEnLaTierraMedia;

import java.util.LinkedList;

public abstract class Promocion extends Producto {
	LinkedList<Atraccion> atracciones;

	public Promocion(String nombre, TipoDeAtraccion tipo, LinkedList<Atraccion> atracciones) {
		super();
		this.nombre = nombre;
		this.tipo = tipo;
		this.atracciones = atracciones;
		this.calcularDuracion();
	}

	private void calcularDuracion() {
		for (Atraccion atraccion : atracciones) {
			this.duracion += atraccion.duracion;
		}
	}
	
	public LinkedList<String> obtenerNombreAtraccionesDeLista() {
		LinkedList<String> atraccionesQueIncluye = new LinkedList<String>();
		for (Atraccion atraccion : atracciones) {
			atraccionesQueIncluye.add(atraccion.getNombre());
			}
		return atraccionesQueIncluye;
	}
	@Override
	public String toString() {
		return super.toString() + ", Incluye: " + obtenerNombreAtraccionesDeLista();
	}

}
