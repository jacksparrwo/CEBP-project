import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.SystemColor;

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

import javax.swing.JFrame;
import javax.swing.*;
import java.awt.event.*;  
public class CheckInterface extends JFrame{

	
	private JButton buttonEditor,buttonReader;
	
	public CheckInterface() {
		
		
		setLayout(new FlowLayout());
		setBounds(100, 100, 200, 100);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setLocationRelativeTo(null);
		
		JDesktopPane desktopPane = new JDesktopPane();
		getContentPane().add(desktopPane, BorderLayout.CENTER);

		buttonEditor = new JButton("EDITOR");
	    add(buttonEditor);
	    
	    buttonEditor.addActionListener(new ActionListener(){ 
	    	
			@Override
			public void actionPerformed(ActionEvent e) {
				EditorInterface ei=new EditorInterface() ;
				ei.setVisible(true);
				dispose();
			}
			
	    	
	    });
	    
	    buttonReader = new JButton("READER");
	    add(buttonReader);
	    
	    buttonReader.addActionListener(new ActionListener(){ 
	    	
	 			@Override
	 			public void actionPerformed(ActionEvent e) {
	 				ReaderInterface ri=new ReaderInterface() ;
	 				ri.setVisible(true);
	 				dispose();
	 			}
	 			
	 	    	
	 	    });
	    

	     

	}



}
