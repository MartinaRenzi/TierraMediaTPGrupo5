package turismoEnLaTierraMedia;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Scanner;

public class LeerArchivoCrearUsuariosYCrearLista {

	public static LinkedList<Usuario> getUsuarios(String archivo) {
		LinkedList<Usuario> usuarios = new LinkedList<Usuario>();
		Scanner sc = null;

		try {
			sc = new Scanner(new File(archivo));

			while (sc.hasNext()) {
				String linea = sc.nextLine();
				usuarios.add(crearUsuario(linea));
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		sc.close();

		return usuarios;
	}

	public static Usuario crearUsuario(String linea) {
		String datos[] = linea.split(",");
		String nombre = datos[0];
		double presupuesto = Double.parseDouble(datos[1]);
		double tiempoDisponible = Double.parseDouble(datos[2]);
		TipoDeAtraccion preferencia = TipoDeAtraccion.valueOf(datos[3]);
		return new Usuario(nombre, presupuesto, tiempoDisponible, preferencia);
	}
}
