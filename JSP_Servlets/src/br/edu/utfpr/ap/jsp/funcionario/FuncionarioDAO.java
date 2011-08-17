package br.edu.utfpr.ap.jsp.funcionario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author eduardo
 */
public class FuncionarioDAO {
    
    Connection conn;
    PreparedStatement st;
    ResultSet rs;
    
    public FuncionarioDAO(Connection conn) {
        this.conn = conn;
    }
    
    public List<Funcionario> pesquisa(Funcionario func) {
        try {
            List<Funcionario> lista = new LinkedList<Funcionario>();
            String sql = "select ID, NOME, ENDERECO, TELEFONE from FUNCIONARIO where NOME starting with ?";
            st = conn.prepareStatement(sql);
            st.setString(1, func.getNome());
            rs = st.executeQuery();
            while(rs.next()) {
                Funcionario funcionario = new Funcionario(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4));
                lista.add(funcionario);
            }
            return lista;
        } catch (SQLException ex) {
            Logger.getLogger(FuncionarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}