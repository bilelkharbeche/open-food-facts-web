package fr.diginamic.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

import fr.diginamic.exception.TechnicalException;

public class ConnectionMgr {

	private static ResourceBundle monFichierConf = ResourceBundle.getBundle("database");
	private static Connection conn;

	public static Connection getInstance() {

		try {
			if (conn == null || conn.isClosed()) {

				try {
					DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
				} catch (SQLException e) {
					throw new TechnicalException("La connexion ne s'est pas établie dans le main", e);
				}

				String url = monFichierConf.getString("database.url");
				String userName = monFichierConf.getString("database.user");
				String password = monFichierConf.getString("database.password");

				conn = DriverManager.getConnection(url, userName, password);
				conn.setAutoCommit(false);
			}
		} catch (SQLException e) {
			throw new TechnicalException("Impossible de se connecter à la base", e);
		}

		return conn;
	}
}
