/**
* This class handles the opening and closing of a connection to a MySQL database.
* It gets the database connection info from a config.properties file.
* @author Javi and Inigo
* @version 1.0
*/
package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class ConnectionOpenClose {
	/**
	 * The ResourceBundle object that contains the database connection info.
	 */
	private ResourceBundle configFile;
	/**
	 * The url of the database.
	 */
	private String url;
	/**
	 * The user of the database.
	 */
	private String user;
	/**
	 * The password of the database.
	 */
	private String pass;

	/**
	 * Constructor of the class.
	 * 
	 * @param chooseConection An integer to choose the type of user to connect with.
	 */
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

	/**
	 * Method that opens the connection with MySQL.
	 * @return The connection with MySQL.
	 * @throws SQLException If there is an error with the connection.
	 */
	public Connection openConnection() throws SQLException {
		Connection con = null;
		try {
			con = DriverManager.getConnection(url, user, pass);
		} catch (SQLException e) {
	
			e.printStackTrace();
		}
		return con;
	}

	/**
	 * Method that closes the connection with MySQL.
	 * @param stmt The PreparedStatement object to close.
	 * @param con The Connection to close.
	 * @throws SQLException If there is an error with closing the connection.
	 */
	public void closeConnection(PreparedStatement stmt, Connection con) throws SQLException {
		if (stmt != null) {
			stmt.close();
		}
		if (con != null) {
			con.close();
		}
	}
}
