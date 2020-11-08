package handlers;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

import org.apache.commons.io.IOUtils;

import actors.EditorActor;
import actors.ReaderActor;
import actors.User;


class ClientHandler extends Thread {
	
	private Socket socket;
	private InputStream input;
	private OutputStream output;
	private User currentUser;
	
	public ClientHandler(Socket socket) {
		this.socket = socket;
		
		try {
			input = new BufferedInputStream(socket.getInputStream());
			output = socket.getOutputStream();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void run() {
		System.out.println("Waiting for reader/editor connection");
		
		try {
			// waiting for editor or reader
			while(true) {
				String typeOfConnection = IOUtils.toString(input, "UTF-8");
				
				if("Editor" == typeOfConnection) {
					currentUser = new EditorActor();
					break;
				} else if("Reader" == typeOfConnection) {
					currentUser = new ReaderActor();
					break;
				} else {
					// nope waiting for connection type
				}
			}
			
			while(true) {
				
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
