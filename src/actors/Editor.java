package actors;
import java.util.ArrayList;


public class Editor implements User  {
private String name;
static ArrayList<String> subscriptionCategoryList = new ArrayList<String>();


	public Editor(String name) {
		this.name=name;
		// have to imp more
	}
	
	public String getUserType(String userType) {
		
		return userType;
		
	}
	public void readNews() {
		// afisare news
	}
	public void subToNewsCatergory(String category) {
		subscriptionCategoryList.add(category);
	}
	
	public String getReaderName(String name) {
		return this.name;
	}
}
