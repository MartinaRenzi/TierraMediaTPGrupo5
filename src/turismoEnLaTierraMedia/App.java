package turismoEnLaTierraMedia;

import java.io.IOException;
import java.util.List;

public class App {

	public static void main(String[] args) throws IOException {
		List<Usuario> usuarios = LeerArchivoCrearUsuariosYCrearLista.getUsuarios(
				"C:\\Users\\Usuario\\Desktop\\Martina\\Turismo en la Tierra Media\\src\\turismoEnLaTierraMedia\\usuarios.txt");
		System.out.print(usuarios);

		List<Atraccion> atracciones = LeerArchivoCrearAtraccionesYCrearLista.getAtracciones(
				"C:\\Users\\Usuario\\Desktop\\Martina\\Turismo en la Tierra Media\\src\\turismoEnLaTierraMedia\\atracciones.txt");
		System.out.println(atracciones);
	}

}
