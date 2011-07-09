package br.edu.utfpr.ap.sisdistr.rmidatabase.server;

import java.rmi.Remote;
import java.rmi.RemoteException;

import br.edu.utfpr.ap.sisdistr.rmidatabase.dado.Dado;

public interface ServerInterface extends Remote {
	
	public void inserir(Dado dado) throws RemoteException;
	public void remover(Dado dado) throws RemoteException;
	public void alterar(Dado dado) throws RemoteException;
	public Dado pesquisar(int codigo) throws RemoteException;
	public int noCadastros() throws RemoteException;
	
}
