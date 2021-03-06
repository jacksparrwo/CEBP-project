import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;

import org.json.JSONArray;

import handlers.InterfaceHandler;

public class EditorInterface extends JFrame{
	private JButton addB,deleteB,editB;
	private JList newsFeed;
	private JTextField txtNewsFeed;
	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	
	public EditorInterface() {
		 
		JFrame frame = new JFrame();
		frame.setBounds(100, 100, 800, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		
		JDesktopPane desktopPane = new JDesktopPane();
		frame.getContentPane().add(desktopPane, BorderLayout.CENTER);
		
		

		JList newsFeed = new JList();
		newsFeed.setBounds(46, 46, 361, 504);
		
		newsFeed.setVisibleRowCount(3);
		newsFeed.setBackground(Color.PINK);
	
		

		
		txtNewsFeed = new JTextField();
		txtNewsFeed.setBounds(46, 11, 361, 36);
		txtNewsFeed.setBackground(Color.YELLOW);
		txtNewsFeed.setHorizontalAlignment(SwingConstants.CENTER);
		txtNewsFeed.setText("News Feed");
		txtNewsFeed.setColumns(10);
		txtNewsFeed.setEditable(false);
		
		
		textField = new JTextField();
		textField.setBounds(505, 46, 245, 128);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(505, 20, 245, 20);
		textField_1.setColumns(10);
		
		
	
		//ADD BUTTON
		JButton addB = new JButton("ADD");
		addB.setBounds(413, 80, 81, 23);
		addB.setBackground(Color.GREEN);
		addB.addActionListener(new ActionListener(){ 
		    	
				@Override
				public void actionPerformed(ActionEvent e) {
					InterfaceHandler ih = InterfaceHandler.GetInstance();
					ArrayList<String> s = new ArrayList<>();
					
					s.add("action");
					s.add("add");
					s.add("title");
					s.add(textField_1.getText());
					System.out.println("Succesfully added title: "+textField_1.getText());
					s.add("content");
					s.add(textField.getText());
					System.out.println("Succesfully added content: "+textField.getText());
					s.add("subtype");
					s.add("This is the subtype");
					ih.PrepareJSON(s);
					ih.DoSend();
					System.out.println("You succesfully added the news");
					
				}
				
		    	
		    });
		 
		 
		//DELETE BUTTON
		JButton deleteB = new JButton("DELETE");
		deleteB.setBounds(413, 114, 81, 23);
		deleteB.setBackground(Color.RED);
		deleteB.addActionListener(new ActionListener(){ 
		    	
				@Override
				public void actionPerformed(ActionEvent e) {
					InterfaceHandler ih = InterfaceHandler.GetInstance();
					ArrayList<String> s = new ArrayList<>();
					s.add("action");
					s.add("remove");
					s.add("title");
					s.add(textField_1.getText());
					System.out.println("Succesfully removed the news with the title: "+textField_1.getText());
					ih.PrepareJSON(s);
					ih.DoSend();
					System.out.println("You succesfully removed the news");
					
				}
				
		    	
		    });
		 
		 
		//EDIT BUTTON
		JButton editB = new JButton("EDIT");
		editB.setBounds(413, 151, 81, 23);
		editB.setBackground(Color.MAGENTA);
		editB.addActionListener(new ActionListener(){ 
	    	
			@Override
			public void actionPerformed(ActionEvent e) {
				InterfaceHandler ih = InterfaceHandler.GetInstance();
				ArrayList<String> s = new ArrayList<>();
				s.add("action");
				s.add("edit");
				s.add("title");
				s.add(textField_1.getText());
				System.out.println("Succesfully edited title: "+textField_1.getText());
				s.add("content");
				s.add(textField.getText());
				System.out.println("Succesfully edited content: "+textField.getText());
				ih.PrepareJSON(s);
				ih.DoSend();
				System.out.println("You succesfully edited the news");
				
			}
			
	    	
	    });
		
		
		
		textField = new JTextField();
		textField.setBounds(515, 46, 235, 128);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(515, 20, 235, 20);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Title");
		lblNewLabel.setBounds(413, 23, 92, 14);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel lblNewLabel_1 = new JLabel("Content");
		lblNewLabel_1.setBounds(423, 47, 64, 14);
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		
		JButton getbtn = new JButton("GET");
		getbtn.setBounds(413, 194, 337, 23);
		getbtn.setBackground(Color.GRAY);
		getbtn.addActionListener(new ActionListener(){ 
	    	
			@Override
			public void actionPerformed(ActionEvent e) {
				InterfaceHandler ih = InterfaceHandler.GetInstance();
				ArrayList<String> s = new ArrayList<>();
				s.add("action");
				s.add("getdb");
				ih.PrepareJSON(s);
				ih.DoSend();
				JSONArray ar = ih.DoReceive();
				System.out.println(ar);
			}
			
	    	
	    });
		desktopPane.setLayout(null);
		desktopPane.add(newsFeed);
		desktopPane.add(txtNewsFeed);
		desktopPane.add(editB);
		desktopPane.add(deleteB);
		desktopPane.add(addB);
		desktopPane.add(lblNewLabel_1);
		desktopPane.add(lblNewLabel);
		desktopPane.add(textField_1);
		desktopPane.add(textField);
		desktopPane.add(getbtn);
		
		
		frame.setVisible(true);

	
	}
	
}

