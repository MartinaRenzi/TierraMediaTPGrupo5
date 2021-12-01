package main.java.dao;
import java.util.LinkedList;
import java.util.List;

import main.java.turismoEnLaTierraMedia.Producto;
import main.java.turismoEnLaTierraMedia.Usuario;

public interface UsuarioDAO extends GenericDAO<Usuario> {

	void insertarItinerario(Usuario usuario, LinkedList<Producto> productos);

	List<Usuario> getAll(List<Producto> productos);

	
	
	
}
