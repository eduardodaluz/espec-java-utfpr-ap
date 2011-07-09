package br.edu.utfpr.ap.sisdistr.rmi;

import java.rmi.registry.*;
import exemplormi.ExemploInterface; //para descrever a Interface (deve-se copiar para outra máquina, ou seja,
//"ExemploRMI" refere-se ao diretório e ExemploInterface refere-se ao .class
// do ExemploInterface). No Netbeans, deve-se inserir a raiz da pasta copiada
//"ExemploRMI" no item Bibliotecas....

public class ExemploRMIClient {
	public static void main(String [] args){
		try {
			Registry registry = LocateRegistry.getRegistry("10.10.3.21"); //Passa-se o servidor de nomes
			ExemploInterface stub = (ExemploInterface) registry.lookup("Exemplo");
			//Procura pelo registro Exemplo para retornar a instancia do stub remoto (ref. obj. rem.)
			//A definição da classe stub é baixada dinamicamente no cliente se o java > 1.5
			String resposta = stub.mostraTexto("11:45 em Brasolia!"); //invoca o método remoto
			System.out.println("Resposta remota: " + resposta);
		} catch (Exception e) {
			System.err.println("Client exception: " + e.toString());
		}
	}
}

