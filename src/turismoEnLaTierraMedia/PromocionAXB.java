package turismoEnLaTierraMedia;

import java.util.LinkedList;

public class PromocionAXB extends Promocion {
    private Atraccion atraccionBonificada;

    public PromocionAXB(String nombre, TipoDeAtraccion tipo, LinkedList<Atraccion> atracciones, Atraccion atraccionBonificada) {
        super(nombre, tipo, atracciones);
        this.atraccionBonificada = atraccionBonificada;
        this.calcularCosto();
        this.duracion += atraccionBonificada.duracion;
    }

    private void calcularCosto() {
        for (Atraccion atraccion : atracciones) {
            this.costo += atraccion.costo;
        }
    }

    @Override
    public String toString() {

        return super.toString() + ", y lleva de regalo: " + this.atraccionBonificada.getNombre() + "]";
    }
}
