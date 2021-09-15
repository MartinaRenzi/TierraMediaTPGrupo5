package turismoEnLaTierraMedia;

public class Atraccion extends Producto {

	private int cupo;

	public Atraccion(String nombre, double costo, double duracion, TipoDeAtraccion tipo, int cupo) {
		super(nombre, costo, duracion, tipo);
		this.cupo = cupo;
	}

	public boolean hayCupo() {
		return (this.cupo > 0);
	}

	public double getDuracion() {
		return duracion;
	}

	public void descontarCupo() {
		if (this.cupo <= 0) {
			System.out.println("no hay cupos disponibles");
		} else {
			this.cupo -= 1;
		}
	}

	@Override
	public String toString() {
		return super.toString() + ", Cupo: " + this.cupo + ".]\n";
	}

	@Override
	public boolean contiene(Producto producto) {
		if (producto.esPromo()) {
			return producto.contiene(this);
		}
		return this.equals(producto);
	}

}
