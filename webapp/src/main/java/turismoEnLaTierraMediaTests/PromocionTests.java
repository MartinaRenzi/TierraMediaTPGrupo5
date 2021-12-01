package main.java.turismoEnLaTierraMediaTests;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import main.java.dao.*;

import main.java.turismoEnLaTierraMedia.*;


public class PromocionTests {
	
	List<Atraccion> listaAtracciones;
	List<Promocion> promociones;
	
	@Before 
	public void setup() {
		PromocionDAO promocionD = new PromocionDAOImpl();
		AtraccionDAO atraccionDao = DAOFactory.getAtraccionDAO();
		listaAtracciones = atraccionDao.getAll();
		promociones = promocionD.getAllPromo(listaAtracciones);
		
		assertEquals("Pack 1 aventura", promociones.get(0).getNombre());
		assertEquals("Pack 7 degustación", promociones.get(6).getNombre());

	}
	

	@Test
	public void verTodasLasPromociones() {
		for(Producto promo: promociones)
			System.out.println(promo.getNombre());
	}

}