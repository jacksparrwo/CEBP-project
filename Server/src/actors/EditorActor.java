package actors;

import java.util.ArrayList;

public class EditorActor implements User  {
	
	private static final String userType = "Editor";
	private String name;
	private ArrayList<String> subscriptionCategoryList = new ArrayList<String>();


	public EditorActor() {

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
