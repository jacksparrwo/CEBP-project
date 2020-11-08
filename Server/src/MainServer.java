import org.json.JSONArray;

import database.MongoHandler;
import handlers.ServerRunner;

public class MainServer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MongoHandler myMongo = new MongoHandler();
		//ArrayList<String> s = new ArrayList<String>();
		//ArrayList<String> s2 = new ArrayList<String>();
		//s.add("nume");
		//s.add("peste");
		//s.add("culoare");
		//s.add("roz");
		//s.add("nume");
		//s.add("peste");
		//s2.add("maro");
		//s2.add("verde");
		//Document doc = new Document("culoare", "verde");
		//myMongo.AddItemToCollection(s, "prostii");
		System.out.println(myMongo.GetDBCollection("prostii"));
		//MongoOperation dd = MongoOperation.SET;
		//myMongo.UpdateItemFromCollection(s, doc, dd, "prostii");
		JSONArray elem = new JSONArray();
		//myMongo.CreateDoc(myMongo.GetDBCollection("prostii"));
		//myMongo.RemoveItemFromCollection("nume", "peste", "prostii");
		
		ServerRunner server = ServerRunner.GetInstance();
		server.Run();
	}

}
