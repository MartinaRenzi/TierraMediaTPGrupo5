package servicios;

import modelos.Usuario;
import modelos.nullobjects.NullUser;
import persistencia.UsuarioDAO;
import persistencia.comunes.DAOFactory;

public class LoginService {
	public Usuario login(String username) {
		UsuarioDAO userDao = DAOFactory.getUsuarioDAO();
		Usuario user = userDao.getNombre(username);
    	
    	if (user.isNull()) {
    		user = NullUser.build();
    	}
    	return user;
	}
}
