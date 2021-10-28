package turismoEnLaTierraMedia;

import java.util.LinkedList;

public class Usuario {
	private String nombre;
	private double presupuesto;
	private double tiempoDisponible;
	private TipoDeAtraccion preferencia;
	public LinkedList<Producto> miItinerario = new LinkedList<Producto>();
;
	private int id;


	public Usuario(String nombre, double presupuesto, double tiempoDisponible, TipoDeAtraccion preferencia, int id) {
		this.nombre = nombre;
		this.presupuesto = presupuesto;
		this.tiempoDisponible = tiempoDisponible;
		this.preferencia = preferencia;
		this.id = id;
	}

	public TipoDeAtraccion getPreferencia() {
		return this.preferencia;
	}

	public LinkedList<Producto> getMiItinerario() {
		return miItinerario;
	}
	
	public int getId() {
		return id;
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

	public void descontarTiempo(Producto producto) {
		if (this.tiempoDisponible < producto.getDuracion()) {
			System.out.println("no hay tiempo suficiente");
		} else {
			this.tiempoDisponible -= producto.getDuracion();
		}

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