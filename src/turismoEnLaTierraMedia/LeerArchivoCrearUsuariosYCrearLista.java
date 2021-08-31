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
				// lee cada linea del archivo
				String linea = sc.nextLine();
				String datos[] = linea.split(",");// el formato del archivo será con separación por coma
				// crea a un Usuario según datos
				String nombre = datos[0];
				double presupuesto = Double.parseDouble(datos[1]);
				double tiempoDisponible = Double.parseDouble(datos[2]);
				TipoDeAtraccion preferencia = TipoDeAtraccion.valueOf(datos[3]);
				// agrega Usuario a la lista
				Usuario u = new Usuario(nombre, presupuesto, tiempoDisponible, preferencia);
				usuarios.add(u);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		sc.close();

		return usuarios;
	}
}
