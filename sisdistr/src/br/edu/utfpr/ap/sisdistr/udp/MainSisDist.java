package br.edu.utfpr.ap.sisdistr.udp;

import java.util.Scanner;

public class MainSisDist {
	
	private UDPServer server = new UDPServer();
	private UDPClient client = new UDPClient();

	public static void main(String[] args) {
		MainSisDist main = new MainSisDist();
		main.menu();
	}
	
	public void menu() {
		Scanner scan = new Scanner(System.in);
		System.out.println("Inciar:(1-SERVER, 2-CLIENT)");
		int opcao = scan.nextInt();
		switch (opcao) {
		case 1 : server.start();			
			break;
		case 2 : client.start();
			break;
		default:
			menu();
			break;
		}
	}
	
	public UDPServer getServer() {
		return server;
	}
	
	public UDPClient getClient() {
		return client;
	}

}
