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

/**
 * This class is a data base implementation of Statable interface
 * 
 * @author javier
 * @version 1.0
 *
 */
public class StatableDBImplementation implements Statable {
	private Connection con;
	private PreparedStatement stmt;
	private ResultSet rs;
	private ConnectionOpenClose connection = new ConnectionOpenClose();

	@Override
	public Set<Played> stadistics(String nickname) throws PersonalizedException {
		// TODO Auto-generated method stub
		Set<Played> stats = null;
		try {
			// Connection is opened
			con = connection.openConnection();
			// The statement is prepared and the parameters are set
			stmt = con.prepareStatement("SELECT * FROM Play WHERE Nickname = ?");
			stmt.setString(1, nickname);
			// The statement is executed and then the results are processed
			rs = stmt.executeQuery();
			stats = new HashSet<Played>();
			while (rs.next()) {
				// We create and add a new Played for each entry that we get from the statement
				Played aux = new Played();
				aux.setNickname(nickname);
				aux.setWin(rs.getBoolean("Win"));
				aux.setPosition(rs.getString("Position"));
				aux.setName(rs.getString("Name"));
				aux.setId(rs.getInt("Id"));
				stats.add(aux);
			}
			// Finally we close everything used
			rs.close();
			connection.closeConnection(stmt, con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return stats;
	}

}
