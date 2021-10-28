package dao;
import java.util.LinkedList;
import java.util.List;

import turismoEnLaTierraMedia.Producto;
import turismoEnLaTierraMedia.Usuario;

public interface UsuarioDAO extends GenericDAO<Usuario> {

	void insertarItinerario(Usuario usuario, LinkedList<Producto> productos);

	List<Usuario> getAll(List<Producto> productos);

	
	
	
}
