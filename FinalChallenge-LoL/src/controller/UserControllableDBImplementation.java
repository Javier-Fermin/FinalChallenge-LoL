package controller;

import java.sql.Connection;
import java.sql.Date;
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
		//Two statements. One for insert user and other for Administrator
		final String INSERTUser = "INSERT INTO User (Id, Mail, Name, BirthDate, Phone, Nationality, Password) VALUES(?,?,?,?,?,?,?)";
		final String INSERTAdmin = "INSERT INTO Administrator (StartDate, Id, Additions) VALUES( ?,?,?)";
		openConnection();
		try {
			//Prepare the first Statement
			stmt= con.prepareStatement(INSERTUser);
			
			//Establish the parameters for the first statement --> User
			stmt.setString(1, admin.getId());
			stmt.setString(2, admin.getEmail());
			stmt.setString(3, admin.getName());
			stmt.setDate(4, Date.valueOf(admin.getBirthDate()));
			stmt.setString(5, admin.getPhone());
			stmt.setString(6, admin.getNationality());
			stmt.setString(7, admin.getPassword());
			
			//Execute the first statement
			stmt.executeUpdate();
			
			//Prepare the second statement
			stmt = con.prepareStatement(INSERTAdmin);
			
			//Establish the parameters for the second statement --> Admin
			stmt.setDate(1, Date.valueOf(admin.getStartDate()));
			stmt.setString(2, admin.getId());
			stmt.setInt(3, admin.getAddtions());
			
			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		try {
			closeConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public boolean modifyPlayer(Player player) {
		//Creation of the three statements needed to make the modification
				final String UPDATEUser = "UPDATE User SET Mail = ?, Name= ?, BirthDate= ?, Phone= ?, Nationality= ?, Password= ? WHERE id= ? ";
				final String UPDATEPlayer= "UPDATE Player SET nickname = ? WHERE id= ?";
				
				//To check that the modification has been carried out correctly
				boolean correct = false;
				
				openConnection();
				try {
					//Prepare the first statement
					stmt = con.prepareStatement(UPDATEUser);
					
					//Establish the parameters for the first statement --> UPDATEUser
					stmt.setString(1, player.getEmail());
					stmt.setString(2, player.getName());
					stmt.setDate(3, Date.valueOf(player.getBirthDate()));
					stmt.setString(4, player.getPhone());
					stmt.setString(5, player.getNationality());
					stmt.setString(6, player.getPassword());
					stmt.setString(7, player.getId());
					
					//Execute the first statement and check it
					if(stmt.executeUpdate()== 1) {
						correct = true;
					}
					
					//Set the boolean to its initial value
					correct = false;
					
					//Prepare the second statement
					stmt= con.prepareStatement(UPDATEPlayer);
					
					//Establish the parameters for the second statement --> UPDATEPlayer
					stmt.setString(1, player.getNickname());
					stmt.setString(2, player.getId());
					
					//Execute the second statement and check it
					if(stmt.executeUpdate()== 1) {
						correct = true;
					}
					
				
					
				} catch (SQLException e) {
					e.printStackTrace();
				}
				try {
					closeConnection();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				return correct;
	}

}
