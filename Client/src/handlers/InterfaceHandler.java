package handlers;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class InterfaceHandler {
	
	private static InterfaceHandler iHandler = null;
	private Socket socket;
	private InputStream input;
	private OutputStream output;
	private boolean exitStatus = false;
	private boolean receiveStatus = false;
	private boolean sendStatus = false;
	
	private InterfaceHandler() {
		try {
			this.socket = new Socket("localhost", 5000);
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static InterfaceHandler GetInstance() {
		if(null == iHandler) {
			iHandler = new InterfaceHandler();
		}
		
		return iHandler;
	}
	
	public void Run() {
		while(false == exitStatus) {
			DoReceive();
			DoSend();
		}
	}
	
	private void DoReceive() {
		if(true == receiveStatus) {
			new InterfaceReceive(socket).start();
			receiveStatus = false;
		}
	}
	
	private void DoSend() {
		if(true == sendStatus) {
			new InterfaceSend(socket).start();
			sendStatus = false;
		}
	}
	
	public void SetReceive() {
		receiveStatus = true;
	}
	
	public void SetSend() {
		sendStatus = true;
	}
	
	public void SetExit() {
		exitStatus = true;
	}
	
}
