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

public class GameStorableDBImplementation implements GameStorable {

	private Connection con;
	private PreparedStatement stmt;
	private ResultSet rs;
	private ConnectionOpenClose connection;

	//  This method inserts a new Game into the DB
	@Override
	public int addGame(Game game) throws PersonalizedException {
		try {
			connection = new ConnectionOpenClose(2);
			// TODO Auto-generated method stub
			int id = 0;
			con = connection.openConnection();
			stmt = con.prepareCall("{CALL addGame(?,?,?)}");
			((CallableStatement) stmt).registerOutParameter(1, Types.INTEGER);
			stmt.setDate(2, Date.valueOf(game.getDateGame()));
			stmt.setFloat(3, game.getDuration());
			stmt.executeUpdate();
			id = ((CallableStatement) stmt).getInt(1);
			connection.closeConnection(stmt, con);
			return id;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new PersonalizedException(e.getMessage());
		}

	}

	// This method gets all the Games related to a Player by using its Nickname
	@Override
	public Set<Game> searchGames(String nickname) throws PersonalizedException {
		try {
			connection = new ConnectionOpenClose(2);
			// TODO Auto-generated method stub
			Set<Game> games = null;

			con = connection.openConnection();
			stmt = con.prepareStatement("SELECT g.* FROM Game g JOIN Play p ON g.id = p.id WHERE p.nickname = ?");
			stmt.setString(1, nickname);
			rs = stmt.executeQuery();
			games = new HashSet<Game>();
			while (rs.next()) {
				Game aux = new Game();
				aux.setId(rs.getInt("id"));
				aux.setDateGame(rs.getDate("DateGame").toLocalDate());
				aux.setDuration(rs.getFloat("Duration"));
				games.add(aux);
			}
			rs.close();
			connection.closeConnection(stmt, con);

			return games;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new PersonalizedException(e.getMessage());
		}
	}

	// This method inserts a new Played game into the DB
	@Override
	public void completeGame(int id, String nickname, String name, boolean win, String position)
			throws PersonalizedException {
		connection = new ConnectionOpenClose(2);
		// TODO Auto-generated method stub
		try {
			con = connection.openConnection();
			stmt = con.prepareCall("INSERT INTO Play VALUES (?,?,?,?,?)");
			stmt.setInt(1, id);
			stmt.setString(2, nickname);
			stmt.setString(3, name);
			stmt.setBoolean(4, win);
			stmt.setString(5, position);
			stmt.executeUpdate();
			connection.closeConnection(stmt, con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new PersonalizedException(e.getMessage());
		}

	}

}
