package br.edu.utfpr.ap.sisdistr.multicast;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;

public class MulticastSender {
	
	InetAddress grupo;
	MulticastSocket multicast;
	DatagramPacket pacote;
	
	public MulticastSender(MulticastSocket multicast, InetAddress grupo) {
		this.multicast = multicast;
		this.grupo = grupo;
	}
	
	public void sendMsg(String msg) {
		try {
			byte[] buffer = msg.getBytes();
			pacote = new DatagramPacket(buffer, buffer.length, grupo, multicast.getLocalPort());
			multicast.send(pacote);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
