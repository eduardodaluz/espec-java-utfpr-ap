package br.edu.utfpr.ap.sisdistr.rmidatabase.server;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

//import exercicio_bco.RegistrosInterface;

public class Main {

	public static void main(String[] args) {
		try {
			System.out.println("Iniciando Servidor RMI.");
			System.setProperty("java.security.policy", "regras.policy");
			if (System.getSecurityManager() == null) {
				System.setSecurityManager(new SecurityManager());
			}
			Servidor obj = new Servidor(); // Cria o objeto servidor2 RMI;
			ServerInterface stub = (ServerInterface) UnicastRemoteObject.exportObject(obj, 0);
			java.rmi.registry.LocateRegistry.createRegistry(1099);
			Registry registry = LocateRegistry.getRegistry("localhost", 1099);
			//RegistrosInterface refSrvNomes = (RegistrosInterface) registry.lookup("nomes");
			//refSrvNomes.Registrar("GambiarraServer", stub); // registra apenas o Servidor2 no servidor de nomes;
			registry.bind("Servidor1280619", stub);
			System.out.println("Servidor 1280619 RMI online");
		} catch (Exception e) {
			System.err.println("Server exception: " + e.toString());
			e.printStackTrace();
		}

	}

}
