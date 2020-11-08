package handlers;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class InterfaceSend extends Thread {

	private Socket socket;
	private InputStream input;
	private OutputStream output;
	
	public InterfaceSend(Socket socket) {
		this.socket = socket;
	}
	
	@Override
	public void run() {
		
	}
	
}
