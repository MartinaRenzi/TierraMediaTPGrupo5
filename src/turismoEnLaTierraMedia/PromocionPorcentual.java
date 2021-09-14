package turismoEnLaTierraMedia;

import java.util.LinkedList;

public class PromocionPorcentual extends Promocion {

    private double descuento;
    private double costoSinDescuento;

    public PromocionPorcentual(String nombre, TipoDeAtraccion tipo, LinkedList<Atraccion> atracciones, double descuento) {
        super(nombre, tipo, atracciones);
        this.descuento = descuento;
        this.aplicarDescuento();
    }

    private void calcularCostoSinDescuento() {
        for (Atraccion atraccion : atracciones) {
            costoSinDescuento += atraccion.costo;
        }
    }

    private void aplicarDescuento() {
        this.calcularCostoSinDescuento();
        this.costo = this.costoSinDescuento - (this.costoSinDescuento * (this.descuento / 100));
    }

}
