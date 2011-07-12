package br.edu.utfpr.ap.sisdistr.tcp;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class StartServerTCP {
	
	public static void main(String args[]) {
		try {
			int port = 22223;
			ServerSocket server = new ServerSocket(port);
			System.out.println("Servidor pronto.");
			while(true) {
				System.out.println("Aguardando conexões...");
				Socket client = server.accept();
				ServerTCP serverTCP = new ServerTCP(client);
				serverTCP.start();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
