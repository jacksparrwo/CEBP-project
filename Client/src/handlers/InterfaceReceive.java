package handlers;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class InterfaceReceive extends Thread {

	private Socket socket;
	private InputStream input;
	private OutputStream output;
	
	public InterfaceReceive(Socket socket) {
		this.socket = socket;
	}
	
	@Override
	public void run() {
		
	}
	
}
