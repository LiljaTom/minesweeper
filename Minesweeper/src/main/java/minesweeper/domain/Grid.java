package minesweeper.domain;

import java.util.ArrayList;
import java.util.Random;

/**
 *  Contains and handles nodes
 * 
 * @author lilja
 */
public class Grid {

    private Node[][] nodeGrid;
    private ArrayList<Node> nodes, toShow;
    private int height, width;
    private boolean[][] visited;

    public Grid(int height, int width) {
        this.height = height;
        this.width = width;
        this.nodeGrid = new Node[height][width];
        this.visited = new boolean[height][width];
        this.nodes = new ArrayList<>();
        this.toShow = new ArrayList<>();

        initGrid();
    }

    /**
     * Initializes the grid
     */
    public void initGrid() {
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                Node node = new Node(y, x);
                this.nodeGrid[y][x] = node;
                this.nodes.add(node);
            }
        }
    }

    /**
     * Checks if given coordinate is in the grid
     *
     * @param y y coordinate
     * @param x x coordinate
     *
     * @return true if (x, y) coordinate in the grid
     */
    public boolean inGrid(int y, int x) {
        if (y < 0 || y >= height || x < 0 || x >= width) {
            return false;
        }
        return true;
    }

    /**
     * Checks if given coordinate contains mine
     *
     * @param y y coordinate
     * @param x x coordinate
     *
     * @return true if node in coordinate (x, y) is mine
     */
    public boolean isMine(int y, int x) {
        if (!inGrid(y, x)) {
            return false;
        }
        return this.nodeGrid[y][x].getIsMine();
    }

    public void setMine(int y, int x) {
        this.nodeGrid[y][x].setMine(true);
    }

    public void setValue(int y, int x, int value) {
        this.nodeGrid[y][x].setValue(value);
    }

    public int getValue(int y, int x) {
        return this.nodeGrid[y][x].getValue();
    }

    /**
     * Gets random node from node list and removes it.
     * So basicly performs pull.
     * 
     * @return random node
     */
    public Node getRandomNode() {
        Random rnd = new Random();
        int index = rnd.nextInt(this.nodes.size());

        Node randomNode = this.nodes.get(index);
        this.nodes.remove(randomNode);

        return randomNode;
    }

    /**
     * Fills grid with mines.
     * Uses getRandomNode() to make random nodes mine.
     * 
     * @param amount amount of mines we want to add to the grid.
     * 
     * @see minesweeper.domain.Grid#getRandomNode() 
     */
    public void fillGridWithMines(int amount) {
        for (int i = 0; i < amount; i++) {
            Node node = getRandomNode();
            setMine(node.getY(), node.getX());
        }
    }

    public int getMineCount() {
        int mineCount = 0;

        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                if (nodeGrid[y][x].getIsMine()) {
                    mineCount++;
                }
            }
        }

        return mineCount;
    }

    public ArrayList<Node> getNodesToShow(int y, int x) {
        this.toShow = new ArrayList<>();

        search(y, x);

        return toShow;
    }

    /**
     * Finds adjacent empty nodes and their neighbouring nodes
     * 
     * method for GUI
     * 
     * @param y y coordinate
     * @param x x coordinate
     */
    public void search(int y, int x) {

        if (!inGrid(y, x) || visited[y][x]) {
            return;
        }
        this.visited[y][x] = true;

        if (this.nodeGrid[y][x].getIsMine()) {
            return;
        }

        if (this.nodeGrid[y][x].getValue() != 0) {
            this.toShow.add(new Node(y, x));

            return;
        }

        this.toShow.add(new Node(y, x));

        for (int ry = (y - 1); ry < (y + 2); ry++) {
            for (int rx = (x - 1); rx < (x + 2); rx++) {
                search(ry, rx);
            }
        }
    }

    /**
     * Counts how many mines there are next to given coordinates
     *
     * @param y y coordinate
     * @param x x coordinate
     *
     * @return how many mines are next to given coordinate(x,y)
     */
    public int countNodeValue(int y, int x) {

        int mineCount = 0;

        for (int ry = (y - 1); ry <= (y + 1); ry++) {
            for (int rx = (x - 1); rx <= (x + 1); rx++) {
                if (inGrid(ry, rx) && isMine(ry, rx)) {
                    mineCount++;
                }
            }
        }

        return mineCount;
    }

    public ArrayList<Node> getNodes() {
        return nodes;
    }

}
