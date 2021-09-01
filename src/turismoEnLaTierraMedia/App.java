package turismoEnLaTierraMedia;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class App {
	
	private static List<Usuario> usuarios = new LinkedList<Usuario>();
	private static List<Producto> productos = new LinkedList<Producto>();

	public static void main(String[] args) throws IOException {
		usuarios = LeerArchivoCrearUsuariosYCrearLista.getUsuarios(
				"C:\\Users\\Usuario\\Desktop\\Martina\\Turismo en la Tierra Media\\src\\turismoEnLaTierraMedia\\usuarios.txt");
		System.out.print(usuarios);
		
		
		List<Atraccion> atracciones = LeerArchivoCrearAtraccionesYCrearLista.getAtracciones("C:\\Users\\Usuario\\Desktop\\Martina\\Turismo en la Tierra Media\\src\\turismoEnLaTierraMedia\\atracciones.txt");
		System.out.println(atracciones);//esto es sólo una prueba
	}

}
