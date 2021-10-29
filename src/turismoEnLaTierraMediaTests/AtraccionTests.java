package turismoEnLaTierraMediaTests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.sql.SQLException;
import java.util.LinkedList;

import org.junit.Before;
import org.junit.Test;

import dao.AtraccionDAOImpl;
import turismoEnLaTierraMedia.Atraccion;
import turismoEnLaTierraMedia.PromocionPorcentual;
import turismoEnLaTierraMedia.TipoDeAtraccion;
import turismoEnLaTierraMedia.Usuario;

public class AtraccionTests {
	
	LinkedList<Atraccion> listaAtraccion;
	Atraccion Erebor;
	Usuario Gandalf;
	PromocionPorcentual promo;

	@Before
	public void crear() {
		Gandalf = new Usuario("Gandalf", 100, 5, TipoDeAtraccion.PAISAJE, 1);
		
		Erebor = new Atraccion("Erebor", 12, 3, TipoDeAtraccion.PAISAJE, 32, 5);

		listaAtraccion = new LinkedList<Atraccion>();
		listaAtraccion.add(Erebor);
		
		promo = new PromocionPorcentual("Promo", TipoDeAtraccion.PAISAJE, listaAtraccion, 20, 2);

	}
	
	@Test
	public void espacioDisponible() {
		Boolean cupoEsperado = true;
		assertEquals(cupoEsperado, promo.hayCupo());
	}
	
	@Test
	public void getAtracciones() {
		AtraccionDAOImpl atraccion = new AtraccionDAOImpl();
		assertTrue(atraccion.getAll().size() == 8);
	}
	
	@Test
	public void atraccionesNotNull() {
		AtraccionDAOImpl atraccion = new AtraccionDAOImpl();
		assertNotNull(atraccion.getAll());
	}
	
	
}