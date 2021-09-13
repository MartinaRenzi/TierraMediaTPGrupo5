package turismoEnLaTierraMedia;

import java.util.ArrayList;
import java.util.List;

public class Atraccion extends Producto {

    private int cupo;
    private int lugaresOcupados = 0;
    private TipoDeAtraccion tipo;

    public Atraccion(String nombre, double costo, double duracion, TipoDeAtraccion tipo, int cupo) {
        super(nombre, costo, duracion, tipo);
        this.cupo = cupo;
    }

    public TipoDeAtraccion getTipo() {
        return tipo;
    }
    
    public int getCantidadVisitantes(){
        return this.cupo;
    }

    @Override
    public List<TipoDeAtraccion> getListaDeTiposAtraccion() {
        List<TipoDeAtraccion> listaTipoAtraccion = new ArrayList<TipoDeAtraccion>();
        listaTipoAtraccion.add(tipo);
        return listaTipoAtraccion;
    }

    @Override
    public String toString() {
        return super.toString() + ", Cupo: " + this.cupo + ".]\n";
    }
}
