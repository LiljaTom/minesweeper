
package minesweeper.domain;

import java.util.ArrayList;

/**
 *
 * @author lilja
 */
public class GameService {
    
    private DifficultyLevel difficulty;
    private Board board;

    public GameService(String difficulty) {
        this.difficulty = new DifficultyLevel(difficulty);
        this.difficulty.initDifficulty();
        this.board = new Board(this.difficulty.getHeight(), this.difficulty.getWidth(), this.difficulty.getMines());
        this.board.buildBoard();
    }
    
    /*
    public void startGame() {
        this.difficulty.initDifficulty();
        this.board = new Board(this.difficulty.getHeight(), this.difficulty.getWidth(), this.difficulty.getMines());
        this.board.buildBoard();
    }
    */
            
    public String getStatus(int y, int x) {
        return this.board.getStatus(y, x);
    }
    
    public int getHeight() {
        return this.difficulty.getHeight();
    }
    
    public int getWidth() {
        return this.difficulty.getWidth();
    }
    
    public ArrayList<Node> adjacentEmpties(int y, int x) {
        return this.board.newEmpties(y, x);
    }
    
    
    
}
