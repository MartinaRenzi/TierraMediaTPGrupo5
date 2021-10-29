package turismoEnLaTierraMediaTests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.sql.SQLException;

import org.junit.Before;
import org.junit.Test;

import dao.DAOFactory;
import dao.GenericDAO;
import dao.UsuarioDAO;
import dao.UsuarioDAOImpl;

import turismoEnLaTierraMedia.Atraccion;
import turismoEnLaTierraMedia.TipoDeAtraccion;
import turismoEnLaTierraMedia.Usuario;

public class UserTests {

	Atraccion Moria, Lothlorien;
	Usuario Eowyn, Gandalf;
	int nuevoPresupuesto = 200;
	double nuevoTiempo = 8;

	@Before
	public void crear() {
		Eowyn = new Usuario("Eowyn", 10, 8, TipoDeAtraccion.AVENTURA, 1);
		
		Gandalf = new Usuario("Gandalf", nuevoPresupuesto, nuevoTiempo, TipoDeAtraccion.PAISAJE, 1);

		Moria = new Atraccion("Moria", 10, 2, TipoDeAtraccion.AVENTURA, 6, 1);
		
		Lothlorien = new Atraccion("Lothlorien", 35, 1, TipoDeAtraccion.DEGUSTACION, 26, 7);
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
	
//	@Test
//	public void getUsuarios() {
//		UsuarioDAOImpl usuario = new UsuarioDAOImpl();
//		assertTrue(usuario.getAll().size() > 1);
//	}
//	
//	@Test
//	public void usuariosNotNull() {
//	UsuarioDAOImpl usuario = new UsuarioDAOImpl();
//	assertNotNull(usuario.getAll());
//}
	
	///Recibe como parametro una lista de productos getAll
	
	@Test 
	public void actualizarPresupuestoYTiempoUsuario() throws SQLException {
		UsuarioDAOImpl usuario = new UsuarioDAOImpl();
		usuario.update(Gandalf); 
		assertEquals(nuevoPresupuesto, Gandalf.getPresupuesto(), 0);
	}

}
