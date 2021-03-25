package minesweeper.domain;

/**
 *  Gameboards smallest individual building block.
 * 
 * @author lilja
 */
public class Node {

    private int y, x;
    private int value;
    private boolean isMine;

    /**
     * Constructor for node.
     * Value shows how many mines there is next to this node
     *
     * @param y Node's y coordinate
     * @param x Node's x coordinate
     * @param isMine True if node is mine
     */
    public Node(int y, int x, boolean isMine) {
        this.y = y;
        this.x = x;
        this.value = 0;
        this.isMine = isMine;
    }

    public int getY() {
        return y;
    }

    public int getX() {
        return x;
    }

    public int getValue() {
        return value;
    }

    public boolean getIsMine() {
        return isMine;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public void setIsMine(boolean isMine) {
        this.isMine = isMine;
    }

}
