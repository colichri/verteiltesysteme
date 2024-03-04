package de.mbg.socket;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerMain {
	
	public void start() throws IOException {
		ServerSocket serverSocket = null;
		Socket socket = null;
		InputStream in = null;
		try {
			// Server Socket erzeugen...
			serverSocket = new ServerSocket(4449);
			System.out.println("ServerMain.start: warte auf Client...");		
			
			// Warten auf Client...
			socket = serverSocket.accept();
			System.out.println("ServerMain.start: Client ist da :-)");
			
			// Stream fuers Lesen...
			in = socket.getInputStream();
			
			// Lesen
			for (int b = in.read(); b != -1; b = in.read()) {
				char charFromClient = (char) b;
				System.out.println("gelesen: '" + charFromClient + "'");
			}
			System.out.println("ServerMain.start: fertig.");
		} finally {
			if (in != null)
				in.close();
			if (socket != null)
				socket.close();
			if (serverSocket != null)
				serverSocket.close();
		}
	}

	public static void main(String args[]) throws IOException {
		ServerMain m = new ServerMain();
		m.start();
	}
}
