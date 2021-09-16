package turismoEnLaTierraMedia;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Parque {

	private static List<Usuario> usuarios;
	private static List<Producto> productos = new LinkedList<Producto>();

	public Parque() throws Exception {
		this.leerArchivos();
	}

	private void leerArchivos() throws Exception {
		usuarios = LeerArchivoCrearUsuariosYCrearLista.getUsuarios("archivos/usuarios.csv");

		List<Atraccion> atracciones = LeerArchivoCrearAtraccionesYCrearLista.getAtracciones("archivos/atracciones.csv");
		List<Promocion> promociones = LeerArchivoCrearPromocionesyCrearLista.getPromociones("archivos/promociones.csv",
				atracciones);
		productos.addAll(atracciones);

		productos.addAll(promociones);

	}

	public void ofrecerProductos() throws Exception {
		for (Usuario usuario : usuarios) {
			productos.sort(new ProductosPorPreferencia(usuario.getPreferencia()));
			System.out.println("¡Hola " + usuario.getNombre() + "! Tienes " + usuario.getPresupuesto() + " monedas, "
					+ usuario.getTiempoDisponible() + " horas disponibles y siempre prefieres "
					+ usuario.getPreferencia() + ".\n¡Reserva tus paseos!\n");

			List<Producto> itinerarioAceptado = new ArrayList<Producto>();
			char respuesta;

			for (Producto oferta : productos) {
				boolean contiene = false;
				Iterator<Producto> itr = itinerarioAceptado.iterator();
				while (!contiene && itr.hasNext()) {
					contiene = oferta.contiene(itr.next());
				}

				if ((!contiene) && usuario.getPresupuesto() >= oferta.getCosto()
						&& usuario.getTiempoDisponible() >= oferta.getDuracion() && oferta.hayCupo()) {
					Scanner aceptacionOferta = new Scanner(System.in);

					System.out.println("Ingrese S para aceptar o N para seguir viendo otras ofertas de atracciones");
					System.out.println(oferta);

					respuesta = aceptacionOferta.next().charAt(0);
					while (!(respuesta == 's') && !(respuesta == 'n')) {
						System.out.println("opcion invalida");
						respuesta = aceptacionOferta.next().charAt(0);

					}
					if (respuesta == 's') {
						itinerarioAceptado.add(oferta);
						usuario.descontarDinero(oferta);
						usuario.descontarTiempo(oferta);
						oferta.descontarCupo();
						System.out.println("Ya has reservado: " + itinerarioAceptado);

					}

				}

			}
			System.out.println(itinerarioAceptado);
			this.CrearArchivodeSalida(usuario, itinerarioAceptado);

		}

	}

	private void CrearArchivodeSalida(Usuario usuario, List<Producto> itinerario) throws IOException {

		PrintWriter salida = new PrintWriter(new FileWriter("archivos/compraDe" + usuario.getNombre() + ".txt"));
		salida.println(this.getResumenDeCompra(usuario, itinerario));
		salida.close();
	}

	private String getResumenDeCompra(Usuario usuario, List<Producto> itinerario) {
		int totalAPagar = 0;
		double tiempoAInvertir = 0;
		String productosResumidos = "";
		for (Producto producto : itinerario) {
			totalAPagar += producto.getCosto();
			tiempoAInvertir += producto.getDuracion();
			productosResumidos += (" [" + producto.getNombre() + "]");
		}
		return "Nombre: " + usuario.getNombre() + "\n" + "Ha comprado:" + productosResumidos + "\n" + "Total a pagar: "
				+ totalAPagar + " monedas \n" + "Tiempo a invertir: " + tiempoAInvertir + " horas de diversion \n";
	}

}