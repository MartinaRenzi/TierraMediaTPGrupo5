package turismoEnLaTierraMedia;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class LeerArchivoCrearPromocionesyCrearLista {
	public static LinkedList<Promocion> getPromociones(String archivo, List<Atraccion> atracciones) throws Exception {
		LinkedList<Promocion> promociones = new LinkedList<Promocion>();
		Scanner sc = null;

		try {
			sc = new Scanner(new File(archivo));

			while (sc.hasNext()) {
				String linea = sc.nextLine();
				promociones.add(crearPromocion(linea, atracciones));
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		sc.close();
		return promociones;
	}

	public static Promocion crearPromocion(String linea, List<Atraccion> atracciones) throws Exception {
		String datos[] = linea.split(",");
		String tipoDePromocion = datos[1];
		if (tipoDePromocion.equals("Absoluta")) {
			return crearAbsoluta(linea, atracciones);
		} else if (tipoDePromocion.equals("Porcentual")) {
			return crearPorcentual(linea, atracciones);
		} else if (tipoDePromocion.equals("AXB")) {
			return crearAXB(linea, atracciones);
		} else
			throw new Exception("Tipo de promoción inválido");

	}

	private static Promocion crearAbsoluta(String linea, List<Atraccion> atracciones) {
		String datos[] = linea.split(",");
		String nombre = datos[0];
		Double costoPaquete = Double.parseDouble(datos[2]);
		TipoDeAtraccion tipo = TipoDeAtraccion.valueOf(datos[3]);
		LinkedList<Atraccion> atraccionesIncluidas = new LinkedList<Atraccion>();
		for (int i = 4; i < datos.length; i++) {
			atraccionesIncluidas.add(obtenerAtraccionPorNombre(datos[i], atracciones));
		}
		return new Absoluta(nombre, tipo, atraccionesIncluidas, costoPaquete);
	}

	private static Promocion crearPorcentual(String linea, List<Atraccion> atracciones) {
		String datos[] = linea.split(",");
		String nombre = datos[0];
		Double descuento = Double.parseDouble(datos[2]);
		TipoDeAtraccion tipo = TipoDeAtraccion.valueOf(datos[3]);
		LinkedList<Atraccion> atraccionesIncluidas = new LinkedList<Atraccion>();
		for (int i = 4; i < datos.length; i++) {
			atraccionesIncluidas.add(obtenerAtraccionPorNombre(datos[i], atracciones));
		}
		return new Porcentual(nombre, tipo, atraccionesIncluidas, descuento);
	}

	private static Promocion crearAXB(String linea, List<Atraccion> atracciones) {
		String datos[] = linea.split(",");
		String nombre = datos[0];
		TipoDeAtraccion tipo = TipoDeAtraccion.valueOf(datos[2]);
		Atraccion atraccionBonificada = obtenerAtraccionPorNombre(datos[datos.length - 1], atracciones);
		LinkedList<Atraccion> atraccionesIncluidas = new LinkedList<Atraccion>();
		for (int i = 3; i < datos.length - 1; i++) {
			atraccionesIncluidas.add(obtenerAtraccionPorNombre(datos[i], atracciones));
		}
		return new AXB(nombre, tipo, atraccionesIncluidas, atraccionBonificada);
	}

	private static Atraccion obtenerAtraccionPorNombre(String nombre, List<Atraccion> atracciones) {
		for (Atraccion atraccion : atracciones) {
			if (atraccion.getNombre().equals(nombre)) {
				return atraccion;
			}
		}
		return null;
	}

}
