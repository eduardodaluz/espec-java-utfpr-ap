package br.edu.utfpr.ap.sisdistr.rmidatabase.client;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

//import exercicio_bco.RegistrosInterface;

import br.edu.utfpr.ap.sisdistr.rmidatabase.dado.Dado;
import br.edu.utfpr.ap.sisdistr.rmidatabase.server.ServerInterface;

public class Main {

	public static void main(String[] args) {
		try {
			System.setProperty("java.security.policy", "regras.policy");
			if (System.getSecurityManager() == null) {
				System.setSecurityManager(new SecurityManager());
			}
			Registry registry = LocateRegistry.getRegistry("localhost", 1099);
			ServerInterface refServidor = (ServerInterface) registry.lookup("Servidor1280619");
			//ServerInterface refServidor = (ServerInterface) refSrvNomes.Pegar("Barreto LIBERA O GLOBOESPORTE.COM AEW");
			
			Dado dado1 = new Dado(2, "Eduardo", "Rodrigues da Luz", 23);
			refServidor.inserir(dado1);
			
			Dado dado2 = new Dado(3, "Maria", "Maria", 23);
			refServidor.inserir(dado2);
			
			System.out.println("Nro. de Cadastros: " + refServidor.noCadastros());
			
			Dado tmp1 = refServidor.pesquisar(1);
			
			System.out.println(tmp1.toString());
			
			tmp1.setNome("Eduardo Teste");
			refServidor.alterar(tmp1);
			
			Dado tmp2 = refServidor.pesquisar(1);
			System.out.println(tmp2);
			
//			String resposta = ref_servidor.mostraTexto("Olá Servidor remoto!");
//			System.out.println("Resposta remota: " + resposta);
		} catch (Exception e) {
			System.err.println("Client exception: " + e.toString());
		}
	}

}
