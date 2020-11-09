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
import javax.swing.GroupLayout.Alignment;

import org.json.JSONArray;

import actors.EditorActor;
import database.MongoHandler;
import handlers.InterfaceHandler;

import javax.swing.GroupLayout;
import javax.swing.JButton;

public class ReaderInterface extends JFrame{
	
	private JButton subB;
	private JList newsFeed;
	private JTextField txtNewsFeed;
	private JFrame frame;
	public ReaderInterface() {
		
		
		
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
		JButton subB = new JButton("SUBSCRIBE");
		subB.setBackground(Color.GREEN);
		subB.addActionListener(new ActionListener(){ 
		    	
				@Override
				public void actionPerformed(ActionEvent e) {
					InterfaceHandler ih = InterfaceHandler.GetInstance();
					ArrayList<String> s = new ArrayList<>();
					s.add("action");
					s.add("subscribe");
					// have to be implemeted
					ih.PrepareJSON(s);
					ih.DoSend();
					System.out.println("test subscribe");
				}
				
		    	
		    });
		
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
						.addGroup(gl_desktopPane.createSequentialGroup()
							.addComponent(newsFeed, GroupLayout.PREFERRED_SIZE, 361, GroupLayout.PREFERRED_SIZE)
							.addGap(59)
							.addGroup(gl_desktopPane.createParallelGroup(Alignment.LEADING, false)
								.addComponent(getbtn, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(subB, GroupLayout.DEFAULT_SIZE, 119, Short.MAX_VALUE)))
						.addComponent(txtNewsFeed, GroupLayout.PREFERRED_SIZE, 361, GroupLayout.PREFERRED_SIZE))
					.addGap(209))
		);
		gl_desktopPane.setVerticalGroup(
			gl_desktopPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_desktopPane.createSequentialGroup()
					.addGroup(gl_desktopPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_desktopPane.createSequentialGroup()
							.addGap(11)
							.addGroup(gl_desktopPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_desktopPane.createSequentialGroup()
									.addGap(35)
									.addComponent(newsFeed, GroupLayout.PREFERRED_SIZE, 504, GroupLayout.PREFERRED_SIZE))
								.addComponent(txtNewsFeed, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)))
						.addGroup(gl_desktopPane.createSequentialGroup()
							.addGap(143)
							.addComponent(getbtn)
							.addGap(18)
							.addComponent(subB)))
					.addContainerGap(21, Short.MAX_VALUE))
		);
		desktopPane.setLayout(gl_desktopPane);
		frame.setVisible(true);
	}
}


