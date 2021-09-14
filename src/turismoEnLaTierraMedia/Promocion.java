package turismoEnLaTierraMedia;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public abstract class Promocion extends Producto {
    protected List<Atraccion> atracciones;

    public Promocion(String nombre, TipoDeAtraccion tipo, LinkedList<Atraccion> atracciones) {
        super();
        this.nombre = nombre;
        this.tipo = tipo;
        this.atracciones = atracciones;
        this.calcularDuracion();
    }

    private void calcularDuracion() {
        for (Atraccion atraccion : atracciones) {
            this.duracion += atraccion.duracion;
        }
    }

    public LinkedList<String> obtenerNombreAtraccionesDeLista() {
        LinkedList<String> atraccionesQueIncluye = new LinkedList<String>();
        for (Atraccion atraccion : atracciones) {
            atraccionesQueIncluye.add(atraccion.getNombre());
        }
        return atraccionesQueIncluye;
    }

    @Override
    public double getCosto(){
        double costoTotal = 0;
        for(Atraccion atraccion: atracciones)
            costoTotal =+ atraccion.getCosto();
        return costoTotal;
    }

    @Override
    public double getDuracion() {
        double duracionTotal = 0;
        for(Atraccion atraccion: this.atracciones)
            duracionTotal =+ atraccion.getDuracion();
        return duracionTotal;
    }
    @Override
    public List<TipoDeAtraccion> getListaDeTiposAtraccion() {
        List<TipoDeAtraccion> tiposAtracciones = new ArrayList<TipoDeAtraccion>();
        for (Atraccion atraccion : atracciones) {
            tiposAtracciones.add(atraccion.getTipo());
        }
        return tiposAtracciones;
    }
    
    @Override
    public boolean tienePromocion() {
        return true;
    }

    @Override
    public String toString() {
        return super.toString() + ", Incluye: " + obtenerNombreAtraccionesDeLista();
    }

	@Override
	public boolean esPromo() {
		return true;
	}

}
