package turismoEnLaTierraMedia;

import java.util.Iterator;
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

	@Override
	public boolean contiene(Producto prod) {
		boolean contiene = false;
		Iterator<Atraccion> itr = this.atracciones.iterator();
		while (!contiene && itr.hasNext()) {
			contiene = prod.contiene(itr.next());
		}
		return contiene;
	}

	private void calcularDuracion() {
		for (Atraccion atraccion : atracciones) {
			this.duracion += atraccion.duracion;
		}
	}

	public boolean hayCupo() {
		boolean hayCupo = true;
		Iterator<Atraccion> itr = this.atracciones.iterator();
		while (hayCupo && itr.hasNext()) {
			hayCupo = itr.next().hayCupo();

		}
		return hayCupo;
	}

	public void descontarCupo() throws Exception {
		for (Atraccion atraccion : atracciones) {
			atraccion.descontarCupo();
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
		return super.toString() + ", Incluye: " + this.obtenerNombreAtraccionesDeLista();
	}

	@Override
	public boolean esPromo() {
		return true;
	}

}
