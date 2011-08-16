package br.edu.utfpr.ap.jsp.tests;

import br.edu.utfpr.ap.jsp.connection.ConnectionFactory;
import br.edu.utfpr.ap.jsp.mensagem.Mensagem;
import br.edu.utfpr.ap.jsp.mensagem.MensagemDAO;

public class TestMensagem {
    
    public static void main(String args[]) {
        MensagemDAO dao = new MensagemDAO(ConnectionFactory.getConnection());
        for (Mensagem msg : dao.getMensagens()) {
            System.out.println(msg.toString());
        }
    }
    
}
