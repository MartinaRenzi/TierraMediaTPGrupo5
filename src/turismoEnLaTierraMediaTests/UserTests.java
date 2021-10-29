package turismoEnLaTierraMediaTests;

import static org.junit.Assert.assertEquals;

import java.sql.SQLException;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import dao.AtraccionDAO;
import dao.DAOFactory;
import dao.PromocionDAO;
import dao.UsuarioDAO;
import dao.UsuarioDAOImpl;
import turismoEnLaTierraMedia.Atraccion;
import turismoEnLaTierraMedia.Producto;
import turismoEnLaTierraMedia.TipoDeAtraccion;
import turismoEnLaTierraMedia.Usuario;

public class UserTests {

	Atraccion Moria, Lothlorien;
	Usuario Eowyn, Gandalf;
	int nuevoPresupuesto = 200;
	double nuevoTiempo = 8;
	List<Producto> productos;
	

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
//		UsuarioDAO usuarioDao = new UsuarioDAOImpl;
//		List<Usuario> listaUsuario = usuarioDao.getAll(productos);
	//
//		assertEquals("Eowyn", listaUsuario.get(0).getNombre());
		
//		for(Usuario user : listaUsuario) {
//			System.out.println(user.getNombre());
//		}
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
