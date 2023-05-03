package controller;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Set;

import exceptions.PersonalizedException;

import java.util.HashSet;

import model.Administrator;
import model.ConnectionOpenClose;
import model.Player;
import model.User;

public class UserControllableDBImplementation implements UserControllable {
	private Connection con;
	private PreparedStatement stmt;
	private ConnectionOpenClose connection;

	@Override
	public boolean logIn(String usr, String passwd) throws PersonalizedException {
		try {
			connection = new ConnectionOpenClose(1);
			User user = null;
			boolean correct = false;
			ResultSet rs = null;
			// Query to search which id has a player knowing his nickname
			final String SELECT = "Select id FROM player where nickname= ?";
			// Query to search the password linked to the id
			final String SELECTId = "Select Password FROM user where id=?";

			// Open connection

			con = connection.openConnection();
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

			// Close ResultSet

			if (rs != null) {
				rs.close();
			}
			connection.closeConnection(stmt, con);

			return correct;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new PersonalizedException(e.getMessage());
		}
	}

	@Override
	public boolean delete(User user, int chooseConnection) throws PersonalizedException {
		try {
			connection = new ConnectionOpenClose(chooseConnection);
			// To check that the modification has been carried out correctly
			boolean correct = false;
			// Sentence to delete user.
			final String DELETEusr = "delete from user where id=?";

			// Open connection with DB.

			con = connection.openConnection();
			// Prepare query, set the id as parameter.
			stmt = con.prepareStatement(DELETEusr);
			stmt.setString(1, user.getId());

			// Execute query
			if (stmt.executeUpdate() != 0) {
				correct = true;
			}
			// Close the connection
			connection.closeConnection(stmt, con);
			return correct;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new PersonalizedException(e.getMessage());
		}
	}

	@Override
	public User findUser(String usr, int chooseConnection) throws PersonalizedException {
		try {
			connection = new ConnectionOpenClose(chooseConnection);
			User user = null;
			ResultSet rs = null;
			// Sentence to get the player with the received nickname for player table.
			final String SELECTplayer = "Select * FROM player where nickname=?";
			// Sentence to get the user info with the obtained id.
			final String SELECTuser = "Select * FROM user where id=?";
			// Sentence to get the administrator info with the obtained id.
			final String SELECTadmin = "Select * FROM Administrator where id=?";

			// Open connection with DB.
			con = connection.openConnection();

			// Prepare the first query, set the received usr String as parameter.
			stmt = con.prepareStatement(SELECTplayer);
			stmt.setString(1, usr);
			// Execute query.
			rs = stmt.executeQuery();
			// Prepare second query for table user.

			if (rs.next()) {
				// If a player was received from first query, create new user a Player and get
				// rest of information.
				user = new Player();
				((Player) user).setNickname(rs.getString("nickname"));

				// Set player id as parameter for next query.
				// stmt.setString(1, rs.getString("id"));
			} else {
				stmt = con.prepareStatement(SELECTadmin);
				stmt.setString(1, usr);
				// Execute third query.
				rs = stmt.executeQuery();
				if (rs.next()) {
					// If no player was received the user is Administrator type.
					user = new Administrator();
					// Set the original usr String as parameter again.
					stmt.setString(1, usr);
					((Administrator) user).setStartDate(rs.getDate("StartDate").toLocalDate());
					((Administrator) user).setAddtions(rs.getInt("Additions"));

				}

			}

			// If the user isn't null we execute the query
			if (user != null) {
				user.setId(rs.getString("id"));
				stmt = con.prepareStatement(SELECTuser);
				stmt.setString(1, user.getId());
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

				}
			}
			if (rs != null) {
				rs.close();
			}

			// Close the connection

			connection.closeConnection(stmt, con);

			// Return the user with the info from the DB.
			// null means there was no user in DB with received usr String.
			return user;
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			throw new PersonalizedException(e1.getMessage());
		}
	}

	@Override
	public void addUser(User user, int chooseConnection) throws PersonalizedException {
		try {
			connection = new ConnectionOpenClose(chooseConnection);
			final String CALLUser = "CALL insertUser(?,?,?,?,?,?,?,?)";

			// Open connection with DB.

			con = connection.openConnection();

			// Prepare sentence for query adding all the items to the stmt.
			stmt = con.prepareStatement(CALLUser);
			if (user instanceof Player) {
				stmt.setString(1, "P");
				stmt.setString(8, ((Player) user).getNickname());

			} else {
				stmt.setString(1, "A");
				stmt.setString(8, null);

			}

			stmt.setString(2, user.getEmail());
			stmt.setString(3, user.getName());
			stmt.setDate(4, Date.valueOf(user.getBirthDate()));
			stmt.setString(5, user.getPhone());
			stmt.setString(6, user.getNationality());
			stmt.setString(7, user.getPassword());

			// Execute query.
			stmt.executeUpdate();
			connection.closeConnection(stmt, con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new PersonalizedException(e.getMessage());
		}
	}

	@Override
	public boolean modifyUser(User user) throws PersonalizedException {
		try {
			connection = new ConnectionOpenClose(2);
			// Creation of the three statements needed to make the modification
			final String UPDATEUser = "UPDATE User SET Mail = ?, Name= ?, BirthDate= ?, Phone= ?, Nationality= ?, Password= ? WHERE id= ? ";
			final String UPDATEPlayer = "UPDATE Player SET nickname = ? WHERE id= ?";
			final String UPDATEAdmin = "UPDATE Administrator SET additions = ? WHERE id=? ";
			// To check that the modification has been carried out correctly
			boolean correct1 = false, correct2 = false;

			// Open connection with DB.

			con = connection.openConnection();

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

			if (user instanceof Player) {
				// Prepare the second statement
				stmt = con.prepareStatement(UPDATEPlayer);

				// Establish the parameters for the second statement --> UPDATEPlayer
				stmt.setString(1, ((Player) user).getNickname());
				stmt.setString(2, user.getId());
			} else {
				stmt = con.prepareStatement(UPDATEAdmin);

				stmt.setInt(1, ((Administrator) user).getAddtions());
				stmt.setString(2, user.getId());
			}

			// Execute the second statement and check it
			if (stmt.executeUpdate() != 0 && correct1 == true) {
				correct2 = true;
			}

			// Close the connection

			connection.closeConnection(stmt, con);

			return correct2;
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			throw new PersonalizedException(e1.getMessage());
		}
	}

	@Override
	public Set<User> listPlayers() throws PersonalizedException {
		try {
			connection = new ConnectionOpenClose(0);
			ResultSet rs = null;
			User usr = null;
			Set<User> users = new HashSet<User>();
			String SELECTplayer = "select u.Id, Mail, Name, BirthDate, Phone, Nationality, Password, nickname from user u, player p where u.id = p.id; ";

			// Open connection with DB.

			con = connection.openConnection();

			stmt = con.prepareStatement(SELECTplayer);

			rs = stmt.executeQuery();

			while (rs.next()) {
				usr = new Player();
				usr.setId(rs.getString("Id"));
				usr.setEmail(rs.getString("Mail"));
				usr.setName(rs.getString("Name"));
				usr.setBirthDate(rs.getDate("BirthDate").toLocalDate());
				usr.setPhone(rs.getString("Phone"));
				usr.setNationality(rs.getString("Nationality"));
				usr.setPassword(rs.getString("Password"));
				((Player) usr).setNickname(rs.getString("Nickname"));
				users.add(usr);
			}

			connection.closeConnection(stmt, con);

			if (rs != null) {
				rs.close();
			}
			return users;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new PersonalizedException(e.getMessage());
		}
	}
}