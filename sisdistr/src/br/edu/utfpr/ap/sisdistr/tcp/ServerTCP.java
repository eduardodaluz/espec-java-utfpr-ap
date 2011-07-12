package br.edu.utfpr.ap.sisdistr.tcp;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Date;

public class ServerTCP extends Thread {
	
	Socket socket;
	ObjectOutputStream out;
	ObjectInputStream in;
	StringBuffer buffer;
	
	public ServerTCP(Socket client) {
		this.socket = client;
		buffer = new StringBuffer();
		buffer.append("LOG: ").append(client.getInetAddress()).append(":").append(client.getPort()).append(" - CONNECT!");
		System.out.println(buffer);
		try {
			out = new ObjectOutputStream(socket.getOutputStream());
			out.flush();
			in = new ObjectInputStream(socket.getInputStream());
		} catch (IOException ioe) {
			try {
				client.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	@Override
	public void run() {
		System.out.println("Iniciando thread...");
		try {
			String request = in.readUTF();
			buffer = new StringBuffer();
			buffer.append("LOG: ");
			buffer.append(socket.getInetAddress());
			buffer.append(":");
			buffer.append(socket.getPort());
			buffer.append(" - REQUEST: ");
			buffer.append(request);
			Object obj = processRequest(request);
			buffer.append(" - RESPONSE: ");
			buffer.append(obj.toString());
			out.writeObject(obj);
			out.flush();
			System.out.println(buffer);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public Object processRequest(String request) {
		if(request.equals("PEGAR HORA")) {
			return new Date();
		} else if (request.equals("PEGAR NOME")) {
			return System.getProperty("user.name");
		} else {
			return new String("REQUISIÇÃO INVÁLIDA.");
		}
	}

}
