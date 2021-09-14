package turismoEnLaTierraMedia;

import java.util.Comparator;

public class ProductosPorPreferencia implements Comparator<Producto> {

	private TipoDeAtraccion tipo;

	public ProductosPorPreferencia(TipoDeAtraccion tipo) {
		this.tipo = tipo;
	}

	@Override
	public int compare(Producto p1, Producto p2) {
		if (p1.tipo == this.tipo && p2.tipo == this.tipo) {
			if (p1.tienePromocion() && p2.tienePromocion()) {
				return comparar(p1, p2);
			} else {
				return compararPorBool(p1, p2);
			}
		} else if (p1.tipo != this.tipo && p2.tipo != this.tipo) {
			if (p1.tienePromocion() && p2.tienePromocion()) {
				return comparar(p1, p2);
			} else if (!p1.tienePromocion() && !p2.tienePromocion()) {
				return comparar(p1, p2);
			} else {
				return compararPorBool(p1, p2);
			}

		} else {
			if (p1.tipo == this.tipo)
				return -1;
			return 1;
		}

	}

	private int compararPorBool(Producto p1, Producto p2) {
		return -Boolean.compare(p1.tienePromocion(), p2.tienePromocion());
	}

	private int comparar(Producto p1, Producto p2) {
		if (Double.compare(p1.costo, p2.costo) == 0) {
			return -Double.compare(p1.duracion, p2.duracion);
		} else {
			return -Double.compare(p1.costo, p2.costo);
		}
	}

}
