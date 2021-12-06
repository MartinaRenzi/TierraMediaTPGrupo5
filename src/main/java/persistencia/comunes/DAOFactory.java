package persistencia.comunes;

import persistencia.AtraccionDAO;
import persistencia.UsuarioDAO;
import persistencia.impl.AtraccionDAOImpl;
import persistencia.impl.UsuarioDAOImpl;

public class DAOFactory {
	
	public static UsuarioDAO getUsuarioDAO() {
		return new UsuarioDAOImpl(); 
	}
	
	public static AtraccionDAO getAtraccionDAO() {
		return new AtraccionDAOImpl();
	}
	
	
	
}
