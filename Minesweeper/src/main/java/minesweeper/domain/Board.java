package minesweeper.domain;

import java.util.ArrayList;

/**
 * Class which handles grid and builds gameboard
 * 
 * @author lilja
 */
public class Board {

    private Grid grid;
    private int height, width, mines;
    private boolean[][] opened;

    public Board(int height, int width, int mines) {
        this.height = height;
        this.width = width;
        this.mines = mines;
        this.grid = new Grid(height, width);
        this.opened = new boolean[height][width];
    }

    /**
     * Builds board.
     * 
     * Fills grid with mines and counts node values.
     * 
     */
    public void buildBoard() {

        grid.fillGridWithMines(this.mines);

        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                if (!grid.isMine(y, x)) {
                    int value = grid.countNodeValue(y, x);
                    grid.setValue(y, x, value);
                }
            }
        }

    }

    public String getStatus(int y, int x) {
        if (grid.isMine(y, x)) {
            return "X";
        }
        return String.valueOf(grid.getValue(y, x));
    }
    
    public ArrayList<Node> newEmpties(int y, int x) {
        return this.grid.getNodesToShow(y, x);
    }

}
