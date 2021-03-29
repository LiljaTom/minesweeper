
package minesweeper.domain;

/**
 *
 * @author lilja
 */
public class Board {
    private Node[][] nodes;
    private int height, width;

    public Board(int height, int width) {
        this.nodes = new Node[height][width];
        this.height = height;
        this.width = width;
    }
    

    public void initBoard() {
        for(int y = 0; y < height; y++) {
            for(int x = 0; x < width; x++) {
                this.nodes[y][x] = new Node(y, x);
            }
        }
    }
    

    public void setMine(int y, int x) {
        this.nodes[y][x].setMine(true);
    }
    
    public boolean isMine(int y, int x) {
        return this.nodes[y][x].getIsMine();
    }
    
    public void setValue(int y, int x, int value) {
        this.nodes[y][x].setValue(value);
    }
    
    public void getValue(int y, int x) {
        this.nodes[y][x].getValue();
    }
    
    
    
    
    
    
}
