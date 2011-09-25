package br.edu.utfpr.ap.sisdistr.rmidatabase.server;

import java.util.LinkedList;
import java.util.List;

import br.edu.utfpr.ap.sisdistr.rmidatabase.dado.Dado;

public class Servidor implements ServerInterface {
	
	private List<Dado> banco;
	
	public Servidor() {
		banco = new LinkedList<Dado>();
	}

	@Override
	public void inserir(Dado dado) {
		banco.add(dado);
	}

	@Override
	public void remover(Dado dado) {
		banco.remove(dado);
	}

	@Override
	public void alterar(Dado dado) {
		banco.set(dado.getCodigo(), dado);
	}

	@Override
	public Dado pesquisar(int codigo) {
		return banco.get(codigo);
	}

	@Override
	public int noCadastros() {
		return banco.size();
	}

}
