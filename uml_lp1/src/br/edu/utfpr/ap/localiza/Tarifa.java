package br.edu.utfpr.ap.localiza;

public class Tarifa {

	private String descricao;
	private char tipo;
	private Double valor;

	public Tarifa(String descricao, char tipo, Double valor) {
		this.descricao = descricao;
		this.tipo = tipo;
		this.valor = valor;
	}

	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public char getTipo() {
		return tipo;
	}
	public void setTipo(char tipo) {
		this.tipo = tipo;
	}
	public Double getValor() {
		return valor;
	}
	public void setValor(Double valor) {
		this.valor = valor;
	}

	@Override
	public String toString() {
		return "TARIFA: " + this.getDescricao() + " TIPO: " + this.getTipo()
				+ " VALOR: " + this.getValor();
	}
}
