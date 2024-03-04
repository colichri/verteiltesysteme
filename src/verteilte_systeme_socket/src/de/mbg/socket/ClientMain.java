package de.mbg.socket;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class ClientMain {

	public void start() throws UnknownHostException, IOException {
		// Zu uebertragende Nachricht...
		String msg = "Dies ist ein Test von mir!";
		Socket socket = null;
		OutputStream out = null;
		try {
			// Verbinden zum Server...
			socket = new Socket("localhost", 4449);

			// Stream zum Schreiben oeffnen...
			out = socket.getOutputStream();

			// Nachricht senden...
			System.out.println("ClientMain.start: ich sende jetzt...");
			char[] msgChars = msg.toCharArray();
			for (int i = 0; i < msgChars.length; i++) {
				char charToBeSent = msgChars[i];
				System.out.println("Client sendet='" + charToBeSent + "'");
				out.write(charToBeSent);
			}
			System.out.println("ClientMain.start: fertig!");
		} finally {
			if (out != null)
				out.close();

			if (socket != null)
				socket.close();
		}
	}

	public static void main(String[] args) throws UnknownHostException,
			IOException {
		ClientMain cm = new ClientMain();
		cm.start();
	}
}
