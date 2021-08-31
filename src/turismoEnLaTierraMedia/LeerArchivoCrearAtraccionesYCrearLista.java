package turismoEnLaTierraMedia;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Scanner;

public class LeerArchivoCrearAtraccionesYCrearLista {

	public static LinkedList<Atraccion> getAtracciones(String archivo) {
		LinkedList<Atraccion> atracciones = new LinkedList<Atraccion>();
		Scanner sc = null;

		try {
			sc = new Scanner(new File(archivo));

			while (sc.hasNext()) {
				// lee cada linea del archivo
				String linea = sc.nextLine();
				String datos[] = linea.split(",");// el formato del archivo será con separación por coma
				// crea una Atraccion según datos
				String nombre = datos[0];
				double costo = Double.parseDouble(datos[1]);
				double duracion = Double.parseDouble(datos[2]);
				TipoDeAtraccion tipo = TipoDeAtraccion.valueOf(datos[4]);
				int cupo = Integer.parseInt(datos[3]);
				// agrega Atraccion a la lista
				Atraccion a = new Atraccion(nombre, costo, duracion, tipo, cupo);
				atracciones.add(a);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		sc.close();

		return atracciones;
	}
}
