package br.edu.utfpr.ap.sisdistr.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;
import java.util.Scanner;
import java.util.StringTokenizer;

public class UDPServer extends Thread {
	
	DatagramSocket aSocket = null;
	DatagramPacket request = null;
	DatagramPacket reply = null;
	int opcao;
	
	public void startServer() {
		try {
			aSocket = new DatagramSocket(6789);
			byte[] buffer = new byte[1000];
			while (true) {
				request = new DatagramPacket(buffer, buffer.length);
				aSocket.receive(request);
				reply = new DatagramPacket(serverType(), serverType().length, request.getAddress(), request.getPort());
				aSocket.send(reply);
				request = new DatagramPacket(buffer, buffer.length);
				aSocket.receive(request);
				byte[] response = processRequest(request);
				reply = new DatagramPacket(response, response.length, request.getAddress(), request.getPort());
				aSocket.send(reply);
			}			
		} catch (SocketException e) {
			System.out.println("Socket: " + e.getMessage());
		} catch (IOException e) {
			System.out.println("IO: " + e.getMessage());
		} finally {
			if (aSocket != null)
				aSocket.close();
		}
		
	}
	
	public byte[] processRequest(DatagramPacket request) {
		String str = new String(request.getData(), 0, request.getLength());
		switch (opcao) {
		case 1 : return inverte(str);
		case 2 : return calcula(str);
		default: return new byte[100];
		}
	}
	
	public byte[] inverte(String str) {
		return new StringBuffer().append(str.toUpperCase()).reverse().toString().getBytes();
	}
	
	public byte[] calcula(String str) {
		try {
			StringTokenizer token = new StringTokenizer(str, " ");
			Double nub1 = Double.valueOf(token.nextToken());
			String operator = token.nextToken();
			Double nub2 = Double.valueOf(token.nextToken());
			if (operator.equals("+")) {
				return String.valueOf(nub1 + nub2).getBytes();
			} else if (operator.equals("-")) {
				return String.valueOf(nub1 - nub2).getBytes();
			} else if (operator.equals("*")) {
				return String.valueOf(nub1 * nub2).getBytes();
			} else if (operator.equals("/")) {
				return String.valueOf(nub1 / nub2).getBytes();
			}
		} catch (NumberFormatException e ) {
			return new String("Expressão inválida!").getBytes();
		}
		return new String("Expressão inválida!").getBytes();
	}
	
	public byte[] serverType() {
		switch (opcao) {
			case 1 : return new String("Servidor de inversão.").getBytes();
			case 2 : return new String("Servidor de calculo.").getBytes();
			default: return new byte[100];
		}
	}
	
//	public static void main(String[] args) {
//		DatagramSocket aSocket = null;
//		try {
//			aSocket = new DatagramSocket(6789); // cria um DatagramSocket na porta 6789
//			byte[] buffer = new byte[1000]; // cria um buffer para receber mensagem até 1000 de tamanho (máx = 64K)
//			while (true) {
//				DatagramPacket request = new DatagramPacket(buffer,	buffer.length); // cria DatagramPacket
//				aSocket.receive(request); // Espera o DatagramPacket ser preenchido....
//				
//				String volta = new String(request.getData(), 0, request.getLength()) + "(volta)";
//				// Cria uma String a partir da mensagem sendo do tamanho exato dela e adiciona “(volta)”
//				byte[] m = volta.getBytes(); // Converte volta para bytes
//				DatagramPacket reply = new DatagramPacket(m, m.length, request.getAddress(), request.getPort());
//				//Cria o DatagramPacket contendo a mensagem de volta
//				System.out.println(new String(reply.getData())); //mostra a mensagem a ser enviada
//				aSocket.send(reply); //envia a mensagem para o cliente
//			}
//		} catch (SocketException e) {
//			System.out.println("Socket: " + e.getMessage());
//		} catch (IOException e) {
//			System.out.println("IO: " + e.getMessage());
//		} finally {
//			if (aSocket != null)
//				aSocket.close();
//		}
//	}
	
	@Override
	public void run() {
		System.out.println("Iniciando o servidor!");
		menu();
		startServer();
	}
	
	public void menu() {
		Scanner scan = new Scanner(System.in);
		System.out.println("Qual o tipo de servidor deseja? (1-Inversor, 2-Calculadora)");
		opcao = scan.nextInt();
		switch (opcao) {
		case 1 : break;
		case 2 : break;
		default:
			menu();
			break;
		}
	}

}