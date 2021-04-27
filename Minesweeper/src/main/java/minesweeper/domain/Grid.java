package minesweeper.domain;

//import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Random;

/**
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

    public Node getRandomNode() {
        Random rnd = new Random();
        int index = rnd.nextInt(this.nodes.size());

        Node randomNode = this.nodes.get(index);
        this.nodes.remove(randomNode);

        return randomNode;
    }

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

    //DFs search
    public void search(int y, int x) {

        if (!inGrid(y, x) || visited[y][x]) {
            return;
        }
        this.visited[y][x] = true;

        if (this.nodeGrid[y][x].getValue() != 0 || this.nodeGrid[y][x].getIsMine()) {
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
        int upY = y - 1;
        int downY = y + 1;
        int rightX = x + 1;
        int leftX = x - 1;

        int mineCount = 0;

        //top
        if (inGrid(upY, x) && isMine(upY, x)) {
            mineCount++;
        }

        //top-right
        if (inGrid(upY, rightX) && isMine(upY, rightX)) {
            mineCount++;
        }

        //top-left
        if (inGrid(upY, leftX) && isMine(upY, leftX)) {
            mineCount++;
        }

        //down-right
        if (inGrid(downY, rightX) && isMine(downY, rightX)) {
            mineCount++;
        }

        //down-left
        if (inGrid(downY, leftX) && isMine(downY, leftX)) {
            mineCount++;
        }

        //down
        if (inGrid(downY, x) && isMine(downY, x)) {
            mineCount++;
        }

        //right
        if (inGrid(y, rightX) && isMine(y, rightX)) {
            mineCount++;
        }

        //left
        if (inGrid(y, leftX) && isMine(y, leftX)) {
            mineCount++;
        }

        return mineCount;
    }

    public ArrayList<Node> getNodes() {
        return nodes;
    }

}
