package br.edu.utfpr.ap.sisdistr.pajehttpserver;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;
import java.util.StringTokenizer;

public class HttpRequestHandler extends Thread {
	
	private static String WWW_PATH = "/home/eduardo/workspace/utfpr/sisdistr/www";
	private static String WWW_ERRORPATH = "/home/eduardo/workspace/utfpr/sisdistr/www/errors";
	private static String SERVER = "Server: Pajé Http Server";
	private final static String CRLF = "\r\n";
	private InputStream in;
	private OutputStream out;
	private BufferedReader br;
	private Socket socket;
	
	public HttpRequestHandler(Socket socket) throws IOException {
		this.socket = socket;
		in = socket.getInputStream();
		out = socket.getOutputStream();
		br = new BufferedReader(new InputStreamReader(in));
	}
	
	@Override
	public void run() {
		try {
			processRequest();
		} catch (IOException e) {
			log("ERROR", e.getMessage());
		} catch (Exception e) {
			log("ERROR", e.getMessage());
		}
	}
	
	private void processRequest() throws Exception {
		while(true) {
			String headerLine = br.readLine();
			log("HEADER", headerLine);
			// Cabeçalho mau formado.
			if (headerLine.equals(CRLF) || headerLine.equals("")) {
				log("INFO", "Final de cabeçalho.");
				break;
			}
			
			StringTokenizer st = new StringTokenizer(headerLine);
			String instr = st.nextToken();
			
			if (instr.equals("GET")) {
				String fileName = st.nextToken();
				fileName = WWW_PATH + fileName;
				
				FileInputStream fis = null;
		        boolean fileExists = true;
		        try {
		          fis = new FileInputStream(fileName);
		        } catch (FileNotFoundException e) {
		        	log("ERROR", e.getMessage());
		        	fileExists = false;
		        }
		        String statusLine = null;
		        String contentTypeLine = null;
		        String contentLengthLine = null;
		        if (fileExists) {
		        	statusLine = "HTTP/1.1 200 OK" + CRLF;
		        	contentTypeLine = "Content-type: " + contentType(fileName) + CRLF;
		        	contentLengthLine = "Content-Length: " + (new Integer(fis.available())).toString() + CRLF;
		        } else {
		        	fis = new FileInputStream(WWW_ERRORPATH + "/404.html");
		        	statusLine = "HTTP/1.1 404 Not Found" + CRLF;
		        	contentTypeLine = "Content-type: text/html" + CRLF;
		        	contentLengthLine = "Content-Length: " + (new Integer(fis.available())).toString() + CRLF;
		        }
		        
		        // Enviando o status da requisição.
		        out.write(statusLine.getBytes());
		        System.out.println(statusLine);

		        // Enviando o servidor
		        out.write(SERVER.getBytes());
		        System.out.println(SERVER);

		        // Enviando o tipo de conteudo.
		        out.write(contentTypeLine.getBytes());
		        System.out.println(contentTypeLine);

		        // Enviando o tamanho do conteudo.
		        out.write(contentLengthLine.getBytes());
		        System.out.println(contentLengthLine);

		        // Final do cabeçalho, envia uma linha em branco.
		        out.write(CRLF.getBytes());
		        System.out.println(CRLF);
		        
		        // Enviando dados a página.
		        sendBytes(fis, out);
		        fis.close();
			}	
		}
		
		try {
			out.close();
			br.close();
			socket.close();
		} catch (Exception e) {
			log("ERROR", e.getMessage());
		}
	}
	
	private static String contentType(String fileName) {
		if (fileName.endsWith(".htm") || fileName.endsWith(".html") || fileName.endsWith(".txt")) {
			return "text/html";
		} else if (fileName.endsWith(".jpg") || fileName.endsWith(".jpeg")) {
			return "image/jpeg";
		} else if (fileName.endsWith(".gif")) {
	    	return "image/gif";
	    } else {
	    	return "application/octet-stream";
	    }
	}
	
	private void log(String type, String message) {
		System.out.println(type + " - " + message);
	}
	
	private static void sendBytes(FileInputStream fis, OutputStream os)	throws Exception {
		byte[] buffer = new byte[1024];
		int bytes = 0;
		while ((bytes = fis.read(buffer)) != -1) {
			os.write(buffer, 0, bytes);
		}
	}
}
