import java.awt.EventQueue;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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

public class EditorInterface extends JFrame{
	private JButton addB,deleteB,editB;
	private JList newsFeed;
	private JTextField txtNewsFeed;
	private JFrame frame;
	
	public EditorInterface() {
		 
		JFrame frame = new JFrame();
		frame.setBounds(100, 100, 800, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		
		JDesktopPane desktopPane = new JDesktopPane();
		frame.getContentPane().add(desktopPane, BorderLayout.CENTER);
		

		newsFeed = new JList();
		
		newsFeed.setVisibleRowCount(3);
		newsFeed.setBackground(Color.PINK);
		newsFeed.setBounds(46, 46, 361, 504);
		desktopPane.add(newsFeed);
	
		

		
		txtNewsFeed = new JTextField();
		txtNewsFeed.setBackground(Color.YELLOW);
		txtNewsFeed.setBounds(46, 11, 361, 36);
		desktopPane.add(txtNewsFeed);
		txtNewsFeed.setHorizontalAlignment(SwingConstants.CENTER);
		txtNewsFeed.setText("News Feed");
		txtNewsFeed.setColumns(10);
		txtNewsFeed.setEditable(false);
		
	
		//ADD BUTTON
		JButton addB = new JButton("ADD");
		addB.setBackground(Color.GREEN);
		addB.setBounds(466, 184, 89, 23);
		desktopPane.add(addB);
		addB.addActionListener(new ActionListener(){ 
		    	
				@Override
				public void actionPerformed(ActionEvent e) {
					
				}
				
		    	
		    });
		 
		 
		//DELETE BUTTON
		JButton deleteB = new JButton("DELETE");
		deleteB.setBackground(Color.RED);
		deleteB.setBounds(466, 233, 89, 23);
		desktopPane.add(deleteB);
		deleteB.addActionListener(new ActionListener(){ 
		    	
				@Override
				public void actionPerformed(ActionEvent e) {
					
				}
				
		    	
		    });
		 
		 
		//EDIT BUTTON
		JButton editB = new JButton("EDIT");
		editB.setBackground(Color.MAGENTA);
		editB.setBounds(466, 286, 89, 23);
		desktopPane.add(editB);
		editB.addActionListener(new ActionListener(){ 
		    	
				@Override
				public void actionPerformed(ActionEvent e) {
					
				}
				
		    	
		    });
		
		
		
	
	}

}

