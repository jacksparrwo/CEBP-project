package handlers;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.ArrayList;

import org.apache.commons.io.IOUtils;
import org.bson.Document;
import org.json.JSONObject;

import actors.EditorActor;
import actors.ReaderActor;
import actors.User;
import database.MongoHandler;
import database.MongoOperation;


class ClientHandler extends Thread {
	
	private InputStream input;
	private OutputStream output;
	private User currentUser;
	private MongoHandler myMongo = new MongoHandler();
	
	public ClientHandler(Socket socket) {	
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
				if(0 < input.available()) {
					byte[] rawInput = new byte[input.available()];
					input.read(rawInput);
					String rawStringInput = new String(IOUtils.toString(rawInput));
					JSONObject myJsonRes = new JSONObject(rawStringInput);
					String myRes = myJsonRes.getString("client");
				
					if(myRes.equals("Editor")) {
						currentUser = new EditorActor();
						break;
					} else if(myRes.equals("Reader")) {
						currentUser = new ReaderActor();
						break;
					} else {
						// nope waiting for connection type
					}
				}
			}
			
			while(true) {
				if(0 < input.available()) {
					byte[] rawInput = new byte[input.available()];
					input.read(rawInput);
					String rawStringInput = new String(IOUtils.toString(rawInput));
					JSONObject myJsonRes = new JSONObject(rawStringInput);
					String action = myJsonRes.getString("action");
					
					if(action.equals("add")) {
						DoAdd(myJsonRes);
					} else if(action.equals("getelement")) {
						DoGet(myJsonRes, "element");
					} else if(action.equals("getdb")) {
						DoGet(myJsonRes, "db");
					} else if(action.equals("edit")) {
						DoEdit(myJsonRes);
					} else if(action.equals("remove")) {
						DoRemove(myJsonRes);
					} else if(action.equals("subscribe")) {
						DoSubscribe(myJsonRes);
					} else if(action.equals("exit")) {
						break; // finally can die in peace
					} else {
						// invalid action, should not receive
					}
				}
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private synchronized void DoAdd(JSONObject jsonInput) {
		if(currentUser instanceof EditorActor) {
			String title = jsonInput.getString("title");
			String content = jsonInput.getString("content");
			String subtype = jsonInput.getString("subtype");
			ArrayList<String> toAddArray = new ArrayList<String>();
			
			toAddArray.add("title");
			toAddArray.add(title);
			toAddArray.add("content");
			toAddArray.add(content);
			toAddArray.add("subtype");
			toAddArray.add(subtype);
			myMongo.AddItemToCollection(toAddArray, "stiri");
		}
	}
	
	private void DoGet(JSONObject jsonInput, String need) {
		String jsonOutput = "fail";
		System.out.println("getting");
		if(need.equals("db")) {
			jsonOutput = myMongo.GetDBCollection("stiri").toString();
		} else if(need.equals("element")) {
			String title = jsonInput.getString("title");
			jsonOutput = myMongo.GetDBItem("title", title, "stiri").toString();
		}
		
		try {
			output.write(jsonOutput.getBytes("UTF-8"));
			output.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private synchronized void DoEdit(JSONObject jsonInput) {
		if(currentUser instanceof EditorActor) {
			String title = jsonInput.getString("title");
			String content = jsonInput.getString("content");
			ArrayList<String> toChangeInput = new ArrayList<String>();
			Document doc = new Document();
			
			toChangeInput.add("title");
			toChangeInput.add(title);
			doc.append("content", content);
			myMongo.UpdateItemFromCollection(toChangeInput, doc, MongoOperation.SET, "stiri");
		}
	}
	
	private synchronized void DoRemove(JSONObject jsonInput) {
		if(currentUser instanceof EditorActor) {
			String title = jsonInput.getString("title");
			
			myMongo.RemoveItemFromCollection("title", title, "stiri");
		}
	}
	
	private void DoSubscribe(JSONObject jsonInput) {
		
	}
	
}
