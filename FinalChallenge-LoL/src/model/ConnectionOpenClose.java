package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class ConnectionOpenClose {
	private ResourceBundle configFile;
	private String url;
	private String user;
	private String pass;

	// CONSTRUCTOR
	public ConnectionOpenClose() {
		configFile = ResourceBundle.getBundle("Config");
		url = configFile.getString("URL");
		user = configFile.getString("USER");
		pass = configFile.getString("PASSWORD");
	}

	public Connection openConnection() throws SQLException {
		Connection con = null;
		try {
			con = DriverManager.getConnection(url, user, pass);
		} catch (SQLException e) {
	
			// Gestión de la excepción
		// throw new CreateException(e.getMessage());
		}
		return con;
	}

	public void closeConnection(PreparedStatement stmt, Connection con) throws SQLException {
		if (stmt != null) {
			stmt.close();
		}
		if (con != null) {
			con.close();
		}
	}
}
