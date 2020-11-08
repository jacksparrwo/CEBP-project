package actors;
import java.util.ArrayList;


public class Editor implements User  {
	
	private static final String userType = "Editor";
	private String name;
	private static String category;
	private ArrayList<String> subscriptionCategoryList = new ArrayList<String>();


	public Editor(String name) {
		this.name=name;
		// have to imp more
	}

	public String getUserType() {
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
	
	public void newsEdit() {
		// to be implemented
	}
	
	public void addNewsToCategory() {
		
	}
}
