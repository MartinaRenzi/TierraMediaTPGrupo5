package turismoEnLaTierraMediaTests;

import org.junit.Before;
import org.junit.Test;

import turismoEnLaTierraMedia.Atraccion;
import turismoEnLaTierraMedia.TipoDeAtraccion;
import turismoEnLaTierraMedia.Usuario;

public class AtraccionTest {
	
	Atraccion Moria;
	Usuario Eowyn;

	@Before
	public void crear() {
		Eowyn = new Usuario("Eowyn", 10, 8, TipoDeAtraccion.AVENTURA);
		
		Moria = new Atraccion("Moria", 10, 2, TipoDeAtraccion.AVENTURA, 6);
	}
	
	@Test
	public void restarDuracionAtraccion() {
		//**//
	}
}
