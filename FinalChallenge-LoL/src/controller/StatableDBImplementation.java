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
import model.TopPlayers;

public class StatableDBImplementation implements Statable {
	private Connection con;
	private PreparedStatement stmt;
	private ResultSet rs;
	private ConnectionOpenClose connection;

	// This method gets all the Played info related to a Player by using its Nickname
	@Override
	public Set<Played> stadistics(String nickname) throws PersonalizedException {
		try {
			connection = new ConnectionOpenClose(2);
			// TODO Auto-generated method stub
			Set<Played> stats = null;
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
			return stats;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new PersonalizedException(e.getMessage());
		}
	}
	// This method gets the  top 5 players with the highest winrate
	public Set<TopPlayers> topPlayers() throws PersonalizedException {
		try {
			connection = new ConnectionOpenClose(2);
			// TODO Auto-generated method stub
			Set<TopPlayers> stats = null;
			con = connection.openConnection();
			stmt = con.prepareStatement("SELECT Nickname, COUNT(*) AS Total, SUM(Win) AS Wins, SUM(Win)/COUNT(*) AS Winrate, (SELECT Name FROM Play WHERE Nickname = p.Nickname GROUP BY Name ORDER BY COUNT(*) DESC LIMIT 1) AS 'Fav Champ', (SELECT Position FROM Play WHERE Nickname = p.Nickname GROUP BY Position ORDER BY COUNT(*) DESC LIMIT 1) AS 'Fav Position' FROM Play p GROUP BY Nickname ORDER BY Winrate DESC LIMIT 5");
			rs = stmt.executeQuery();
			stats = new HashSet<TopPlayers>();
			while (rs.next()) {
				TopPlayers player = new TopPlayers();
				player.setNickname(rs.getString("Nickname"));
				player.setTotalPlays(rs.getInt("Total"));
				player.setWins(rs.getInt("Wins"));
				player.setWinRate(rs.getFloat("Winrate"));
				player.setName(rs.getString("Fav Champ"));
				player.setPosition(rs.getString("Fav Position"));
				stats.add(player);
			}
			rs.close();

			connection.closeConnection(stmt, con);
			return stats;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new PersonalizedException(e.getMessage());
		}
	}
}
