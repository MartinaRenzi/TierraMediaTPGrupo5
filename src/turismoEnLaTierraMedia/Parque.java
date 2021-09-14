package turismoEnLaTierraMedia;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Parque {

	private static List<Usuario> usuarios = new LinkedList<Usuario>();
	private static List<Producto> productos = new LinkedList<Producto>();

	public  void ofrecerProductos() throws Exception {
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


		for (Usuario usuario : usuarios) {
			productos.sort(new ProductosPorPreferencia(usuario.getPreferencia()));
			System.out.println(usuario);

			for (Producto oferta : productos) {
				Scanner aceptacionOferta = new Scanner(System.in);
				System.out.println("ingrese S para aceptar y N para seguir viendo nuestras Atracciones");
				System.out.println(oferta);
				String respuesta = aceptacionOferta.next();

			}

		}

	}

}
