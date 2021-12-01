package main.java.jdbc;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.DriverManager;

public class ConnectionBBDD {

	private static Connection connection;
	private static String url = "jdbc:sqlite:src/TurismoenlaTierraMedia.db";
	
	public static Connection getConnection() throws SQLException {
		if (connection == null) {
			connection = DriverManager.getConnection(url);
		}
		return connection;
	}

}
