package actors;
import java.util.ArrayList;

public class Reader implements User {
	
	private static final String userType = "Reader";
	private String name;
	private ArrayList<String> subscriptionCategoryList = new ArrayList<String>();

	public Reader(String name) {
		this.name=name;
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
}
