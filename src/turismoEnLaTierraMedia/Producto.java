package turismoEnLaTierraMedia;

public abstract class Producto {
	
	protected String nombre;
	protected double costo;
	protected double duracion;
	protected TipoDeAtraccion tipo;

	public Producto(String nombre, double costo, double duracion, TipoDeAtraccion tipo) {
		super();
		this.nombre=nombre;
		this.costo = costo;
		this.duracion = duracion;
		this.tipo = tipo;
	}
	
	@Override
	public String toString() {

		return "[ Nombre: " + this.nombre + ", Costo: " + this.costo + 
				", Duracion: " + this.duracion + ", Tipo: " + this.tipo + ".]\n";
	}
}
