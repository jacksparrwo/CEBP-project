package handlers;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class ServerRunner {
	
	private static ServerRunner serverRunnerInstance = null;
	private static ConcurrentMap<Integer, ClientHandler> clientMapList = new ConcurrentHashMap<Integer, ClientHandler>();
	
	private ServerRunner() {
		// not getting here boy
	}
	
	public void Run() {
		try {
			ServerSocket serverSocket = new ServerSocket(5000);
			
			// server started and waiting for connections
			while(true) {
				Socket socket = serverSocket.accept();
				System.out.println("New connection received: " + socket.getLocalAddress() + ":" + socket.getLocalPort());
				
				// keep track of connections
				ClientHandler client = new ClientHandler(socket);
				clientMapList.put(socket.hashCode(), client);
				
				// start the client handler (thread)
				client.start();
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static ServerRunner GetInstance() {
		if(null == serverRunnerInstance) {
			serverRunnerInstance = new ServerRunner();
		}
		
		return serverRunnerInstance;
	}
}
