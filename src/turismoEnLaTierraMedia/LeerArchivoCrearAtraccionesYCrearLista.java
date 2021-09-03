package turismoEnLaTierraMedia;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class LeerArchivoCrearAtraccionesYCrearLista {

	public static LinkedList<Atraccion> getAtracciones(String archivo) {
		LinkedList<Atraccion> atracciones = new LinkedList<Atraccion>();
		Scanner sc = null;

		try {
			sc = new Scanner(new File(archivo));

			while (sc.hasNext()) {
				String linea = sc.nextLine();
				atracciones.add(crearAtraccion(linea));
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		sc.close();
		return atracciones;
	}

	public static Atraccion crearAtraccion(String linea) {
		String datos[] = linea.split(",");
		String nombre = datos[0];
		double costo = Double.parseDouble(datos[1]);
		double duracion = Double.parseDouble(datos[2]);
		TipoDeAtraccion tipo = TipoDeAtraccion.valueOf(datos[4]);
		int cupo = Integer.parseInt(datos[3]);
		return new Atraccion(nombre, costo, duracion, tipo, cupo);
	}

}
