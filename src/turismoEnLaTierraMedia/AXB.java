package turismoEnLaTierraMedia;

import java.util.Iterator;
import java.util.LinkedList;

public class AXB extends Promocion {
	private Atraccion atraccionBonificada;

	public AXB(String nombre, TipoDeAtraccion tipo, LinkedList<Atraccion> atracciones, Atraccion atraccionBonificada) {
		super(nombre, tipo, atracciones);
		this.atraccionBonificada = atraccionBonificada;
		this.calcularCosto();
		this.duracion += atraccionBonificada.duracion;
	}

	@Override
	public boolean contiene(Producto prod) {

		return super.contiene(prod) || this.atraccionBonificada.contiene(prod);
	}
	
	@Override
	public boolean hayCupo() {
	
		return super.hayCupo() && atraccionBonificada.hayCupo();
	}


	public void descontarCupo() throws Exception {
		super.descontarCupo();
			
		atraccionBonificada.descontarCupo();
	}

	private void calcularCosto() {
		for (Atraccion atraccion : atracciones) {
			this.costo += atraccion.costo;
		}
	}

	@Override
	public String toString() {

		return super.toString() + ", y lleva de regalo: " + this.atraccionBonificada.getNombre() + "]";
	}
}
