package turismoEnLaTierraMedia;

import java.util.LinkedList;

public class PromocionPorcentual extends Promocion {

	private double descuento;

	public PromocionPorcentual(String nombre, TipoDeAtraccion tipo, LinkedList<Atraccion> atracciones,
			double descuento) {
		super(nombre, tipo, atracciones);
		this.descuento = descuento;
		this.calcularCostoConDescuento();
	}

	private void calcularCostoConDescuento() {
		for (Atraccion atraccion : atracciones) {
			this.costo += atraccion.costo;
		}
		this.costo -= this.costo * (this.descuento / 100);

	}

}
