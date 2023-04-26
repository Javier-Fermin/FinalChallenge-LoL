package controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.ArrayList;
import java.util.List;

import exceptions.PersonalizedException;
import model.Champ;
import model.ConnectionOpenClose;

public class ChampEditableDBImplementation implements ChampEditable {

	private Connection	con;
	private	PreparedStatement	stmt;
	private ConnectionOpenClose connection = new ConnectionOpenClose();
	private ResultSet	rs;

	// //	Metodo que nos permite conectarnos a la base de datos
	// private void openConnection() {
	// 	try {
	// 		// URL of the connection
	// 		String url = "jdbc:mysql://localhost:3306/LoL?serverTimezone=Europe/Madrid&useSSL=false";
	// 		con = DriverManager.getConnection(url, "root", "abcd*1234");

	// 	} catch (SQLException e) {
	// 		// Include exception
	// 	}
	// }

	//	Metodo que nos permite desconectarnos de la base de datos
	// private void closeConnection() throws SQLException {
	// 	if (stmt != null)
	// 		stmt.close();
	// 	if (con != null)
	// 		con.close();
	// 	if (rs != null)
	// 		rs.close();
	// }


	@Override
	public boolean addChamp(Champ champ) throws PersonalizedException{

		boolean added = false;
		int i = 0;

		// SQL query
		final String INSERTchamp = "INSERT INTO Champ (Name, Position, Region, Passive, Q, W, E, R) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
		
		try {
			con = connection.openConnection();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}

		try {
			//	Prepare the query
			stmt = con.prepareStatement(INSERTchamp);

			stmt.setString(1, champ.getName());
			stmt.setString(2, champ.getPosition());
			stmt.setString(3, champ.getRegion());
			stmt.setString(4, champ.getPassive());
			stmt.setString(5, champ.getQ());
			stmt.setString(6, champ.getW());
			stmt.setString(7, champ.getE());
			stmt.setString(8, champ.getR());

			//	Execute the query
			i = stmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		try {
			connection.closeConnection(stmt, con);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if (i == 1) 
			added = true;
		return added;
	}

	@Override
	public boolean modifyChamp(Champ champ) throws PersonalizedException{
		// SQL query
		final String UPDATEchamp = "UPDATE Champ SET Name = ?, Position = ?, Region = ?, Passive = ?, Q = ?, W = ?, E = ?, R = ? WHERE Name = ?";
		
		boolean modified = false;

		try {
			con = connection.openConnection();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}

		try {
			//	Prepare the query
			stmt = con.prepareStatement(UPDATEchamp);

			stmt.setString(1, champ.getName());
			stmt.setString(2, champ.getPosition());
			stmt.setString(3, champ.getRegion());
			stmt.setString(4, champ.getPassive());
			stmt.setString(5, champ.getQ());
			stmt.setString(6, champ.getW());
			stmt.setString(7, champ.getE());
			stmt.setString(8, champ.getR());
			//	We use the name of the champ to find it as it is the primary key
			stmt.setString(9, champ.getName());

			//	Execute the query
			if (stmt.executeUpdate() > 0)
				modified = true;

		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			try {
				connection.closeConnection(stmt, con);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return modified;
	}

	@Override
	public List<Champ> listChamp() throws PersonalizedException{
		Champ champ;
		ArrayList<Champ> list = new ArrayList<Champ>();
		// SQL query
		final String SELECTchamp = "SELECT * FROM Champ";

		try {
			con = connection.openConnection();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}

		try {
			//	Prepare the query
			stmt = con.prepareStatement(SELECTchamp);

			//	Execute the query
			rs = stmt.executeQuery();

			while (rs.next()) {
				champ = new Champ();
				champ.setName(rs.getString("Name"));
				champ.setPosition(rs.getString("Position"));
				champ.setRegion(rs.getString("Region"));
				champ.setPassive(rs.getString("Passive"));
				champ.setQ(rs.getString("Q"));
				champ.setW(rs.getString("W"));
				champ.setE(rs.getString("E"));
				champ.setR(rs.getString("R"));

				//	We add the champ to the list
				list.add(champ);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		try {
				connection.closeConnection(stmt, con);
		} catch (SQLException e) {
				e.printStackTrace();
		}
		return list;
	}

	@Override
	public List<Champ> listChamp(String filterPosition, String filterRegion) throws PersonalizedException{
		Champ champ;
		ArrayList<Champ> listFiltered = new ArrayList<Champ>();
		// SQL query
		String SELECTchampFiltered = "SELECT * FROM Champ";

		try {
			con = connection.openConnection();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}

		try {
			//	Prepare the query
			if (filterPosition != null)
				SELECTchampFiltered += " WHERE Position = '" + filterPosition + "'";
			if (filterRegion != null) {
				if (filterPosition != null) {
					SELECTchampFiltered += " AND Region = '" + filterRegion + "'";
				} else {
					SELECTchampFiltered += " WHERE Region = '" + filterRegion + "'";
				}
			}
			stmt = con.prepareStatement(SELECTchampFiltered);

			rs = stmt.executeQuery();

			while (rs.next()) {
				champ = new Champ();
				champ.setName(rs.getString("Name"));
				champ.setPosition(rs.getString("Position"));
				champ.setRegion(rs.getString("Region"));
				champ.setPassive(rs.getString("Passive"));
				champ.setQ(rs.getString("Q"));
				champ.setW(rs.getString("W"));
				champ.setE(rs.getString("E"));
				champ.setR(rs.getString("R"));

				//	We add the champ to the list
				listFiltered.add(champ);
			}				
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		try {
				connection.closeConnection(stmt, con);
		} catch (SQLException e) {
				e.printStackTrace();
		}
		return listFiltered;
	}

	@Override
	public Champ checkChampName(String name) throws PersonalizedException{
		Champ champ = new Champ();

		// SQL query
		final String SELECTChampName = "SELECT * FROM  CHAMP WHERE NAME = '" + name + "'";
	
		try {
			con = connection.openConnection();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
	
		try {
			//	Prepare the query
			stmt = con.prepareStatement(SELECTChampName);

			//	Execute the query
			rs = stmt.executeQuery();

			if (rs.next()) {
				champ.setName(rs.getString("Name"));
				champ.setPosition(rs.getString("Position"));
				champ.setRegion(rs.getString("Region"));
				champ.setPassive(rs.getString("Passive"));
				champ.setQ(rs.getString("Q"));
				champ.setW(rs.getString("W"));
				champ.setE(rs.getString("E"));
				champ.setR(rs.getString("R"));
			}
	
		} catch (SQLException e) {
			e.printStackTrace();
		}
	
		try {
			connection.closeConnection(stmt, con);
		} catch (SQLException e) {
			e.printStackTrace();
		}
			
		return champ;
	}
}
