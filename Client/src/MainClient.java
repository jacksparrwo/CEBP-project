import java.awt.EventQueue;
import java.util.ArrayList;

import handlers.InterfaceHandler;

public class MainClient {
	
	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CheckInterface window = new CheckInterface();
					window.setVisible(true);
					InterfaceHandler ih = InterfaceHandler.GetInstance();
					ArrayList<String> s = new ArrayList<>();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
