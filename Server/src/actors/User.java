package actors;

import java.util.ArrayList;

public interface User {

	ArrayList<String> subscriptionCategoryList = new ArrayList<String>();

	public String getUserType();
	public void readNews(); // afisare news
	public void subToNewsCatergory(String category);
	
}
