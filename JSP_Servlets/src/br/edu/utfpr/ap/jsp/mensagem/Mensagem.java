package br.edu.utfpr.ap.jsp.mensagem;

public class Mensagem {
    
    int id;
    String texto;

    public int getId() {
        return id;
    }

    public String getTexto() {
        return texto;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    @Override
    public String toString() {
        return "Msg: " + id + " - " + texto;
    }
    
}
