package main.java.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import java.sql.Connection;
import main.java.turismoEnLaTierraMedia.TipoDeAtraccion;
import main.java.jdbc.ConnectionBBDD;
import main.java.turismoEnLaTierraMedia.Atraccion;

public class AtraccionDAOImpl implements AtraccionDAO {

	@Override
	public List<Atraccion> getAll() {
		try {
			String sql = "SELECT * FROM ATRACCIONES";
			Connection connection = ConnectionBBDD.getConnection();

			PreparedStatement statement = connection.prepareStatement(sql);
			ResultSet resultado = statement.executeQuery();

			LinkedList<Atraccion> atracciones = new LinkedList<Atraccion>();

			while (resultado.next()) {
				atracciones.add(toAtraccion(resultado));
			}

			return atracciones;
		} catch (Exception e) {
			throw new MissingDataException(e);
		}
	}

	private Atraccion toAtraccion(ResultSet resultado) {
		try {
			return new Atraccion(resultado.getString(2), resultado.getInt(3), resultado.getInt(4),
					TipoDeAtraccion.valueOf(resultado.getString(5)), resultado.getInt(6), resultado.getInt(1));
		} catch (SQLException e) {
			throw new MissingDataException(e);
		}
	}

	@Override
	public void update(Atraccion atraccion) {
		try {
			String sql = "UPDATE atracciones SET cupo = ? WHERE nombre = ?";
			Connection connection = ConnectionBBDD.getConnection();

			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setInt(1, atraccion.getCupo());
			statement.setString(2, atraccion.getNombre());
			statement.executeUpdate();
			

		} catch (Exception e) {
			throw new MissingDataException(e);
		}
	}

	
}
