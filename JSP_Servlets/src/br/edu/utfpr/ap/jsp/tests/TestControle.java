package br.edu.utfpr.ap.jsp.tests;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import br.edu.utfpr.ap.jsp.connection.ConnectionFactory;

public class TestControle {

	/**
	 * @param args
	 * @throws SQLException 
	 */
	public static void main(String[] args) throws SQLException {
		Connection conn = ConnectionFactory.getConnection("controle");
		 Statement st = conn.createStatement();
		 ResultSet rs = st.executeQuery("select * from USUARIO");
		 while(rs.next()) {
			 System.out.println("ID: " + rs.getInt(1) + ", Nome: " + rs.getString(2));
		 }
		 
	}

}
