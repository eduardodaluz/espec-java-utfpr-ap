package br.edu.utfpr.ap.sisdistr.multicast;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;

public class MulticastSender {
	
	MulticastSocket multicast;
	DatagramPacket pacote;
	
	public MulticastSender(MulticastSocket multicast) {
		this.multicast = multicast;
	}
	
	public void sendMsg(String msg) {
		try {
			byte[] buffer = msg.getBytes();
			pacote = new DatagramPacket(buffer, buffer.length, InetAddress.getByName("229.50.50.50"), multicast.getLocalPort());
			multicast.send(pacote);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
