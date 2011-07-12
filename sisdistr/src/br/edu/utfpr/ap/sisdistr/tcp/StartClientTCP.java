package br.edu.utfpr.ap.sisdistr.tcp;

import java.io.EOFException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class StartClientTCP {
	
	Socket socket = null;
	int serverPort;
	String server;

	public static void main(String[] args) {
		System.out.println("Iniciando cliente...");
		StartClientTCP thisclass = new StartClientTCP();
		Scanner scan = new Scanner(System.in);
		while(true) {
			System.out.println("Digite o comando para enviar para o Servidor.");
			System.out.println("Comandos válidos: PEGAR HORA e PEGAR NOME");
			System.out.print("Comando: ");
			String texto = scan.nextLine();
			thisclass.startClient(texto);
		}
	}
	
	public void startClient(String texto) {
		try {
			serverPort = 22223;
			server = "localhost";
			socket = new Socket(server, serverPort);
			ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
			ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
			out.flush();
			out.writeUTF(texto);
			out.flush();
			Object data = in.readObject();
			System.out.println("Received: " + data.toString());
		} catch (UnknownHostException e) {
			System.out.println("Sock:" + e.getMessage());
		} catch (EOFException e) {
			System.out.println("EOF:" + e.getMessage());
		} catch (IOException e) {
			System.out.println("IO:" + e.getMessage());
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			if (socket != null)
				try {
					socket.close();
				} catch (IOException e) {/* close failed */
				}
		}
	}

}
