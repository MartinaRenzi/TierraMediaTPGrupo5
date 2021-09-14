package turismoEnLaTierraMedia;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Parque {

	private static List<Usuario> usuarios;
	private static List<Producto> productos = new LinkedList<Producto>();


	public void leerArchivos() throws Exception {

	public Parque() throws Exception {
		this.crearListasDeUsuariosYDeProductos();

	}

	private void crearListasDeUsuariosYDeProductos() throws Exception {

		usuarios = LeerArchivoCrearUsuariosYCrearLista.getUsuarios("archivos/usuarios.csv");

		List<Atraccion> atracciones = LeerArchivoCrearAtraccionesYCrearLista.getAtracciones("archivos/atracciones.csv");
		List<Promocion> promociones = LeerArchivoCrearPromocionesyCrearLista.getPromociones("archivos/promociones.csv",
				atracciones);
		for (Producto atraccion : atracciones) {
			productos.add(atraccion);
		}
		for (Producto promocion : promociones) {
			productos.add(promocion);
		}

	}

	public void ofrecerProductos() throws Exception {


	public void ofrecerProductos() {
		for (Usuario usuario : usuarios) {
			productos.sort(new ProductosPorPreferencia(usuario.getPreferencia()));
			System.out.println(usuario);

			List<Producto> ofertasNegadas = new ArrayList<Producto>();
			List<Producto> itinerarioAceptado = new ArrayList<Producto>();
			char respuesta;

			for (Producto oferta : productos) {

				while ((!itinerarioAceptado.contains(oferta) && !ofertasNegadas.contains(oferta))
						&& usuario.getPresupuesto() > oferta.costo && usuario.getTiempoDisponible() > oferta.duracion) {
					Scanner aceptacionOferta = new Scanner(System.in);
					System.out.println("ingrese S para aceptar y N para seguir viendo nuestras Atracciones");
					System.out.println(oferta);
					respuesta = aceptacionOferta.next().charAt(0);
					if (respuesta == 's') {
						itinerarioAceptado.add(oferta);
						usuario.descontarDinero(oferta);
						usuario.descontarTiempo(oferta);

					} else if (respuesta == 'n') {

						ofertasNegadas.add(oferta);

					}

				}

			}
			System.out.println(itinerarioAceptado);

		}

	}
}