package it.polito.tdp.anagrammi.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;



public class ParolaDB {
	
	public boolean isCorrect(String anagramma){
		boolean returnValue=false;


		final String sql = "SELECT nome FROM parola WHERE nome=?";
		List<String> parole = new LinkedList<String>();
		try {
			Connection conn = ConnectedDB.getConnection();
			PreparedStatement st = conn.prepareStatement(sql);
			st.setString(1, anagramma);
			ResultSet rs = st.executeQuery();
			
			if (rs.next())
				returnValue = true;
			conn.close();
			
		} catch (SQLException e) {
			// e.printStackTrace();
			throw new RuntimeException("Errore Db");
		}
		return returnValue;
	}
}
