package br.edu.utfpr.ap.sisdistr.desafioudp;

import java.awt.Graphics;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;
import java.util.Vector;

import javax.swing.JPanel;

public class UDPServer extends Thread {

	DatagramSocket aSocket = null;
	DatagramPacket request = null;
	DatagramPacket reply = null;
	JPanel screen;
	int opcao;
	private Vector<Integer> vetorS = new Vector<Integer>();

	public UDPServer(JPanel screen) {
		this.screen = screen;
	}

	@SuppressWarnings("unchecked")
	public void startServer() {
		try {
			aSocket = new DatagramSocket(6789);
			byte[] buffer = new byte[1000];
			while (true) {
				request = new DatagramPacket(buffer, buffer.length);
				System.out.println("Aguardando request...");
				aSocket.receive(request);
				System.out.println("Request recebida.");
				ByteArrayInputStream bytearrayS = new ByteArrayInputStream(request.getData(), 0, request.getLength());
				ObjectInputStream fluxobytesS = new ObjectInputStream(bytearrayS);
				vetorS  = ((Vector<Integer>) fluxobytesS.readObject());
				System.out.println(vetorS.toString());
				Graphics grp = screen.getGraphics();
				grp.drawOval(vetorS.get(0), vetorS.get(1), 30, 20);
			}
		} catch (SocketException e) {
			System.out.println("Socket: " + e.getMessage());
		} catch (IOException e) {
			System.out.println("IO: " + e.getMessage());
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (aSocket != null)
				aSocket.close();
		}

	}

	@Override
	public void run() {
		System.out.println("Iniciando o servidor!");
		startServer();
	}

}