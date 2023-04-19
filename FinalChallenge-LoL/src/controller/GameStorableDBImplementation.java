package controller;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Game;

public class GameStorableDBImplementation implements GameStorable {

	private Connection con;
	private PreparedStatement stmt;
	private ResultSet rs;

	private void openConnection() throws SQLException {
		// String url = "jdbc:mysql://localhost/nombreBaseDatos";
		String url = "jdbc:mysql://localhost:6026/LoL?serverTimezone=Europe/Madrid&useSSL=false";
		// con = DriverManager.getConnection(url+"?" +"user=____&password=_____");
		con = DriverManager.getConnection(url, "root", "abcd*1234");
	}

	private void closeConnection() throws SQLException {
		if (stmt != null) {
		stmt.close();
		}
		if (rs != null) {
			rs.close();
		}
		if(con != null)
		con.close();
		}
	
	@Override
	public void addGame(Game game) {
		// TODO Auto-generated method stub
		try {
			openConnection();
			stmt = con.prepareStatement("INSERT INTO Game (DataGame,Duration) VALUES (?,?)");
			stmt.setDate(1,Date.valueOf(game.getDateGame()));
			stmt.setFloat(2,game.getDuration());
			stmt.executeUpdate();
			closeConnection();
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
			openConnection();
			stmt = con.prepareStatement("SELECT FROM Game WHERE id = ?");
			stmt.setInt(1,id);
			rs = stmt.executeQuery();
			while(rs.next()) {
				game=new Game();
				game.setId(rs.getInt("id"));
				game.setDateGame(rs.getDate("DateGame").toLocalDate());
				game.setDuration(rs.getFloat("Duration"));
			}
			closeConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return game;
	}

}
