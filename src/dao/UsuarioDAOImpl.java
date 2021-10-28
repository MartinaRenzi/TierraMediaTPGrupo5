package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import jdbc.ConnectionBBDD;
import turismoEnLaTierraMedia.Atraccion;
import turismoEnLaTierraMedia.Producto;
import turismoEnLaTierraMedia.Promocion;
import turismoEnLaTierraMedia.TipoDeAtraccion;
import turismoEnLaTierraMedia.Usuario;

public class UsuarioDAOImpl implements UsuarioDAO {

	@Override
	public List<Usuario> getAll(List<Producto> productos) {
		try {
			String sql = "SELECT * FROM usuarios";
			Connection connection = ConnectionBBDD.getConnection();

			PreparedStatement statement = connection.prepareStatement(sql);
			ResultSet resultado = statement.executeQuery();

			LinkedList<Usuario> usuarios = new LinkedList<Usuario>();

			while (resultado.next()) {
				usuarios.add(toUsuario(resultado, productos));
			}

			return usuarios;
		} catch (Exception e) {
			throw new MissingDataException(e);
		}
	}

	private Usuario toUsuario(ResultSet resultado, List<Producto> productos) {
		try {
			Usuario usuario = new Usuario(resultado.getString(2), resultado.getInt(3), resultado.getInt(4),
					TipoDeAtraccion.valueOf(resultado.getString(5)), resultado.getInt(1));
			agregarProductosYaComprados(usuario, productos);
			return usuario;
		} catch (SQLException e) {
			throw new MissingDataException(e);
		}
	}

	private static void agregarProductosYaComprados(Usuario usuario, List<Producto> productos) {
		try {
			String sql = "SELECT atracciones.nombre\r\n"
					+ "from itinerarios\r\n"
					+ "left join usuarios on usuarios.id = itinerarios.usuario_id\r\n"
					+ "left JOIN atracciones on atracciones.id = itinerarios.atraccion_id\r\n"
					+ "WHERE itinerarios.usuario_id = " + usuario.getId() + " AND atracciones.nombre is not NULL\r\n"
					+ "UNION\r\n"
					+ "SELECT promociones.nombre\r\n"
					+ "from itinerarios\r\n"
					+ "left join usuarios on usuarios.id = itinerarios.usuario_id\r\n"
					+ "left join promociones on promociones.id = itinerarios.promocion_id\r\n"
					+ "WHERE itinerarios.usuario_id = " + usuario.getId() + " AND promociones.nombre is not NULL";
			Connection connection = ConnectionBBDD.getConnection();

			PreparedStatement statement = connection.prepareStatement(sql);
			ResultSet resultado = statement.executeQuery();

			while (resultado.next()) {
				usuario.miItinerario.add(obtenerProductoPorNombre(resultado.getString(1), productos));
				
			}

		} catch (Exception e) {
			throw new MissingDataException(e);
		}
	}

	private static Producto obtenerProductoPorNombre(String nombre, List<Producto> productos) {
		for (Producto producto : productos) {
			if (producto.getNombre().equals(nombre)) {
				return producto;
			}
		}
		return null;
	}

	@Override
	public void update(Usuario usuario) {
		try {
			String sql = "UPDATE usuarios SET presupuesto = ?, tiempo_disponible = ? WHERE nombre = ?";
			Connection connection = ConnectionBBDD.getConnection();

			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setInt(1, (int) usuario.getPresupuesto());
			statement.setInt(2, (int) usuario.getTiempoDisponible());
			statement.setString(3, usuario.getNombre());
			statement.executeUpdate();

		} catch (Exception e) {
			throw new MissingDataException(e);
		}

	}

	@Override
	public void insertarItinerario(Usuario usuario, LinkedList<Producto> productos) {
		try {
			for (Producto producto : productos) {
				if (producto.esPromo() == false) {
					Atraccion atraccion = (Atraccion) producto;
					insertarAtraccion(usuario, atraccion);

				} else if (producto.esPromo()) {
					Promocion promocion = (Promocion) producto;
					insertarPromocion(usuario, promocion);
				}
			}

		} catch (Exception e) {
			throw new MissingDataException(e);
		}

	}

	private void insertarAtraccion(Usuario usuario, Atraccion atraccion) {
		try {
			String sql = "INSERT INTO itinerarios('usuario_id', 'atraccion_id') VALUES (?, ?)";
			Connection connection = ConnectionBBDD.getConnection();

			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setInt(1, usuario.getId());
			statement.setInt(2, atraccion.getId());
			statement.executeUpdate();
		} catch (Exception e) {
			throw new MissingDataException(e);
		}

	}

	private void insertarPromocion(Usuario usuario, Promocion promocion) {
		try {
			String sql = "INSERT INTO itinerarios('usuario_id', 'promocion_id') VALUES (?, ?)";
			Connection connection = ConnectionBBDD.getConnection();

			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setInt(1, usuario.getId());
			statement.setInt(2, promocion.getId());
			statement.executeUpdate();
		} catch (Exception e) {
			throw new MissingDataException(e);
		}

	}

	@Override
	public List<Usuario> getAll() {
		// TODO Auto-generated method stub
		return null;
	}
}
