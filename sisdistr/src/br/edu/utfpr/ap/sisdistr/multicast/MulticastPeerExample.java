package br.edu.utfpr.ap.sisdistr.multicast;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.net.SocketException;

public class MulticastPeerExample {
	public static void main(String args[]) {
		MulticastSocket s = null;
		try {
			InetAddress grupo = InetAddress.getByName("229.50.50.50");
			s = new MulticastSocket(7010);
			s.joinGroup(grupo);
			byte[] m = (System.getProperty("user.name") + ": E ai manolos!").getBytes();
			DatagramPacket mensagem = new DatagramPacket(m, m.length, grupo, 6789);
			s.send(mensagem);
			// envia 1 mensagem para o grupo
			byte[] buffer = new byte[1000];
			for (int i = 0; i < 3; i++) { // obtém 3 mensagens do grupo
				DatagramPacket mensagem_dogrupo = new DatagramPacket(buffer, buffer.length);
				s.receive(mensagem_dogrupo);
				System.out.println("Recebido do grupo:"	+ new String(mensagem_dogrupo.getData()));
			}
			s.leaveGroup(grupo);
		} catch (SocketException e) {
			System.out.println("Socket: " + e.getMessage());
		} catch (IOException e) {
			System.out.println("IO: " + e.getMessage());
		} finally {
			if (s != null)
				s.close();
		}
	}
}