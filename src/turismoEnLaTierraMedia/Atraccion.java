package turismoEnLaTierraMedia;

public class Atraccion extends Producto {

	private int cupo;
	private int lugaresOcupados = 0;

	public Atraccion(String nombre, double costo, double duracion, TipoDeAtraccion tipo, int cupo) {
		super(nombre, costo, duracion, tipo);
		this.cupo = cupo;

	}
	


@Override
public String toString() {
	return super.toString() + ", Cupo: "+ this.cupo + ".]\n";
}
}
