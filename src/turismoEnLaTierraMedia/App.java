package turismoEnLaTierraMedia;

import java.util.LinkedList;
import java.util.List;

public class App{
	
	private static List<Usuario> usuarios = new LinkedList<Usuario>();
	private static List<Producto> productos = new LinkedList<Producto>();

	public static void main(String[] args) throws Exception {
		usuarios = LeerArchivoCrearUsuariosYCrearLista.getUsuarios(
				"archivos/usuarios.csv");
		//System.out.print(usuarios);//para probarlo
		
		
		List<Atraccion> atracciones = LeerArchivoCrearAtraccionesYCrearLista.getAtracciones("archivos/atracciones.csv");
		List<Promocion> promociones = LeerArchivoCrearPromocionesyCrearLista.getPromociones("archivos/promociones.csv", atracciones);
		for(Producto atraccion : atracciones) {
			productos.add(atraccion);
		}
		for (Producto promocion : promociones) {
			productos.add(promocion);
		}
		System.out.println(productos);//para probarlo
		}
		
	
		
	}
	
	


