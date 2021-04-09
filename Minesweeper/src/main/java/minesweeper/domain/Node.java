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
     */
    public Node(int y, int x) {
        this.y = y;
        this.x = x;
        this.value = 0;
        this.isMine = false;
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

    public void setMine(boolean isMine) {
        this.isMine = isMine;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 89 * hash + this.y;
        hash = 89 * hash + this.x;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Node other = (Node) obj;
        if (this.y != other.y) {
            return false;
        }
        if (this.x != other.x) {
            return false;
        }
        return true;
    }
    
    

}
