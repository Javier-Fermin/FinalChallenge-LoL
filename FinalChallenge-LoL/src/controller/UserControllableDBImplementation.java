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
		// To check that the modification has been carried out correctly
				boolean correct= false;
		// Sentence to delete user.
		final String DELETEusr = "delete from user where id=?";

		// Open connection with DB.
		openConnection();

		try {
			// Prepare query, set the id as parameter.
			stmt = con.prepareStatement(DELETEusr);
			stmt.setString(1, user.getId());

			// Execute query
			if(stmt.executeUpdate() != 0){
				correct= true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		try {
			// Close connection with DB.
			closeConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return correct;
	}

	@Override
	public User findUser(String usr) {
		User user = null;
		// Sentence to get the player with the received nickname for player table.
		final String SELECTplayer = "Select * FROM player where nickname=?";
		// Sentence to get the user info with the obtained id.
		final String SELECTuser = "Select * FROM user where id=?";
		// Sentence to get the administrator info with the obtained id.
		final String SELECTadmin = "Select * FROM Administrator where id=?";

		// Open the connection with the DB.
		openConnection();
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
		try {
			// Close connection with DB.
			closeConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		// Return the user with the info from the DB.
		// null means there was no user in DB with received usr String.
		return user;
	}

	@Override
	public void addPlayer(Player player) {
		// First query for user table.
		final String INSERTuser = "INSERT INTO user (Id, Mail, Name, BirthDate, Phone, Nationality, Password) VALUES (?, ?, ?, ?, ?, ?)";
		// Second query for player table.
		final String INSERTplayer = "INSERT INTO player (Nickname, Id) VALUES (?, ?)";
		// Open connection with DB.
		openConnection();

		try {
			// Prepare sentence for query adding all the items to the stmt.
			stmt = con.prepareStatement(INSERTuser);

			stmt.setString(1, player.getId());
			stmt.setString(2, player.getEmail());
			stmt.setString(3, player.getName());
			stmt.setDate(4, Date.valueOf(player.getBirthDate()));
			stmt.setString(5, player.getPhone());
			stmt.setString(6, player.getNationality());
			stmt.setString(7, player.getPassword());

			// Execute query.
			stmt.executeUpdate();

			// Prepare sentence for second query, with nickname and id.
			stmt = con.prepareStatement(INSERTplayer);

			stmt.setString(1, player.getNickname());
			stmt.setString(2, player.getId());

			// Eecute second query.
			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		try {
			// Close connection.
			closeConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void addAdmin(Administrator admin) {
		// Two statements. One for insert user and other for Administrator
		final String INSERTUser = "INSERT INTO User (Id, Mail, Name, BirthDate, Phone, Nationality, Password) VALUES(?,?,?,?,?,?,?)";
		final String INSERTAdmin = "INSERT INTO Administrator (StartDate, Id, Additions) VALUES( ?,?,?)";
		openConnection();
		try {
			// Prepare the first Statement
			stmt = con.prepareStatement(INSERTUser);

			// Establish the parameters for the first statement --> User
			stmt.setString(1, admin.getId());
			stmt.setString(2, admin.getEmail());
			stmt.setString(3, admin.getName());
			stmt.setDate(4, Date.valueOf(admin.getBirthDate()));
			stmt.setString(5, admin.getPhone());
			stmt.setString(6, admin.getNationality());
			stmt.setString(7, admin.getPassword());

			// Execute the first statement
			stmt.executeUpdate();

			// Prepare the second statement
			stmt = con.prepareStatement(INSERTAdmin);

			// Establish the parameters for the second statement --> Admin
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
		// Creation of the three statements needed to make the modification
		final String UPDATEUser = "UPDATE User SET Mail = ?, Name= ?, BirthDate= ?, Phone= ?, Nationality= ?, Password= ? WHERE id= ? ";
		final String UPDATEPlayer = "UPDATE Player SET nickname = ? WHERE id= ?";

		// To check that the modification has been carried out correctly
		boolean correct1= false, correct2 = false;

		openConnection();
		try {
			// Prepare the first statement
			stmt = con.prepareStatement(UPDATEUser);

			// Establish the parameters for the first statement --> UPDATEUser
			stmt.setString(1, player.getEmail());
			stmt.setString(2, player.getName());
			stmt.setDate(3, Date.valueOf(player.getBirthDate()));
			stmt.setString(4, player.getPhone());
			stmt.setString(5, player.getNationality());
			stmt.setString(6, player.getPassword());
			stmt.setString(7, player.getId());

			// Execute the first statement and check it
			if (stmt.executeUpdate() != 0) {
				correct1 = true;
			}

			// Prepare the second statement
			stmt = con.prepareStatement(UPDATEPlayer);

			// Establish the parameters for the second statement --> UPDATEPlayer
			stmt.setString(1, player.getNickname());
			stmt.setString(2, player.getId());

			// Execute the second statement and check it
			if (stmt.executeUpdate() != 0 && correct1==true) {
				correct2 = true;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			closeConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return correct2;
	}

}