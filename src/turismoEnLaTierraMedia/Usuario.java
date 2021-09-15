package turismoEnLaTierraMedia;

public class Usuario {
	private String nombre;
	private double presupuesto;
	private double tiempoDisponible;
	private TipoDeAtraccion preferencia;

	public Usuario(String nombre, double presupuesto, double tiempoDisponible, TipoDeAtraccion preferencia) {
		this.nombre = nombre;
		this.presupuesto = presupuesto;
		this.tiempoDisponible = tiempoDisponible;
		this.preferencia = preferencia;
	}

	public TipoDeAtraccion getPreferencia() {
		return this.preferencia;
	}

	public void descontarTiempo(Producto producto) {
		if (this.tiempoDisponible < producto.getDuracion()) {
			System.out.println("no hay tiempo suficiente");
		} else {
			this.tiempoDisponible -= producto.getDuracion();
		}

	}

	public String getNombre() {
		return nombre;
	}

	public double getPresupuesto() {
		return presupuesto;
	}

	public double getTiempoDisponible() {
		return tiempoDisponible;
	}

	public void descontarDinero(Producto producto) {
		if (this.presupuesto < producto.costo) {
			System.out.println("no hay dinero suficiente");

		} else {
			this.presupuesto -= producto.costo;

		}
	}

	@Override
	public String toString() {

		return "[ Nombre: " + this.nombre + ", Presupuesto: " + this.presupuesto + ", Tiempo disponible: "
				+ this.tiempoDisponible + ", Preferencia: " + this.preferencia + ".]\n";
	}

}