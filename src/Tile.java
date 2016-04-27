import javax.swing.JPanel;

/**
 * Created by Janine Jay, Melkis Espinal, Ian Jacobs and Ally Colisto
 */

public class Tile extends JPanel{
    int _x, _y;
    boolean _isWall = true;
    
    public Tile(int x, int y){
        this._x = x;
        this._y = y;
    }
    
    public void setWall(boolean isWall){
        this._isWall = isWall;
    }
}