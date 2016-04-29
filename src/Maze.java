import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.FileReader;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 * Created by Janine Jay, Melkis Espinal, Ian Jacobs and Ally Colisto
 */

public class Maze extends JFrame{
    public static int _rows = 20;
    public static int _columns = 20;
    public static int _windowSize = 25;
    public static int _map[][] = new int[_columns][_rows];
    public static int _endLoc;
    public static int endloc2;
    Player _player;
    Player player2;
    
    public Maze(String str){
        loadMap(str);
        this.setResizable(false);
        this.setSize((_columns*_windowSize)+50, (_rows*_windowSize)+70);
        this.setTitle("Maze");
       this.setLayout(null);
        
        this.addKeyListener(new KeyListener(){

			@Override
			public void keyPressed(KeyEvent e) {
				int key = e.getKeyCode();
		
				//Player movement
				if(key == KeyEvent.VK_UP){
					_player.moveUp();
				}
				if(key == KeyEvent.VK_LEFT){
					_player.moveLeft();
				}
				if(key == KeyEvent.VK_DOWN){
					_player.moveDown();
				}
				if(key == KeyEvent.VK_RIGHT){
					_player.moveRight();
				}
				
				//player2 movement
				if(key == KeyEvent.VK_W){
					player2.moveUp();
				}
				if(key == KeyEvent.VK_A){
					player2.moveLeft();
				}
				if(key == KeyEvent.VK_S){
					player2.moveDown();
				}
				if(key == KeyEvent.VK_D){
					player2.moveRight();
				}
				
				
				
				
				
				
				if(_player._x == _columns-1 && _player._y == _endLoc){
					JOptionPane.showMessageDialog(null, "Player One WINS", "End Game", JOptionPane.INFORMATION_MESSAGE);
					//dispose();
				}
				
				if(player2._x == _columns+1 && player2._y == endloc2){
					JOptionPane.showMessageDialog(null, "Player Two Wins", "End Game", JOptionPane.INFORMATION_MESSAGE);
					//dispose();
				}
				
			}

			@Override
			public void keyReleased(KeyEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void keyTyped(KeyEvent arg0) {
				// TODO Auto-generated method stub
				
			}
        	
        });
        
        this.addWindowListener(new WindowAdapter(){
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        
        this.setLocationRelativeTo(null);
        
        //Create player
    	_player = new Player();
    	_player.setVisible(true);
    	_player.setColor(Color.BLUE);
    	this.add(_player);
    	
    	player2 = new Player();
    	player2.setVisible(true);
    	player2.setColor(Color.RED);
    	this.add(player2);
    	
        //Color map
        for(int y = 0; y < _columns; y++){
            for(int x = 0; x < _rows; x++){
                Tile tile = new Tile(x, y);
                tile.setSize(_windowSize, _windowSize);
                tile.setLocation((x*_windowSize)+23, (y*_windowSize)+25);
                if(_map[x][y] == 0){
                    tile.setBackground(Color.green);
                }else{
                    tile.setBackground(Color.LIGHT_GRAY);
                    tile.setWall(false);
                    if(x == 0){
                    	_player.setLocation((x*_windowSize)+23, (y*_windowSize)+25);
                    	_player._y = y;
                    	player2.setLocation(500,325);
                    	player2._y = y;
                    }
                    if(x == _columns-1){
                    	_endLoc = y;
                    }
                    if(x == _columns+1){
                    	endloc2 = y;
                    }
                }
                
                tile.setVisible(true);
                this.add(tile);
            }
        }
        this.setVisible(true);
    }
    
    public static void main(String args[]){
    	new MainMenu();
    }
    
    public void loadMap(String str){
        try{
            BufferedReader br = new BufferedReader(new FileReader(str));
            StringBuilder sb = new StringBuilder();
            String line = br.readLine();

            while (line != null) {
                sb.append(line);
                sb.append(System.lineSeparator());
                line = br.readLine();
            }
            String mapStr = sb.toString();
            
            int counter = 0;
            for(int y = 0; y < _columns; y++){
                for(int x = 0; x < _rows; x++){
                    String mapChar = mapStr.substring(counter, counter+1);
                    if(!mapChar.equals("\r\n") && !mapChar.equals("\n")&& !mapChar.equals("\r")){
                        
                        _map[x][y] = Integer.parseInt(mapChar);
                    }else{
                        x--;
                        System.out.print(mapChar);
                    }
                    counter++;
                }
            }
        }catch(Exception e){
           
        }
    }
}
