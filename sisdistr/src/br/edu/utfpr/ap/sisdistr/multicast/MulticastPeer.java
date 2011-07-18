package br.edu.utfpr.ap.sisdistr.multicast;

import java.io.IOException;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.net.UnknownHostException;

public class MulticastPeer {

	InetAddress grupo;
	MulticastSocket multicast;

	public MulticastPeer(String ip, int porta) {
			try {
				grupo = InetAddress.getByName(ip);
				multicast = new MulticastSocket(porta);
				System.out.println(multicast.getLocalPort());
			} catch (UnknownHostException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
	}

	public void joinChat() {
		try {
			multicast.joinGroup(grupo);
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void leaveChat() {
		try {
			multicast.leaveGroup(grupo);
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public MulticastSocket getSocket() {
		return multicast;
	}
	
	public InetAddress getGrupo() {
		return grupo;
	}

}
