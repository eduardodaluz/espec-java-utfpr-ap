package exerciciospring;

public class Opcionais {
    
    private String nome;
    private double valor;

    public Opcionais(String nome, double valor) {
	this.nome = nome;
	this.valor = valor;
    }

    public Opcionais() {
    }

    public String getNome() {
	return nome;
    }

    public void setNome(String nome) {
	this.nome = nome;
    }

    public double getValor() {
	return valor;
    }

    public void setValor(double valor) {
	this.valor = valor;
    }

    @Override
    public String toString() {
	return "Opcionais{" + "nome=" + nome + ", valor=" + valor + '}';
    }
    
}
