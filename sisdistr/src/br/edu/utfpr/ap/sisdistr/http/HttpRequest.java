package br.edu.utfpr.ap.sisdistr.http;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;
import java.util.StringTokenizer;

public class HttpRequest extends Thread {
	
	Socket request;
	OutputStream out;
	BufferedReader in;
	
	public HttpRequest(Socket request) {
		this.request = request;
	}
	
	@Override
	public void run() {
		System.out.println(request.toString());
		try {
			in = new BufferedReader(new InputStreamReader(request.getInputStream()));
			out = new BufferedOutputStream(request.getOutputStream());
			processRequest();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void processRequest() throws IOException {
			StringTokenizer command = new StringTokenizer(in.readLine());
			System.out.println(command);
	}

}
