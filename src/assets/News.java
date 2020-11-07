package assets;
import java.awt.Button;
import java.awt.Color;

import javax.swing.JTextPane;
import java.util.ArrayList;

public class News {
	private String newsName;
	private static String category;
    static ArrayList<String> newsText;
	public News(String newsName,String category)
	{
		this.newsName=newsName;
		this.category=category;
	}
	
	
	public void addNews(){
        for(int i = 0; i < newsText.size();i++){         // need to be tested all of them( add remove modifiy )
        	newsText.add(i,newsText.get(i));
        	         
        }
	}
	public void removeNews(){
		for(int i = 0; i < newsText.size();i++){  
			newsText.remove(i);
		}
      
	}
	public void modifyNews(){
		for(int i = 0; i < newsText.size();i++){  
			newsText.set(i,newsText.get(i));
		}
	}
}
/*
public class News {
	
//private int yCoord=375;
	public News(){
		
		JTextPane textPane = new JTextPane();
		textPane.setBackground(Color.ORANGE);
		textPane.setBounds(482, 347, 60, 50);
		//desktopPane.add(textPane);
		
	                                                        // fail de interfata :)))
		
		Button button = new Button("New button");
		button.setBounds(548, 347, 70, 22);
		//desktopPane.add(button_1);
		
		yCoord+=28;
		
		Button button1 = new Button("New button");
		button1.setBounds(548, 375, 70, 22);
		//desktopPane.add(button);
		
		
	
		yCoord+=80;
		
		                                                         // ITS BAD OVER HERE 
		                                                   // IM GONNA REMOVE IT AND REMAKE IT 
			
	}*/


