import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;



/**
 * Created by Janine Jay, Melkis Espinal, Ian Jacobs and Ally Colisto
 */

public class MainMenu {

	private JTextArea textArea = new JTextArea();
	private JTextArea ipv4 = new JTextArea();
	private JTextArea portnum = new JTextArea();
	JLabel user = new JLabel("Username");
	JLabel ip = new JLabel("Input IP");
	JLabel portz = new JLabel("Input Port #");
	JFrame Menu = new JFrame("Maze of Fury");
	JButton Start = new JButton("Login");
	String userName = "";
	String ipv6 = "";
	String port = "";

	public MainMenu() {
		
		//Menu Variables
		Menu.setResizable(false);
		Menu.setSize(500, 500);
		Menu.setLayout(null);
		Menu.setLocationRelativeTo(null);
		Menu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		//Start Button Variables
		Start.setSize(100,30);
		Start.setLocation(100, 225);
		Menu.add(Start);
		
		//text area
		textArea.setSize(300, 20);
		textArea.setLocation(100, 100);
		userName = textArea.getText();
		Menu.add(textArea);
		
		//text area two
		ipv4.setSize(300, 20);
		ipv4.setLocation(100, 150);
		ipv6 = ipv4.getText();
		Menu.add(ipv4);
		
		//text are tres
		portnum.setSize(300, 20);
		portnum.setLocation(100, 200);
		port = portnum.getText();
		Menu.add(portnum);
			
		//username
		user.setSize(150, 20);
		user.setLocation(100, 75);
		Menu.add(user);
		
		//ip label
		ip.setSize(150, 20);
		ip.setLocation(100, 125);
		Menu.add(ip);
		
		//port label
		portz.setSize(150, 20);
		portz.setLocation(100, 175);
		Menu.add(portz);
		
		
		Start.addActionListener(new ActionListener(){

			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				new Maze("./map.map");
				Menu.setVisible(false);
			}

		});	

		Menu.setVisible(true);
	}
}
