package turismoEnLaTierraMedia;

import java.util.List;

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

    public Boolean precioCorrecto(double precio) {
        return precio <= presupuesto;
    }

    public Boolean tengoTiempo(double duracion) {
        return duracion <= tiempoDisponible;
    }
    
    public Boolean estanBienTiposAtraccion(List<TipoDeAtraccion> tiposAtraccion) {
		return tiposAtraccion.contains(preferencia);
	}


    @Override
    public String toString() {

        return "[ Nombre: " + this.nombre + ", Presupuesto: " + this.presupuesto +
                ", Tiempo disponible: " + this.tiempoDisponible + ", Preferencia: "
                + this.preferencia + ".]\n";
    }

}
