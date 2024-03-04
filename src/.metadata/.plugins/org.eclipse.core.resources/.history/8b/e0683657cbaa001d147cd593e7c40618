package de.mbg.chat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;

public class ChatClient {

	public void start() throws UnknownHostException, IOException {
		Socket socket = null;
		try {
			// Verbinden zum Server...
			socket = new Socket("localhost", 4449);

			ChatClientThread clientThread = new ChatClientThread(socket);
			clientThread.start();

			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			System.out.println("Bitte Client Identität eingeben: ");
			String chatClientIdentity = reader.readLine();
			System.out.println("Have a lot of fun as " + chatClientIdentity);
			while (true) {
				String msg = reader.readLine();
				// Nachricht senden...
				msg = chatClientIdentity + ": " + msg + '\n';
				clientThread.sendMessage(msg);
			}
		} finally {
			if (socket != null)
				socket.close();
		}
	}

	public static void main(String[] args) throws UnknownHostException, IOException {
		ChatClient cm = new ChatClient();
		cm.start();
	}
}
