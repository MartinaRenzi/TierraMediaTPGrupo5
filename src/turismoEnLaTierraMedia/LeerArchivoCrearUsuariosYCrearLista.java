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
				try {
					usuarios.add(crearUsuario(linea));
				} catch (Exception e) {
					
					System.out.println(e.getMessage());;
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		sc.close();

		return usuarios;
	}

	public static Usuario crearUsuario(String linea) throws Exception {
		String datos[] = linea.split(",");
		String nombre = datos[0];
		Usuario usuario=null;
		try {
			usuario=new Usuario(nombre, Double.parseDouble(datos[1]), Double.parseDouble(datos[2]), TipoDeAtraccion.valueOf(datos[3]));
		} catch (Exception e) {
			throw new Exception("");
		}
		return usuario;
	}
}
