package controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;

import exceptions.PersonalizedException;
import model.Played;

public class StatableDBImplementation implements Statable {
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
	//RECORDAR CAMBIAR LUEGO A THROWS
	public Set<Played> stadistics(String nickname)  throws PersonalizedException{
		// TODO Auto-generated method stub
		Set <Played> stats = null;
		try {
			openConnection();
			stmt = con.prepareStatement("SELECT * FROM Play WHERE Nickname = ?");
			stmt.setString(1, nickname);
			rs = stmt.executeQuery();
			stats = new HashSet<Played>();
			while(rs.next()) {
				Played aux = new Played();
				aux.setWin(rs.getBoolean("Win"));
				aux.setPosition(rs.getString("Position"));
				stats.add(aux);
			}
			closeConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return stats;
	}

}
