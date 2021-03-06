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


public class Interface {

	public JFrame frame;
	private JTextField txtNewsFeed;
	private JTextField textFieldcated;
	private JTextField txtY;
	JList whatYouSubbed;
	
	public Interface() {
		initialize();
	}

	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 800, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		
		JDesktopPane desktopPane = new JDesktopPane();
		frame.getContentPane().add(desktopPane, BorderLayout.CENTER);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setBounds(46, 46, 361, 504);
		desktopPane.add(scrollPane);
		
		txtNewsFeed = new JTextField();
		txtNewsFeed.setBackground(SystemColor.activeCaption);
		txtNewsFeed.setBounds(46, 11, 361, 36);
		desktopPane.add(txtNewsFeed);
		txtNewsFeed.setHorizontalAlignment(SwingConstants.CENTER);
		txtNewsFeed.setText("News Feed");
		txtNewsFeed.setColumns(10);
		txtNewsFeed.setEditable(false);
		
		textFieldcated = new JTextField();
		textFieldcated.setBackground(Color.PINK);
		textFieldcated.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldcated.setText("News Categories");
		textFieldcated.setBounds(519, 32, 215, 20);
		desktopPane.add(textFieldcated);
		textFieldcated.setColumns(10);
		textFieldcated.setEditable(false);
		
		//JList list = new JList();
		//list.setBackground(SystemColor.control);
		//list.setBounds(519, 46, 215, 226);
		//desktopPane.add(list);
		
		//whatYouSubbed = new JList(subscriptionCategoryList.toArray());
	
		//whatYouSubbed.setVisibleRowCount(3);
		//whatYouSubbed.setBackground(SystemColor.controlShadow);
		//whatYouSubbed.setBounds(535, 351, 160, 158);
		//desktopPane.add(whatYouSubbed);
		
		txtY = new JTextField();
		txtY.setBackground(SystemColor.info);
		txtY.setHorizontalAlignment(SwingConstants.CENTER);
		txtY.setText("You are subscribed to:");
		txtY.setBounds(535, 329, 160, 20);
		desktopPane.add(txtY);
		txtY.setColumns(10);
		
		//JLabel lblNewLabel = new JLabel("");
		//lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Manu\\eclipse-workspace\\CEBP\\backg.png"));
		//lblNewLabel.setBounds(0, 0, 784, 561);
		//desktopPane.add(lblNewLabel);
	}
}
