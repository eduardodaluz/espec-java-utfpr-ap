package br.edu.utfpr.ap.sisdistr.rmidatabase.dado;

import java.io.Serializable;

public class Dado implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 8971335855306359439L;
	private int codigo;
	private String nome;
	private String sobrenome;
	private int idade;
	
	public Dado(int codigo, String nome, String sobrenome, int idade) {
		this.codigo = codigo;
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.idade = idade;
	}
	
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getSobrenome() {
		return sobrenome;
	}
	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}
	public int getIdade() {
		return idade;
	}
	public void setIdade(int idade) {
		this.idade = idade;
	}
	@Override
	public String toString() {
		return "Dado [codigo=" + codigo + ", nome=" + nome + ", sobrenome="	+ sobrenome + ", idade=" + idade + "]";
	}

}
