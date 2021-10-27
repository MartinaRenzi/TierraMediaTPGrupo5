package dao;
import java.util.LinkedList;

import turismoEnLaTierraMedia.Producto;
import turismoEnLaTierraMedia.Usuario;

public interface UsuarioDAO extends GenericDAO<Usuario> {

	void insertarItinerario(Usuario usuario, LinkedList<Producto> miItinerario);

	
	
	
}
