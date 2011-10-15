package adivinha.bean;

import java.io.Serializable;
import java.util.Random;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

@ManagedBean
@SessionScoped
public class AdivinhaNumeroBean implements Serializable {

    private int numero;
    private Integer numeroDigitado;
    String resposta;

    public String getResposta() {
        if((numeroDigitado != null) && (numeroDigitado.compareTo(new Integer(numero)) == 0)) {
            FacesContext context = FacesContext.getCurrentInstance();
            HttpSession session = (HttpSession) context.getExternalContext().getSession(false);
            session.invalidate();
            return "NA MOSCA!!! VOCÊ ACERTOU!!!";
        } else {
            return "ERROU! O NUMERO DIGITADO: " + numeroDigitado;
        }
    }

    public void setResposta(String resposta) {
        this.resposta = resposta;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public int getNumeroDigitado() {
        return numeroDigitado;
    }

    public void setNumeroDigitado(int numeroDigitado) {
        this.numeroDigitado = numeroDigitado;
    }
    
    public AdivinhaNumeroBean() {
        Random numeroAleatorio = new Random();
        numero = new Integer(numeroAleatorio.nextInt(10));
        numeroDigitado = new Integer(0);
        System.out.println(" ---:: Número do Duke: " + numero);
    }
}
