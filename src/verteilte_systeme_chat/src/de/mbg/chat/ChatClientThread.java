package de.mbg.chat;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class ChatClientThread extends Thread {
	private InputStream _in;
	private OutputStream _out;
	private Socket _socket;

	public ChatClientThread(Socket socket) throws IOException {
		// Stream zum Schreiben oeffnen...
		_socket = socket;
		_out = _socket.getOutputStream();
		_in = _socket.getInputStream();
	}

	public void run() {
		while (true) {
			try {
				String read = "";
				for (int b = _in.read(); b != (int) '\n'; b = _in.read()) {
					read = read + (char) b;
				}
				System.out.println(read);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public void sendMessage(String msg) throws IOException {
		char[] msgChars = msg.toCharArray();
		for (int i = 0; i < msgChars.length; i++) {
			_out.write(msgChars[i]);
		}
	}
}