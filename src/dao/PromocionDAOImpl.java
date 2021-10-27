package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.LinkedList;
import java.util.List;

import jdbc.ConnectionBBDD;
import turismoEnLaTierraMedia.Atraccion;
import turismoEnLaTierraMedia.Promocion;
import turismoEnLaTierraMedia.PromocionAXB;
import turismoEnLaTierraMedia.PromocionAbsoluta;
import turismoEnLaTierraMedia.PromocionInvalida;
import turismoEnLaTierraMedia.PromocionPorcentual;
import turismoEnLaTierraMedia.TipoDeAtraccion;

public class PromocionDAOImpl implements PromocionDAO {

	public List<Promocion> getAllPromo(List<Atraccion> atracciones) {
		try {
			String sql = "SELECT * FROM promociones";
			Connection connection = ConnectionBBDD.getConnection();

			PreparedStatement statement = connection.prepareStatement(sql);
			ResultSet resultado = statement.executeQuery();

			List<Promocion> promociones = new LinkedList<Promocion>();

			while (resultado.next()) {
				promociones.add(toPromocion(resultado, atracciones));

			}
			return promociones;
		} catch (Exception e) {
			throw new MissingDataException(e);
		}
	}

	public static Promocion toPromocion(ResultSet resultado, List<Atraccion> atracciones) throws PromocionInvalida {
		try {
		String tipoPromo = (resultado.getString(3));
			if (tipoPromo.equals("Absoluta")) {
				return crearAbsoluta(resultado, atracciones);
			} else if (tipoPromo.equals("Porcentual")) {
				return crearPorcentual(resultado, atracciones);
			} else if (tipoPromo.equals("AXB")) {
				return crearAXB(resultado, atracciones);
			} else
				throw new PromocionInvalida("Tipo de promocion invalido");
		} catch (Exception e) {
			throw new MissingDataException(e);
		}
	}

	private static LinkedList<Atraccion> atraccionesQueIncluye(String nombrePromo, List<Atraccion> atracciones) {
		try {
			String sql = "SELECT atraccion_nombre FROM atracciones_promociones WHERE promocion_nombre = '" + nombrePromo
					+ "'";
			Connection connection = ConnectionBBDD.getConnection();

			PreparedStatement statement = connection.prepareStatement(sql);
			ResultSet resultado = statement.executeQuery();

			LinkedList<Atraccion> atraccIncluidas = new LinkedList<Atraccion>();

			while (resultado.next()) {
				atraccIncluidas.add(obtenerAtraccionPorNombre(resultado.getString(1), atracciones));
			}
			return atraccIncluidas;
		} catch (Exception e) {
			throw new MissingDataException(e);
		}
	}

	private static Promocion crearAbsoluta(ResultSet resultado, List<Atraccion> atracciones) {
		try {
			int id = resultado.getInt(1);
			String nombre = resultado.getString(2);
			Double costoPaquete = (double) resultado.getInt(4);
			TipoDeAtraccion tipo = TipoDeAtraccion.valueOf(resultado.getString(5));
			LinkedList<Atraccion> atraccionesIncluidas = atraccionesQueIncluye(nombre, atracciones);
			return new PromocionAbsoluta(nombre, tipo, atraccionesIncluidas, costoPaquete, id);
		} catch (Exception e) {
			throw new MissingDataException(e);
		}
	}

	private static Promocion crearPorcentual(ResultSet resultado, List<Atraccion> atracciones) {
		try {
			int id = resultado.getInt(1);
			String nombre = resultado.getString(2);
			Double descuento = (double) resultado.getInt(4);
			TipoDeAtraccion tipo = TipoDeAtraccion.valueOf(resultado.getString(5));
			LinkedList<Atraccion> atraccionesIncluidas = atraccionesQueIncluye(nombre, atracciones);
			return new PromocionPorcentual(nombre, tipo, atraccionesIncluidas, descuento, id);
		} catch (Exception e) {
			throw new MissingDataException(e);
		}
	}

	private static Promocion crearAXB(ResultSet resultado, List<Atraccion> atracciones) {
		try {
			int id = resultado.getInt(1);
			String nombre = resultado.getString(2);
			TipoDeAtraccion tipo = TipoDeAtraccion.valueOf(resultado.getString(5));
			Atraccion atraccionBonificada = obtenerAtraccionPorNombre((resultado.getString(6)), atracciones);
			LinkedList<Atraccion> atraccionesIncluidas = atraccionesQueIncluye(nombre, atracciones);
			return new PromocionAXB(nombre, tipo, atraccionesIncluidas, atraccionBonificada, id);
		} catch (Exception e) {
			throw new MissingDataException(e);
		}
	}

	private static Atraccion obtenerAtraccionPorNombre(String nombre, List<Atraccion> atracciones) {
		for (Atraccion atraccion : atracciones) {
			if (atraccion.getNombre().equals(nombre)) {
				return atraccion;
			}
		}
		return null;
	}

	
	@Override
	public void update(Promocion promocion) {
		try {
			String sql = "UPDATE atracciones SET cupo = ? WHERE nombre = ?";
			Connection connection = ConnectionBBDD.getConnection();

			PreparedStatement statement = connection.prepareStatement(sql);
			for (Atraccion atraccion : promocion.getAtracciones()) {
				statement.setInt(1, atraccion.getCupo());
				statement.setString(2, atraccion.getNombre());
				statement.executeUpdate();
			}
			

		} catch (Exception e) {
			throw new MissingDataException(e);
		}
		
	}
	@Override
	public List<Promocion> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
