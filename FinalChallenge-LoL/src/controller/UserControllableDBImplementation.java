package controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Administrator;
import model.Player;
import model.User;

public class UserControllableDBImplementation implements UserControllable {
	private Connection con;
	private PreparedStatement stmt;
	private ResultSet rs;

	private void openConnection() {
		try {
			// URL of the connection
			String url = "jdbc:mysql://localhost:3306/LoL?serverTimezone=Europe/Madrid&useSSL=false";
			con = DriverManager.getConnection(url, "root", "abcd*1234");

		} catch (SQLException e) {
			// Include exception
		}
	}

	private void closeConnection() throws SQLException {
		if (stmt != null)
			stmt.close();
		if (con != null)
			con.close();
		if (rs != null)
			rs.close();
	}

	@Override
	public boolean logIn(String usr, String passwd) {
		User user = null;
		boolean correct = false;
		// Query to search which id has a player knowing his nickname
		final String SELECT = "Select id FROM player where nickname= ?";
		// Query to search the password linked to the id
		final String SELECTId = "Select Password FROM user where id=?";

		// Open connection
		openConnection();

		try {
			// Prepare the query
			stmt = con.prepareStatement(SELECT);
			// Establish the nickname for the query
			stmt.setString(1, usr);
			// Execute the query
			rs = stmt.executeQuery();
			// Prepare the second query
			stmt = con.prepareStatement(SELECTId);

			// For a player we establish the id based in the rs result
			if (rs.next()) {
				stmt.setString(1, rs.getString("id"));
				// For an administrator the id will be the same as it hasn't got nickname
			} else {
				stmt.setString(1, usr);
			}

			rs = stmt.executeQuery();

			// Create a user just with the Password
			if (rs.next()) {
				user = new User();
				user.setPassword(rs.getString("Password"));
			}

			// Compare if the password is the same
			if (user.getPassword().equals(passwd)) {
				correct = true;
			} else {
				correct = false;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			closeConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return correct;
	}

	@Override
	public boolean delete(User user) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public User findUser(String usr) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addPlayer(Player player) {
		// TODO Auto-generated method stub

	}

	@Override
	public void addAdmin(Administrator admin) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean modifyPlayer(Player player) {
		// TODO Auto-generated method stub
		return false;
	}

}
