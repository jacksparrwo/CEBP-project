import java.awt.EventQueue;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;

import org.json.JSONArray;

import actors.EditorActor;
import database.MongoHandler;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
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
		
		newsFeed.setVisibleRowCount(3);
		newsFeed.setBackground(Color.PINK);
	
		

		
		txtNewsFeed = new JTextField();
		txtNewsFeed.setBackground(Color.YELLOW);
		txtNewsFeed.setHorizontalAlignment(SwingConstants.CENTER);
		txtNewsFeed.setText("News Feed");
		txtNewsFeed.setColumns(10);
		txtNewsFeed.setEditable(false);
		
	
		//ADD BUTTON
		JButton addB = new JButton("ADD");
		addB.setBackground(Color.GREEN);
		addB.addActionListener(new ActionListener(){ 
		    	
				@Override
				public void actionPerformed(ActionEvent e) {
					InterfaceHandler ih = InterfaceHandler.GetInstance();
					ArrayList<String> s = new ArrayList<>();
					s.add("action");
					s.add("add");
					s.add("title");
					s.add("Asta e un titlu de stire");
					s.add("content");
					s.add("This is the content of the news");
					s.add("subtype");
					s.add("This is the subtype");
					ih.PrepareJSON(s);
					ih.DoSend();
					System.out.println("test add");
					
				}
				
		    	
		    });
		 
		 
		//DELETE BUTTON
		JButton deleteB = new JButton("DELETE");
		deleteB.setBackground(Color.RED);
		deleteB.addActionListener(new ActionListener(){ 
		    	
				@Override
				public void actionPerformed(ActionEvent e) {
					InterfaceHandler ih = InterfaceHandler.GetInstance();
					ArrayList<String> s = new ArrayList<>();
					s.add("action");
					s.add("remove");
					s.add("title");
					s.add("Asta e un titlu de stire");
					ih.PrepareJSON(s);
					ih.DoSend();
					System.out.println("test delete");
					
				}
				
		    	
		    });
		 
		 
		//EDIT BUTTON
		JButton editB = new JButton("EDIT");
		editB.setBackground(Color.MAGENTA);
		editB.addActionListener(new ActionListener(){ 
	    	
			@Override
			public void actionPerformed(ActionEvent e) {
				InterfaceHandler ih = InterfaceHandler.GetInstance();
				ArrayList<String> s = new ArrayList<>();
				s.add("action");
				s.add("edit");
				s.add("title");
				s.add("Asta e un titlu de stire editat");
				s.add("content");
				s.add("This is the edited content of the news");
				ih.PrepareJSON(s);
				ih.DoSend();
				System.out.println("test edit");
				
			}
			
	    	
	    });
		
		
		
		textField = new JTextField();
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Title");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel lblNewLabel_1 = new JLabel("Content");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		
		JButton getbtn = new JButton("GET");
		getbtn.setBackground(Color.GRAY);
		getbtn.addActionListener(new ActionListener(){ 
	    	
			@Override
			public void actionPerformed(ActionEvent e) {
				InterfaceHandler ih = InterfaceHandler.GetInstance();
				ArrayList<String> s = new ArrayList<>();
				s.add("action");
				s.add("getdb");
				s.add("db");
				s.add("stiri");
				ih.PrepareJSON(s);
				ih.DoReceive();
				System.out.println("test get");
			}
			
	    	
	    });
		
		GroupLayout gl_desktopPane = new GroupLayout(desktopPane);
		gl_desktopPane.setHorizontalGroup(
			gl_desktopPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_desktopPane.createSequentialGroup()
					.addGap(46)
					.addGroup(gl_desktopPane.createParallelGroup(Alignment.LEADING)
						.addComponent(newsFeed, GroupLayout.PREFERRED_SIZE, 361, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtNewsFeed, GroupLayout.PREFERRED_SIZE, 361, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_desktopPane.createParallelGroup(Alignment.LEADING, false)
						.addGroup(gl_desktopPane.createSequentialGroup()
							.addGroup(gl_desktopPane.createParallelGroup(Alignment.TRAILING)
								.addGroup(gl_desktopPane.createSequentialGroup()
									.addGroup(gl_desktopPane.createParallelGroup(Alignment.LEADING)
										.addComponent(editB, GroupLayout.PREFERRED_SIZE, 74, GroupLayout.PREFERRED_SIZE)
										.addGroup(gl_desktopPane.createParallelGroup(Alignment.TRAILING)
											.addComponent(deleteB, GroupLayout.PREFERRED_SIZE, 74, GroupLayout.PREFERRED_SIZE)
											.addComponent(addB, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 74, GroupLayout.PREFERRED_SIZE)
											.addComponent(lblNewLabel_1)))
									.addGap(18))
								.addComponent(lblNewLabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
							.addGroup(gl_desktopPane.createParallelGroup(Alignment.LEADING, false)
								.addComponent(textField_1)
								.addComponent(textField, GroupLayout.DEFAULT_SIZE, 245, Short.MAX_VALUE)))
						.addComponent(getbtn, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					.addContainerGap(44, Short.MAX_VALUE))
		);
		gl_desktopPane.setVerticalGroup(
			gl_desktopPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_desktopPane.createSequentialGroup()
					.addGap(11)
					.addGroup(gl_desktopPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_desktopPane.createSequentialGroup()
							.addGap(9)
							.addGroup(gl_desktopPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNewLabel))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_desktopPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(newsFeed, GroupLayout.PREFERRED_SIZE, 504, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_desktopPane.createSequentialGroup()
									.addGroup(gl_desktopPane.createParallelGroup(Alignment.LEADING, false)
										.addGroup(gl_desktopPane.createSequentialGroup()
											.addGap(34)
											.addComponent(addB)
											.addGap(11)
											.addComponent(deleteB)
											.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
											.addComponent(editB))
										.addComponent(textField, GroupLayout.PREFERRED_SIZE, 128, GroupLayout.PREFERRED_SIZE))
									.addGap(20)
									.addComponent(getbtn))
								.addComponent(lblNewLabel_1)))
						.addComponent(txtNewsFeed, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)))
		);
		desktopPane.setLayout(gl_desktopPane);
		
		
		frame.setVisible(true);

	
	}
}

