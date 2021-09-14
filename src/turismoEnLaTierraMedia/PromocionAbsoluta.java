package turismoEnLaTierraMedia;

import java.util.LinkedList;

public class PromocionAbsoluta extends Promocion {

    public PromocionAbsoluta(String nombre, TipoDeAtraccion tipo, LinkedList<Atraccion> atracciones, double costoPaquete) {
        super(nombre, tipo, atracciones);
        this.costo = costoPaquete;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
