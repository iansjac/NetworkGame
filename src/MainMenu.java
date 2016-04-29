import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;



/**
 * Created by Janine Jay, Melkis Espinal, Ian Jacobs and Ally Colisto
 */

public class MainMenu {
//hi janina
	private JTextArea textArea = new JTextArea();
	private JTextArea ipv4 = new JTextArea();
	private JTextArea portnum = new JTextArea();
	
	JLabel image = new JLabel();
	
	JLabel user = new JLabel("Username");
	JLabel ip = new JLabel("Input IP");
	JLabel portz = new JLabel("Input Port #");
	JFrame Menu = new JFrame("A-Maze-Ing");
	JButton Login = new JButton("Login");
	String userName = "";
	String ipv6 = "";
	String port = "";
	
	
	

	public MainMenu() {
		
		//Menu Variables
		Menu.setResizable(false);
		Menu.setSize(700, 453);
		Menu.setLayout(null);
		Menu.setLocationRelativeTo(null);
		Menu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		//Start Button Variables
		Login.setSize(100,30);
		Login.setLocation(20, 350);
		Menu.add(Login);
		
	
		
		
		//text area
		textArea.setSize(100, 20);
		textArea.setLocation(20, 200);
		userName = textArea.getText();
		Menu.add(textArea);
		
		//text area two
		ipv4.setSize(100, 20);
		ipv4.setLocation(20, 250);
		ipv6 = ipv4.getText();
		Menu.add(ipv4);
		
		//text are tres
		portnum.setSize(100, 20);
		portnum.setLocation(20, 300);
		port = portnum.getText();
		Menu.add(portnum);
			
		//username
		user.setSize(150, 20);
		user.setLocation(20, 175);
		Menu.add(user);
		
		//ip label
		ip.setSize(150, 20);
		ip.setLocation(20, 225);
		Menu.add(ip);
		
		//port label
		portz.setSize(150, 20);
		portz.setLocation(20, 275);
		Menu.add(portz);
		
		//background image
	    image.setIcon(new ImageIcon("./images/MazeGameTitle.png"));// your image here
	    image.setSize(700, 500);
	    image.setLocation(0, -45);
	    Menu.add(image);
		
		Login.addActionListener(new ActionListener(){

			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				new Maze("./map.map");
				Menu.setVisible(false);
			}

		});	

		Menu.setVisible(true);
	}
}
