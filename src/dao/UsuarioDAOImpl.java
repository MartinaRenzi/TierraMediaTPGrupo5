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
	public List<Usuario> getAll() {
		try {
			String sql = "SELECT * FROM usuarios";
			Connection connection = ConnectionBBDD.getConnection();

			PreparedStatement statement = connection.prepareStatement(sql);
			ResultSet resultado = statement.executeQuery();

			LinkedList<Usuario> usuarios = new LinkedList<Usuario>();

			while (resultado.next()) {
				usuarios.add(toUsuario(resultado));
			}

			return usuarios;
		} catch (Exception e) {
			throw new MissingDataException(e);
		}
	}

	private Usuario toUsuario(ResultSet resultado) {
		try {
			return new Usuario(resultado.getString(2), resultado.getInt(3), resultado.getInt(4),
					TipoDeAtraccion.valueOf(resultado.getString(5)), resultado.getInt(1));
		} catch (SQLException e) {
			throw new MissingDataException(e);
		}
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
}
