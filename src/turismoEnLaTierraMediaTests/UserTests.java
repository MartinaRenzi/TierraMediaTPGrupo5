package turismoEnLaTierraMediaTests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import turismoEnLaTierraMedia.Atraccion;
import turismoEnLaTierraMedia.TipoDeAtraccion;
import turismoEnLaTierraMedia.Usuario;

public class UserTests {

	Atraccion Moria;
	Usuario Eowyn;

	@Before
	public void crear() {
		Eowyn = new Usuario("Eowyn", 10, 8, TipoDeAtraccion.AVENTURA);

		Moria = new Atraccion("Moria", 10, 2, TipoDeAtraccion.AVENTURA, 6);
	}

	@Test
	public void atraccionCorrecta() {
		TipoDeAtraccion atraccionEsperada = TipoDeAtraccion.AVENTURA;
		assertEquals(atraccionEsperada, Eowyn.getPreferencia());
	}

	@Test
	public void comprarProducto() {
		int presupuestoEsp = 0;
		Eowyn.descontarDinero(Moria);
		assertEquals(presupuestoEsp, Eowyn.getPresupuesto(), 0);
	}

	@Test
	public void tiempoDisponible() {
		double tiempoDesponibleEsp = 6;
		Eowyn.descontarTiempo(Moria);
		assertEquals(tiempoDesponibleEsp, Eowyn.getTiempoDisponible(), 0);
	}

}
