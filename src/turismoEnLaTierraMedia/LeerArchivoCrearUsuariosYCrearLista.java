package turismoEnLaTierraMedia;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
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
				try {
					usuarios.add(crearUsuario(linea));
				} catch (Exception e) {

					System.out.println(e.getMessage());
					;
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();

		} catch (IOException e) {
			e.printStackTrace();

		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			try {
				if (sc != null) {
					sc.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}

		return usuarios;
	}

	public static Usuario crearUsuario(String linea) throws Exception, ArrayIndexOutOfBoundsException {
		String datos[] = linea.split(",");
		Usuario usuario = null;
		String nombre = null;
		double presupuesto = 0;
		double tiempoDisponible = 0;
		TipoDeAtraccion preferencia = null;
		if (datos.length < 4) {
			throw new ArrayIndexOutOfBoundsException("faltan par�metros");
		} else if (datos.length > 4) {
			throw new ArrayIndexOutOfBoundsException("sobran par�metros");

		}

		try {
			nombre = datos[0];
			presupuesto = Double.parseDouble(datos[1]);
			tiempoDisponible = Double.parseDouble(datos[2]);
			preferencia = TipoDeAtraccion.valueOf(datos[3].toUpperCase());

			usuario = new Usuario(nombre, presupuesto, tiempoDisponible, preferencia);

		} catch (Exception e) {
			throw new Exception("Par�metro inv�lido");

		}
		return usuario;

	}
}