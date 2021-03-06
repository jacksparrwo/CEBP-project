package handlers;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.IOUtils;
import org.bson.Document;
import org.bson.json.JsonWriterSettings;
import org.json.JSONArray;
import org.json.JSONObject;

public class InterfaceHandler {
	
	private static InterfaceHandler iHandler = null;
	private Socket socket;
	private InputStream input;
	private OutputStream output;
	private JSONObject json;
	
	private InterfaceHandler() {
		try {
			this.socket = new Socket("localhost", 5000);
			input = new BufferedInputStream(socket.getInputStream());
			output = socket.getOutputStream();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static InterfaceHandler GetInstance() {
		if(null == iHandler) {
			iHandler = new InterfaceHandler();
			
			// wait a bit 
			try {
				TimeUnit.SECONDS.sleep(2);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		return iHandler;
	}
	
	public JSONArray DoReceive() {
		JSONArray res = new JSONArray();
		
		try {
			while(true) {
				if(0 < input.available()) {
					byte[] rawInput = new byte[input.available()];
					input.read(rawInput);
					String rawStringInput = new String(IOUtils.toString(rawInput));
					res = new JSONArray(rawStringInput);
					break;
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return res;
	}
	
	public void DoSend() {
		try {
			output.write(json.toString().getBytes("UTF-8"));
			output.flush();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void PrepareJSON(ArrayList<String> toSend) {
		Document doc = new Document();
		Iterator<String> it = toSend.iterator();
		String key = null, val = null;
		int crtCnt = 0;
		boolean gotBoth = false;
		
		while(it.hasNext()) {
			if(0 == (crtCnt % 2)) {
				key = it.next();
				gotBoth = false;
			} else {
				val = it.next();
				gotBoth = true;
			}
			
			if(gotBoth) {
				doc.append(key, val);
			}
			
			crtCnt++;
		}
		
		JsonWriterSettings writerSettings = JsonWriterSettings.builder().indent(true).build();
		json = new JSONObject(doc.toJson(writerSettings));
	}
	
}
