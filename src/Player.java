import java.awt.Color;
import javax.swing.JPanel;

/**
 * Created by Janine Jay, Melkis Espinal, Ian Jacobs and Ally Colisto
 */

public class Player extends JPanel{
	int _x, _y;
	
    public Player() {
    	this.setBackground(Color.BLUE);
    	this.setSize(Maze._windowSize, Maze._windowSize);
    }

    public void setColor(Color c){
    	this.setBackground(c);
    }
    
    public void moveLeft() {
    	if(_x > 0 && Maze._map[_x-1][_y] == 1){
	    	this.setLocation(this.getX()-25, this.getY());
	    	_x--;
    	}
    }

    public void moveRight() {
    	if(_x < Maze._columns-1 && Maze._map[_x+1][_y] == 1){
	    	this.setLocation(this.getX()+25, this.getY());
	    	_x++;
    	}
    }

    public void moveUp() {
    	if(_y > 0 && Maze._map[_x][_y-1] == 1){
	    	this.setLocation(this.getX(), this.getY()-25);
	    	_y--;
    	}
    }

    public void moveDown() {
    	if(_y < Maze._rows-1 && Maze._map[_x][_y+1] == 1){
	    	this.setLocation(this.getX(), this.getY()+25);
	    	_y++;
    	}
    }
}
