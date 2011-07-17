package br.edu.utfpr.ap.sisdistr.pajehttpserver;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class HttpServer extends Thread {
	
	int port;
	ServerSocket srvSocket;
	
	public HttpServer(int port) throws IOException {
		this.port = port;
		this.srvSocket = new ServerSocket(port);
	}
	
	@Override
	public void run() {
		try {
			log("START", "Http Server running on port: " + srvSocket.getLocalPort());
			while(true) {
				Socket socket = srvSocket.accept();
				log("CONN", " New connection accepted " + socket.getInetAddress() + ":" + socket.getPort());
				HttpRequestHandler handler = new HttpRequestHandler(socket);
				handler.start();
			}
		} catch (IOException ioe) {
			log("ERROR", ioe.getMessage());
		}
	}
	
	private void log(String type, String message) {
		System.out.println(type + " - " + message);
	}

}
