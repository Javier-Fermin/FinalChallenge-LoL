package controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;

import exceptions.PersonalizedException;
import model.ConnectionOpenClose;
import model.Played;

public class StatableDBImplementation implements Statable {
	private Connection con;
	private PreparedStatement stmt;
	private ResultSet rs;
	private ConnectionOpenClose connection;

	@Override
	// RECORDAR CAMBIAR LUEGO A THROWS
	public Set<Played> stadistics(String nickname) throws PersonalizedException {
		connection = new ConnectionOpenClose(2);
		// TODO Auto-generated method stub
		Set<Played> stats = null;
		try {
			con = connection.openConnection();
			stmt = con.prepareStatement("SELECT * FROM Play WHERE Nickname = ?");
			stmt.setString(1, nickname);
			rs = stmt.executeQuery();
			stats = new HashSet<Played>();
			while (rs.next()) {
				Played aux = new Played();
				aux.setNickname(nickname);
				aux.setWin(rs.getBoolean("Win"));
				aux.setPosition(rs.getString("Position"));
				aux.setName(rs.getString("Name"));
				aux.setId(rs.getInt("Id"));
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
