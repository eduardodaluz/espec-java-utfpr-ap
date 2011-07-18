package br.edu.utfpr.ap.sisdistr.multicast;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.MulticastSocket;

import javax.swing.JTextArea;

public class MulticastListener extends Thread {
	
	MulticastSocket multicast;
	DatagramPacket pacote;
	JTextArea area;
	
	public MulticastListener(MulticastSocket multicast) {
		this.multicast = multicast;
	}
	
	public MulticastListener(MulticastSocket multicast, JTextArea area) {
		this.multicast = multicast;
		this.area = area;
	}
	
	@Override
	public void run() {
		while(true) {
			try {
				byte[] buffer = new byte[1000];
				pacote = new DatagramPacket(buffer, buffer.length);
				multicast.receive(pacote);
				String msg = "Msg from " + pacote.getAddress() + " >> " + new String(pacote.getData());
				if (area != null) {
					area.append("\n" + msg);
				} else {
					System.out.println(msg);
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
