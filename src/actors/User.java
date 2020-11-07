package actors;

import java.util.ArrayList;



public interface User {
	
static ArrayList<String> subscriptionCategoryList = new ArrayList<String>();


public String getUserType(String userType);
public void readNews(); // afisare news
public void subToNewsCatergory(String category);


}
