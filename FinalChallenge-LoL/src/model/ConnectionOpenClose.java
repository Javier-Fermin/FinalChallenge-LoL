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
	// Method to open connection with MySQL, gets the info from config.properties file, 
	// receives an int to choose the user to connect with
	public ConnectionOpenClose(int chooseConection) {
		configFile = ResourceBundle.getBundle("model.config");
		url = configFile.getString("URL");
		if (chooseConection == 0)
			user = configFile.getString("ADMIN");
		else if (chooseConection == 1)
			user = configFile.getString("LOGIN");
		else
			user = configFile.getString("USER");
		pass = configFile.getString("PASSWORD");
	}

	// Method that opens the connection with MySQL
	public Connection openConnection() throws SQLException {
		Connection con = null;
		try {
			con = DriverManager.getConnection(url, user, pass);
		} catch (SQLException e) {
	
			e.printStackTrace();
		}
		return con;
	}

	// Method that closes the connection with MySQL
	public void closeConnection(PreparedStatement stmt, Connection con) throws SQLException {
		if (stmt != null) {
			stmt.close();
		}
		if (con != null) {
			con.close();
		}
	}
}
