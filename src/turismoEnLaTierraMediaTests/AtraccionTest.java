package turismoEnLaTierraMediaTests;

import static org.junit.Assert.assertEquals;

import java.util.LinkedList;

import org.junit.Before;
import org.junit.Test;

import turismoEnLaTierraMedia.Atraccion;
import turismoEnLaTierraMedia.PromocionPorcentual;
import turismoEnLaTierraMedia.TipoDeAtraccion;
import turismoEnLaTierraMedia.Usuario;

public class AtraccionTest {
	
	LinkedList<Atraccion> listaAtraccion;
	Atraccion Erebor;
	Usuario Gandalf;
	PromocionPorcentual promo;

	@Before
	public void crear() {
		Gandalf = new Usuario("Gandalf", 100, 5, TipoDeAtraccion.PAISAJE);
		
		Erebor = new Atraccion("Erebor", 12, 3, TipoDeAtraccion.PAISAJE, 32);

		listaAtraccion = new LinkedList<Atraccion>();
		listaAtraccion.add(Erebor);
		
		promo = new PromocionPorcentual("Promo", TipoDeAtraccion.PAISAJE, listaAtraccion, 20);

	}
	
	@Test
	public void espacioDisponible() {
		Boolean cupoEsperado = true;
		assertEquals(cupoEsperado, promo.hayCupo());
	}

}