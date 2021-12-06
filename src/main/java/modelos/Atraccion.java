package modelos;

public class Atraccion extends Producto {

	private int cupo;
	private int id;

	public Atraccion(String nombre, double costo, double duracion, TipoDeAtraccion tipo, int cupo, int id) {
		super(nombre, costo, duracion, tipo);
		this.cupo = cupo;
		this.id = id;
	}

	public boolean hayCupo() {
		return (this.getCupo() > 0);
	}
	
	public int getCupo() {
		return cupo;
	}

	public void descontarCupo() {
		if (this.cupo <= 0) {
			System.out.println("no hay cupos disponibles");
		} else {
			this.cupo -= 1;
		}
	}

	public int getId() {
		return id;
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
