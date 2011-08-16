package br.edu.utfpr.ap.jsp.usuario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UsuarioDAO {
	
	Connection conn;
	PreparedStatement ps;
	ResultSet rs;
	
	public UsuarioDAO(Connection conn) {
		this.conn = conn;
	}
	
	public boolean validaLogin(String login, String senha) {
		try {
			ps = conn.prepareStatement("select 1 from USUARIOS where login = ? and senha = ?");
			ps.setString(1, login);
			ps.setString(2, senha);
			rs = ps.executeQuery();
			return rs.next();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

}
