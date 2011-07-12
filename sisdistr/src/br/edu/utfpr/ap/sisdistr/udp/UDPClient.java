package br.edu.utfpr.ap.sisdistr.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Scanner;

public class UDPClient extends Thread {
	
	DatagramSocket aSocket = null;
	DatagramPacket request = null;
	DatagramPacket reply = null;
	InetAddress aHost = null;
	byte[] buffer;
	int serverPort;
	
	public void agir() {
		try {
			aSocket = new DatagramSocket();
			aHost = InetAddress.getByName("localhost"); //IP remoto
			serverPort = 6789;
			buffer = new byte[1000];
			System.out.println(serverType());
			System.out.println("Envie seu comando: ");
			String comando = new Scanner(System.in).nextLine();
			byte[] b = comando.getBytes();
			request = new DatagramPacket(b, b.length, aHost, serverPort);
			aSocket.send(request);
			reply = new DatagramPacket(buffer, buffer.length);
			aSocket.receive(reply);
			comando = new String(reply.getData(), 0, reply.getLength());
			System.out.println("Result: " + comando);
		} catch (SocketException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public String serverType() throws IOException {
		request = new DatagramPacket(new byte[1], new byte[1].length, aHost, serverPort);
		aSocket.send(request);
		reply = new DatagramPacket(buffer, buffer.length); //Cria DatagramPacket
		aSocket.receive(reply);
		return new String(reply.getData(), 0, reply.getLength());
	}
	
	@Override
	public void run() {
		System.out.println("Iniciei o cliente!");
		agir();
	}

}
