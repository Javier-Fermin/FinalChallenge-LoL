package controller;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Administrator;
import model.ConnectionOpenClose;
import model.Player;
import model.User;

public class UserControllableDBImplementationCambio implements UserControllable {
	/**
	 * @author Irati Garzón
	 * @author Alex Salinero
	 * @version 4 - 20/04/2023
	 */
	private Connection con;
	private PreparedStatement stmt;
	private ConnectionOpenClose conection = new ConnectionOpenClose();

	@Override
	/**
	 * Method use to check if the information related to the logIn is correct
	 * @param usr
	 * @param passwd
	 * @return correct
	 */
	public boolean logIn(String usr, String passwd) {
		User user = null;
		boolean correct = false;
		ResultSet rs = null;
		// Query to search which id has a player knowing his nickname
		final String SELECT = "Select id FROM player where nickname= ?";
		// Query to search the password linked to the id
		final String SELECTId = "Select Password FROM user where id=?";

		// Open connection
		try {
			con = conection.openConnection();
		} catch (SQLException e1) {
			// 
			e1.printStackTrace();
		}

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
				// If the rs is null, we set as id the usr received
			} else {
				stmt.setString(1, usr);
			}

			rs = stmt.executeQuery();

			// Create a user just with the Password. If the id doesn't exists it will create
			// a null user
			if (rs.next()) {
				user = new User();
				user.setPassword(rs.getString("Password"));
			}

