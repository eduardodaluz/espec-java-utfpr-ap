package br.edu.utfpr.ap.sisdistr.pajehttpserver;

import java.io.IOException;

public class Main {
	
	public static void main(String args[]) {
		try {
			HttpServer server = new HttpServer(7896);
			server.start();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
