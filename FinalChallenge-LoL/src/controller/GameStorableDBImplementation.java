package controller;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.HashSet;
import java.util.Set;

import exceptions.PersonalizedException;
import model.ConnectionOpenClose;
import model.Game;

/**
 * This class is a data base implementation of GameStorable interface
 * 
 * @author javier
 * @version 1.0
 *
 */
public class GameStorableDBImplementation implements GameStorable {

	private Connection con;
	private PreparedStatement stmt;
	private ResultSet rs;
	private ConnectionOpenClose connection = new ConnectionOpenClose();

	@Override
	public int addGame(Game game) throws PersonalizedException {
		// TODO Auto-generated method stub
		int id = 0;
		try {
			// Connection is opened
			con = connection.openConnection();
			// The statement is prepared and the parameters are set
			stmt = con.prepareCall("{CALL addGame(?,?,?)}");
			stmt.setDate(2, Date.valueOf(game.getDateGame()));
			stmt.setFloat(3, game.getDuration());
			((CallableStatement) stmt).registerOutParameter(1, Types.INTEGER);
			// The statement is executed and store the value that it is
			stmt.executeUpdate();
			id = ((CallableStatement) stmt).getInt(1);
			// The connection is closed
			connection.closeConnection(stmt, con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return id;
	}

	@Override
	public Set<Game> searchGames(String nickname) throws PersonalizedException {
		// TODO Auto-generated method stub
		Set<Game> games = null;
		try {
			// Connection is opened
			con = connection.openConnection();
			// The statement is prepared and the parameters are set
			stmt = con.prepareStatement("SELECT g.* FROM Game g JOIN Play p ON g.id = p.id WHERE p.nickname = ?");
			stmt.setString(1, nickname);
			// The statement is executed and then the results are processed
			rs = stmt.executeQuery();
			games = new HashSet<Game>();
			while (rs.next()) {
				// We create and add a new Game for each entry that we get from the statement
				Game aux = new Game();
				aux.setId(rs.getInt("id"));
				aux.setDateGame(rs.getDate("DateGame").toLocalDate());
				aux.setDuration(rs.getFloat("Duration"));
				games.add(aux);
			}
			// Finally we close everything used
			rs.close();
			connection.closeConnection(stmt, con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return games;
	}

	@Override
	public void completeGame(int id, String nickname, String name, boolean win, String position)
			throws PersonalizedException {
		// TODO Auto-generated method stub
		try {
			// Connection is opened
			con = connection.openConnection();
			// The statement is prepared and the parameters are set
			stmt = con.prepareStatement("INSERT INTO Play VALUES (?,?,?,?,?)");
			stmt.setInt(1, id);
			stmt.setString(2, nickname);
			stmt.setString(3, name);
			stmt.setBoolean(4, win);
			stmt.setString(5, position);
			// The statement is executed
			stmt.executeUpdate();
			// Finally we close the connection
			connection.closeConnection(stmt, con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