			// First, we check if it isn't null and then, compare if the password is the
			// same
			if (user != null) {
				if (user.getPassword().equals(passwd)) {
					correct = true;
				} else {
					correct = false;
				}
			} else {
				correct = false;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//Close ResultSet

		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException ex) {
			}
		}
		try {
			conection.closeConnection(stmt, con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return correct;
	}

	@Override
	public boolean delete(User user) {
		// To check that the modification has been carried out correctly
		boolean correct = false;
		// Sentence to delete user.
		final String DELETEusr = "delete from user where id=?";

		// Open connection with DB.
		try {
			con = conection.openConnection();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		try {
			// Prepare query, set the id as parameter.
			stmt = con.prepareStatement(DELETEusr);
			stmt.setString(1, user.getId());

			// Execute query
			if (stmt.executeUpdate() != 0) {
				correct = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		//Close the connection

		try {
			conection.closeConnection(stmt, con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return correct;
	}

	@Override
	public User findUser(String usr) {
		User user = null;
		ResultSet rs = null;
		// Sentence to get the player with the received nickname for player table.
		final String SELECTplayer = "Select * FROM player where nickname=?";
		// Sentence to get the user info with the obtained id.
		final String SELECTuser = "Select * FROM user where id=?";
		// Sentence to get the administrator info with the obtained id.
		final String SELECTadmin = "Select * FROM Administrator where id=?";

		// Open connection with DB.
				try {
					con= conection.openConnection();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
		try {
			// Prepare the first query, set the received usr String as parameter.
			stmt = con.prepareStatement(SELECTplayer);
			stmt.setString(1, usr);
			// Execute query.
			rs = stmt.executeQuery();
			// Prepare second query for table user.
			stmt = con.prepareStatement(SELECTuser);

			if (rs.next()) {
				// If a player was received from first query, create new user a Player and get
				// rest of information.
				user = new Player();
				((Player) user).setNickname(rs.getString("nickname"));
				// Set player id as parameter for next query.
				stmt.setString(1, rs.getString("id"));
			} else {
				// If no player was received the user is Administrator type.
				user = new Administrator();
				// Set the original usr String as parameter again.
				stmt.setString(1, usr);
			}

			// Execute second query on user table.
			rs = stmt.executeQuery();

			if (rs.next()) {
				// Get all the user information from DB and set to user.
				user.setId(rs.getString("Id"));
				user.setEmail(rs.getString("Mail"));
				user.setName(rs.getString("Name"));
				user.setBirthDate(rs.getDate("BirthDate").toLocalDate());
				user.setPhone(rs.getString("Phone"));
				user.setNationality(rs.getString("Nationality"));
				user.setPassword(rs.getString("Password"));
				if (user instanceof Administrator) {
					// If user is administrator, prepare for third query.
					stmt = con.prepareStatement(SELECTadmin);
					stmt.setString(1, usr);
					// Execute third query.
					rs = stmt.executeQuery();
					if (rs.next()) {
						((Administrator) user).setStartDate(rs.getDate("StartDate").toLocalDate());
						((Administrator) user).setAddtions(rs.getInt("Additions"));
					}
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException ex) {
			}
		}
		
		//Close the connection

				try {
					conection.closeConnection(stmt, con);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
		// Return the user with the info from the DB.
		// null means there was no user in DB with received usr String.
		return user;
	}
	@Override
	public void addUser(User user) {
		ResultSet rs = null;
		String id = null;
		//Find how many administrators are to generate the id
		final String COUNTAdministrator = "SELECT COUNT(*) FROM Administrator";
		//Find how many players are to generate the id
		final String COUNTPlayer = "SELECT COUNT(*) FROM Player";
		// First query to insert the user
		final String INSERTuser = "INSERT INTO user (Id, Mail, Name, BirthDate, Phone, Nationality, Password) VALUES (?, ?, ?, ?, ?, ?, ?)";
		// Second query to insert the information just related to player or admin
		final String INSERTplayer = "INSERT INTO player (Nickname, Id) VALUES (?, ?)";
		final String INSERTAdmin = "INSERT INTO Administrator (StartDate, Id, Additions) VALUES( ?,?,?)";
		
		// Open connection with DB.
		try {
			con= conection.openConnection();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		try {
			//Check the instance to establish the id code
			if(user instanceof Player) {
				stmt= con.prepareStatement(COUNTPlayer);
				rs= stmt.executeQuery();
				if(rs.next()) {
				 id= "P" + rs.getInt(1);
				}
				
			}else {
				stmt= con.prepareStatement(COUNTAdministrator);
				rs= stmt.executeQuery();
				if(rs.next()) {
					 id= "A" + rs.getInt(1);
					}
				
			}
			
			//Close the ResultSet
			
			if(rs!= null) {
				try {
					rs.close();
				} catch (SQLException ex) {
				}
			}
			
			// Prepare sentence for query adding all the items to the stmt.
			stmt = con.prepareStatement(INSERTuser);

			stmt.setString(1, id);
			stmt.setString(2, user.getEmail());
			stmt.setString(3, user.getName());
			stmt.setDate(4, Date.valueOf(user.getBirthDate()));
			stmt.setString(5, user.getPhone());
			stmt.setString(6, user.getNationality());
			stmt.setString(7, user.getPassword());

			// Execute query.
			stmt.executeUpdate();
			
			//Check the instance to make the second insert
			if(user instanceof Player) {
				stmt = con.prepareStatement(INSERTplayer);
				stmt.setString(1, ((Player) user).getNickname());
				stmt.setString(2, id);
			}else {
				stmt = con.prepareStatement(INSERTAdmin);
				stmt.setDate(1, Date.valueOf(((Administrator) user).getStartDate()));
				stmt.setString(2, id);
				stmt.setInt(3, ((Administrator) user).getAddtions());
			}

			// Execute second query.
			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		try {
			conection.closeConnection(stmt, con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public boolean modifyPlayer(User user) {
		// Creation of the three statements needed to make the modification
		final String UPDATEUser = "UPDATE User SET Mail = ?, Name= ?, BirthDate= ?, Phone= ?, Nationality= ?, Password= ? WHERE id= ? ";
		final String UPDATEPlayer = "UPDATE Player SET nickname = ? WHERE id= ?";

		// To check that the modification has been carried out correctly
		boolean correct1 = false, correct2 = false;

		// Open connection with DB.
				try {
					con= conection.openConnection();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
		try {
			// Prepare the first statement
			stmt = con.prepareStatement(UPDATEUser);

			// Establish the parameters for the first statement --> UPDATEUser
			stmt.setString(1, user.getEmail());
			stmt.setString(2, user.getName());
			stmt.setDate(3, Date.valueOf(user.getBirthDate()));
			stmt.setString(4, user.getPhone());
			stmt.setString(5, user.getNationality());
			stmt.setString(6, user.getPassword());
			stmt.setString(7, user.getId());

			// Execute the first statement and check it
			if (stmt.executeUpdate() != 0) {
				correct1 = true;
			}

			// Prepare the second statement
			stmt = con.prepareStatement(UPDATEPlayer);

			// Establish the parameters for the second statement --> UPDATEPlayer
			stmt.setString(1, ((Player) user).getNickname());
			stmt.setString(2, user.getId());

			// Execute the second statement and check it
			if (stmt.executeUpdate() != 0 && correct1 == true) {
				correct2 = true;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		//Close the connection

				try {
					conection.closeConnection(stmt, con);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		return correct2;
	}

}