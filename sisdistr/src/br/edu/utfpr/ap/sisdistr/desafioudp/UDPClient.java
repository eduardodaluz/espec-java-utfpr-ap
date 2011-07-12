package br.edu.utfpr.ap.sisdistr.desafioudp;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Vector;

public class UDPClient {
	
	DatagramSocket aSocket = null;
	DatagramPacket request = null;
	DatagramPacket reply = null;
	InetAddress aHost = null;
	int serverPort;
	
	public void desenhar(int x, int y) {
		try {
			aSocket = new DatagramSocket();
			aHost = InetAddress.getByName("localhost"); //IP remoto
			serverPort = 6789;
			Vector<Integer> vetor = new Vector<Integer>();
			vetor.add(x);
			vetor.add(y);
			ByteArrayOutputStream bytearray = new ByteArrayOutputStream();
			ObjectOutputStream fluxobytes = new ObjectOutputStream(bytearray);
			fluxobytes.writeObject(vetor);
			byte[] b = bytearray.toByteArray();
			request = new DatagramPacket(b, b.length, aHost, serverPort);
			aSocket.send(request);
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

}
