package turismoEnLaTierraMedia;

import java.util.LinkedList;

public class Absoluta extends Promocion {

    public Absoluta(String nombre, TipoDeAtraccion tipo, LinkedList<Atraccion> atracciones, double costoPaquete) {
        super(nombre, tipo, atracciones);
        this.costo = costoPaquete;

    }

    @Override
    public String toString() {
        return super.toString();
    }
}
