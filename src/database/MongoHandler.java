package database;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.bson.Document;
import org.bson.conversions.Bson;
import org.bson.json.JsonWriterSettings;
import org.json.JSONArray;
import org.json.JSONObject;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.FindOneAndUpdateOptions;

public class MongoHandler {
	
	private static final String connectionString = "mongodb://zeus:Arcuitu23@appoint-db-shard-00-00.vo3dd.mongodb.net:27017,appoint-db-shard-00-01.vo3dd.mongodb.net:27017,appoint-db-shard-00-02.vo3dd.mongodb.net:27017/news?ssl=true&replicaSet=appoint-db-shard-0&authSource=admin&w=majority";
	private static final Map<MongoOperation, String> mongoOp = Map.ofEntries(
			new AbstractMap.SimpleEntry<MongoOperation, String>(MongoOperation.INC, "$inc"),
			new AbstractMap.SimpleEntry<MongoOperation, String>(MongoOperation.MIN, "$min"),
			new AbstractMap.SimpleEntry<MongoOperation, String>(MongoOperation.MAX, "$max"),
			new AbstractMap.SimpleEntry<MongoOperation, String>(MongoOperation.MUL, "$mul"),
			new AbstractMap.SimpleEntry<MongoOperation, String>(MongoOperation.RENAME, "$rename"),
			new AbstractMap.SimpleEntry<MongoOperation, String>(MongoOperation.SET, "$set"),
			new AbstractMap.SimpleEntry<MongoOperation, String>(MongoOperation.SETONINSERT, "$setOnInsert"),
			new AbstractMap.SimpleEntry<MongoOperation, String>(MongoOperation.UNSET, "$unset"));
	private MongoClient databaseClient;
	private MongoCollection<Document> databaseCollection;
	
	public MongoHandler() {
		Logger.getLogger("org.mongodb.driver").setLevel(Level.WARNING);
		
		try {
			MongoClientURI uri = new MongoClientURI(connectionString);
			databaseClient = new MongoClient(uri);
		} catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public void AddItemToCollection(ArrayList<String> item, String collection) {
		GetCollection(collection);
		Document doc = CreateDocument(item);
		
		try {
			databaseCollection.insertOne(doc);
		} catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public void RemoveItemFromCollection(String property, String value, String collection) {
		GetCollection(collection);
		Bson item = Filters.eq(property, value);
		
		try {
			databaseCollection.findOneAndDelete(item);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void UpdateItemFromCollection(ArrayList<String> item, Document update, MongoOperation operation, String collection) {
		Document filter = new Document(item.get(0), item.get(1));
		Document toUpdate = new Document(mongoOp.get(operation), update);
		
		GetCollection(collection);
		
		try {
			Document pepe = databaseCollection.findOneAndUpdate(filter, toUpdate, new FindOneAndUpdateOptions().upsert(true));
			System.out.println(pepe);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public JSONArray GetDBCollection(String collection) {
		JSONArray res = new JSONArray();
		MongoCursor<Document> cursor = null;
		GetCollection(collection);
		
		try {
			cursor = databaseCollection.find().iterator();
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		while(cursor.hasNext()) {
			Document object = cursor.next();
			JsonWriterSettings writerSettings = JsonWriterSettings.builder().indent(true).build();
			JSONObject json = new JSONObject(object.toJson(writerSettings));
			//JSON.ser
			res.put(json);
		}
		
		return res;
	}
	
	private void GetCollection(String collection) {
		try {
			databaseCollection = databaseClient.getDatabase("news").getCollection(collection);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	private Document CreateDocument(ArrayList<String> elements) {
		Document doc = new Document();
		Iterator<String> it = elements.iterator();
		String key = null, value = null;
		boolean gotBoth = false;
		int crtRun = 0;
		
		while(it.hasNext()) {
			if(0 == (crtRun % 2)) {
				key = it.next();
				gotBoth = false;
			} else {
				value = it.next();
				gotBoth = true;
			}
			crtRun++;
			
			if(gotBoth) {
				doc.append(key, value);
			}
		}
		
		
		return doc;
	}
}
