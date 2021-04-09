
import minesweeper.domain.Grid;
import minesweeper.domain.Node;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author lilja
 */
public class GridTest {

    private Grid grid;

    @Before
    public void setUp() {
        this.grid = new Grid(10, 10);
    }

    @Test
    public void inGridReturnsTrueIfCoordinatesInGrid() {
        assertTrue(grid.inGrid(9, 0));
    }

    @Test
    public void inGridReturnFalseIfYUnderZero() {
        assertFalse(grid.inGrid(-1, 5));
    }

    @Test
    public void inGridReturnFalseIfYOverHeight() {
        assertFalse(grid.inGrid(11, 5));
    }

    @Test
    public void inGridReturnFalseIfXUnderZero() {
        assertFalse(grid.inGrid(5, -1));
    }

    @Test
    public void inGridReturnFalseIfXOverWidth() {
        assertFalse(grid.inGrid(5, 11));
    }
    
    @Test
    public void countNodeValuesReturnsZeroIfNoMinesNextToIt() {
        assertEquals(0, grid.countNodeValue(5, 5));
    }
    
    @Test
    public void countNodeValuesReturns8IfAllNeighboursMines() {
        grid.setMine(6, 5);
        grid.setMine(6, 4);
        grid.setMine(6, 6);
        grid.setMine(5, 4);
        grid.setMine(5, 6);
        grid.setMine(4, 5);
        grid.setMine(4, 4);
        grid.setMine(4, 6);
        
        assertEquals(8, grid.countNodeValue(5, 5));

    }
    
    @Test
    public void getRandomNodeRemovesChosenNodeFromList() {
        Node node = grid.getRandomNode();
        
        assertTrue(!grid.getNodes().contains(node));
    }
    
    @Test
    public void getRandomNodeReducesListSize() {
        grid.getRandomNode();
        
        assertEquals(99, grid.getNodes().size());
    }
    
    @Test
    public void setMineMakesCorrectNodeMine() {
        grid.setMine(5, 5);
        
        assertTrue(grid.isMine(5, 5));
    }
    
    @Test
    public void getMineCountReturnsCorrectCount() {
        grid.setMine(1, 1);
        grid.setMine(2, 1);
        grid.setMine(1, 2);
        
        assertEquals(3, grid.getMineCount());
    }
    
    @Test
    public void fillGridWithMinesMakesCorrectAmountOfMines() {
        grid.fillGridWithMines(25);

        assertEquals(25, grid.getMineCount());
    }
    
    

}
