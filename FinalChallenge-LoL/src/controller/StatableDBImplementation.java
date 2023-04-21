package controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;

import model.ConnectionOpenClose;
import model.Played;

public class StatableDBImplementation implements Statable {
	private Connection con;
	private PreparedStatement stmt;
	private ResultSet rs;
	private ConnectionOpenClose connection = new ConnectionOpenClose();

	@Override
	//RECORDAR CAMBIAR LUEGO A THROWS
	public Set<Played> stadistics(String nickname) {
		// TODO Auto-generated method stub
		Set <Played> stats = null;
		try {
			connection.openConnection();
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
			rs.close();
			connection.closeConnection(stmt, con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return stats;
	}

}
