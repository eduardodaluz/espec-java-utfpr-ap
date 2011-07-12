package br.edu.utfpr.ap.sisdistr.http;

import java.io.IOException;

public class Main {
	
	public static void main(String[] args) {
		HttpServer httpServer;
		try {
			httpServer = new HttpServer(7896);
			httpServer.start();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
