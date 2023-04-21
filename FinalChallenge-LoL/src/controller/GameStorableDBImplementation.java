package controller;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.ConnectionOpenClose;
import model.Game;

public class GameStorableDBImplementation implements GameStorable {

	private Connection con;
	private PreparedStatement stmt;
	private ResultSet rs;
	private ConnectionOpenClose connection = new ConnectionOpenClose();

	@Override
	public void addGame(Game game) {
		// TODO Auto-generated method stub
		try {
			con = connection.openConnection();
			stmt = con.prepareStatement("INSERT INTO Game (DataGame,Duration) VALUES (?,?)");
			stmt.setDate(1,Date.valueOf(game.getDateGame()));
			stmt.setFloat(2,game.getDuration());
			stmt.executeUpdate();
			connection.closeConnection(stmt, con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public Game searchGame(int id) {
		// TODO Auto-generated method stub
		Game game=null;
		try {
			con = connection.openConnection();
			stmt = con.prepareStatement("SELECT FROM Game WHERE id = ?");
			stmt.setInt(1,id);
			rs = stmt.executeQuery();
			while(rs.next()) {
				game=new Game();
				game.setId(rs.getInt("id"));
				game.setDateGame(rs.getDate("DateGame").toLocalDate());
				game.setDuration(rs.getFloat("Duration"));
			}
			rs.close();
			connection.closeConnection(stmt, con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return game;
	}

}
