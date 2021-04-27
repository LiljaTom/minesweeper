
import java.util.ArrayList;
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

    @Test
    public void searchFindsAllEmptyNodesAdjacent1() {
        Grid search = new Grid(10, 10);
        search.setMine(3, 3);
        search.setMine(3, 4);
        search.setMine(3, 5);
        search.setMine(4, 3);
        search.setMine(4, 5);
        search.setMine(5, 3);
        search.setMine(5, 4);
        search.setMine(5, 5);

        assertEquals(1, search.getNodesToShow(4, 4).size());
    }

    @Test
    public void searchFindsAllEmptyNodesAdjacent2() {
        Grid search = new Grid(10, 10);
        search.setMine(3, 3);
        search.setMine(3, 4);
        search.setMine(3, 5);
        search.setMine(4, 2);
        search.setMine(4, 3);
        search.setMine(4, 5);
        search.setMine(4, 6);
        search.setMine(5, 2);
        search.setMine(5, 6);

        search.setMine(6, 2);
        search.setMine(6, 3);
        search.setMine(6, 5);
        search.setMine(6, 6);
        search.setMine(7, 3);
        search.setMine(7, 4);
        search.setMine(7, 5);

        assertEquals(5, search.getNodesToShow(4, 4).size());
    }

    @Test
    public void getNodesToShowRetunsCorrectNodes1() {
        Grid search = new Grid(10, 10);
        search.setMine(3, 3);
        search.setMine(3, 4);
        search.setMine(3, 5);
        search.setMine(4, 3);
        search.setMine(4, 5);
        search.setMine(5, 3);
        search.setMine(5, 4);
        search.setMine(5, 5);

        Node target = new Node(4, 4);

        assertTrue(search.getNodesToShow(4, 4).get(0).equals(target));
    }

    @Test
    public void getNodesToShowRetunsCorrectNodes2() {
        Grid search = new Grid(10, 10);
        search.setMine(3, 3);
        search.setMine(3, 4);
        search.setMine(3, 5);
        search.setMine(4, 2);
        search.setMine(4, 3);
        search.setMine(4, 5);
        search.setMine(4, 6);
        search.setMine(5, 2);
        search.setMine(5, 6);

        search.setMine(6, 2);
        search.setMine(6, 3);
        search.setMine(6, 5);
        search.setMine(6, 6);
        search.setMine(7, 3);
        search.setMine(7, 4);
        search.setMine(7, 5);
        
        ArrayList<Node> nodes = search.getNodesToShow(4, 4);
        
        boolean all = nodes.contains(new Node(4, 4)) && nodes.contains(new Node(5, 4)) &&  nodes.contains(new Node(6, 4)) && nodes.contains(new Node(5, 3)) && nodes.contains(new Node(5, 5));
        
        assertTrue(all);
    }

}
