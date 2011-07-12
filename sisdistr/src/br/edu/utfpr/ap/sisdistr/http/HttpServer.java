package br.edu.utfpr.ap.sisdistr.http;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class HttpServer extends Thread {
	
	int port;
	ServerSocket server;
	
	public HttpServer(int port) throws IOException {
		this.port = port;
		server = new ServerSocket(port);
		System.out.println("Servidor configurado...");
	}
	
	@Override
	public void run() {
		try {
			while (true) {
				System.out.println("Aguardando conexões...");
				Socket request = server.accept();
				HttpRequest httpRequest = new HttpRequest(request);
				httpRequest.start();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
