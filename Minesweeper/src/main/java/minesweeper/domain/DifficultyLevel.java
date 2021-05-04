package minesweeper.domain;

/**
 * Class to handle difficulty settings
 * 
 * @author lilja
 */
public class DifficultyLevel {

    private String level;
    private int mines;
    private int height;
    private int width;

    public DifficultyLevel(String level) {
        this.level = level;
        this.mines = 0;
        this.height = 0;
        this.height = 0;
    }

    /**
     * Initializes difficulty.
     * 
     * Sets correct variable values to match difficulty level.
     * 
     */
    public void initDifficulty() {
        if (level.equals("easy")) {
            setMines(10);
            setHeight(10);
            setWidth(10);
        } else if (level.equals("medium")) {
            setMines(40);
            setHeight(18);
            setWidth(18);
        } else if (level.equals("hard")) {
            setMines(99);
            setHeight(24);
            setWidth(24);
        }
    }

    public void setMines(int mines) {
        this.mines = mines;
    }

    public int getMines() {
        return mines;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getHeight() {
        return height;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getWidth() {
        return width;
    }

}
