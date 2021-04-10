

import minesweeper.domain.Board;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author lilja
 */
public class BoardTest {
    
    private Board board;
    
    @Before
    public void setUp() {
        this.board = new Board(5, 5, 15);
    }
    
    @Test
    public void buildBoardMakesCorrectAmountOfMines() {
        this.board.buildBoard();
        int count = 0;
        
        for(int y = 0; y < 5; y++) {
            for(int x = 0; x < 5; x++) {
                if(board.getStatus(y, x).equals("X")) {
                    count++;
                }
            }
        }
        
        assertEquals(15, count);
    }
    
}
