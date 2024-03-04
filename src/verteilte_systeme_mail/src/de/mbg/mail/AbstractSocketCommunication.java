package de.mbg.mail;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public abstract class AbstractSocketCommunication {
	private String _identifier;

	private Socket _socket;

	private InputStream _in;

	private OutputStream _out;

	private String _errorMessage = "Fehler: Protokoll verletzt!";

	public AbstractSocketCommunication(Socket socket, String identifier)
			throws IOException {
		_socket = socket;
		_in = _socket.getInputStream();
		_out = _socket.getOutputStream();
		_identifier = identifier;
	}

	public String readMessage() throws IOException {
		String msg = "";
		for (int b = _in.read(); b != (int) '\n'; b = _in.read()) {
			msg = msg + (char) b;
		}

		// Hack to use telnet: Remove char(13) at end of line...
		char[] chars = msg.toCharArray();
		msg = "";
		for (char c : chars) {
			if (c != (char) 13) {
				msg = msg + c;
			}
		}
		System.out.println(_identifier + ": Nachricht empfangen : '" + msg
				+ "'");

		return msg;
	}

	public void sendMessage(String msg) throws IOException {
		msg = msg + '\n';
		char[] msgChars = msg.toCharArray();
		for (int i = 0; i < msgChars.length; i++) {
			_out.write(msgChars[i]);
		}
		_out.flush();
		System.out.println(_identifier + ": Nachricht gesendet  : " + msg);
	}

	public void sendError() throws IOException {
		sendMessage(_errorMessage);
	}

	public boolean isErrorMessage(String msg) {
		return _errorMessage.equals(msg);
	}

	public void close() {
		try {
			_in.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			_out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			_socket.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println(_identifier + ": Verbindung beendet!");

	}
}
