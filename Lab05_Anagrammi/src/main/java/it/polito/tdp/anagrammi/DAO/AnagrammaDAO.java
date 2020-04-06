package it.polito.tdp.anagrammi.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;



public class AnagrammaDAO {
	
	
	public List<String> getTutteLeParole() {

		final String sql = "SELECT * FROM parola";

		List<String> parole = new LinkedList<String>();

		try {
			Connection conn = ConnectDB.getConnection();
			PreparedStatement st = conn.prepareStatement(sql);

			ResultSet rs = st.executeQuery();

			while (rs.next()) {

				int cod = rs.getInt("id");
				String nome = rs.getString("nome");
				

				//serve solo per il test questa stampa
				//System.out.println(cod + " " + nome + " " );
				// Aggiungi il nuovo oggetto Corso alla lista corsi
				parole.add(nome);
			}

			conn.close();
			
			return parole;
			

		} catch (SQLException e) {
			// e.printStackTrace();
			throw new RuntimeException("Errore Db", e);
		}
	}
	

}
