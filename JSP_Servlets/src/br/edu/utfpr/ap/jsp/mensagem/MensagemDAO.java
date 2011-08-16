package br.edu.utfpr.ap.jsp.mensagem;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MensagemDAO {
    
    Connection conn;
    Statement st;
    ResultSet rs;
    
    public MensagemDAO(Connection conn) {
        this.conn = conn;
    }
    
    public List<Mensagem> getMensagens() {
        List<Mensagem> msgs = new LinkedList<Mensagem>();
        try {
            st = conn.createStatement();
            rs = st.executeQuery("select id, descricao from MENSAGENS");
            while(rs.next()) {
                Mensagem msg = new Mensagem();
                msg.setId(rs.getInt("id"));
                msg.setTexto(rs.getString("descricao"));
                msgs.add(msg);
            }
            return msgs;
        } catch (SQLException ex) {
            Logger.getLogger(MensagemDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return msgs;
    }
    
}