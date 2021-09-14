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

	@Override
	public String toString() {

		return "[ Nombre: " + this.nombre + ", Presupuesto: " + this.presupuesto + ", Tiempo disponible: "
				+ this.tiempoDisponible + ", Preferencia: " + this.preferencia + ".]\n";
	}

}
