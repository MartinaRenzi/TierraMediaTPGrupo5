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

	private static List<Usuario> usuarios = new LinkedList<Usuario>();
	private static List<Producto> productos = new LinkedList<Producto>();

	public Parque() throws Exception {
		this.leerArchivos();
	}

	private void leerArchivos() throws Exception {
		usuarios = LeerArchivoCrearUsuariosYCrearLista.getUsuarios("archivos/usuarios.csv");
		// System.out.print(usuarios);//para probarlo

		List<Atraccion> atracciones = LeerArchivoCrearAtraccionesYCrearLista.getAtracciones("archivos/atracciones.csv");
		List<Promocion> promociones = LeerArchivoCrearPromocionesyCrearLista.getPromociones("archivos/promociones.csv",
				atracciones);
		for (Producto atraccion : atracciones) {
			productos.add(atraccion);
		}
		for (Producto promocion : promociones) {
			productos.add(promocion);
		}
		// System.out.println(productos);// para probarlo

	}

	public void ofrecerProductos() throws Exception {
		for (Usuario usuario : usuarios) {
			productos.sort(new ProductosPorPreferencia(usuario.getPreferencia()));
			System.out.println(usuario);

			List<Producto> itinerarioAceptado = new ArrayList<Producto>();
			char respuesta;

			for (Producto oferta : productos) {
				boolean contiene = false;
				Iterator<Producto> itr = itinerarioAceptado.iterator();
				while (!contiene && itr.hasNext()) {
					contiene = oferta.contiene(itr.next());
				}

				if ((!contiene) && usuario.getPresupuesto() >= oferta.costo
						&& usuario.getTiempoDisponible() >= oferta.duracion && oferta.hayCupo()) {
					Scanner aceptacionOferta = new Scanner(System.in);

					System.out.println("ingrese S para aceptar y N para seguir viendo nuestras Atracciones");
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
						System.out.println(itinerarioAceptado);

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
		return "Nombre: " + usuario.getNombre() + "\n" +
		       "Ha comprado:" + productosResumidos + "\n" +
		       "Total a pagar: " + totalAPagar + " monedas \n" + 
		       "Tiempo a invertir: " + tiempoAInvertir + " horas de diversión \n";
	}

}