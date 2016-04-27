import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;



/**
 * Created by Janine Jay, Melkis Espinal, Ian Jacobs and Ally Colisto
 */

public class MainMenu {

	private JTextArea textArea = new JTextArea();
	JLabel user = new JLabel("Username");
	JFrame Menu = new JFrame("Maze of Fury");
	JButton Start = new JButton("Login");
	ArrayList<String> mapList = new ArrayList<String>();
	JComboBox<String> lvlList;
	
	


	public MainMenu() {
		//Load map list
		getMapList();
		lvlList = new JComboBox<String>(mapList.toArray(new String[mapList.size()]));
		
		//Menu Variables
		Menu.setResizable(false);
		Menu.setSize(500, 500);
		Menu.setLayout(null);
		Menu.setLocationRelativeTo(null);
		Menu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		//Start Button Variables
		Start.setSize(100,30);
		Start.setLocation(100, 125);
		Menu.add(Start);
		
		//text area
		textArea.setSize(300, 20);
		textArea.setLocation(100, 100);
		Menu.add(textArea);
				
		//username
		user.setSize(150, 20);
		user.setLocation(100, 75);
		Menu.add(user);
				
		
		Start.addActionListener(new ActionListener(){

			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				new Maze(lvlList.getSelectedItem().toString());
				Menu.setVisible(false);
			}

		});	

		Menu.setVisible(true);
	}

	static boolean levelsExistAlready = false;

	public void getMapList(){
		for(int i = 0; i < 99; i++){
			File map = new File("./Level "+i+".map");
			if(map.exists()){
				mapList.add("Level "+i+".map");
				levelsExistAlready = true;
			}
		}
	}
}