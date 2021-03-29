
import minesweeper.domain.Node;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author lilja
 */
public class NodeTest {

    Node node;

    @Before
    public void setUp() {
        node = new Node(5, 8);
    }

    @Test
    public void nodeConstructorSetsCorrectYCoordinate() {
        assertEquals(5, node.getY());
    }

    @Test
    public void nodeConstructorSetsCorrectXCoordinate() {
        assertEquals(8, node.getX());
    }

    @Test
    public void nodeConstructorSetsCorrectDefaultValueForNode() {
        assertEquals(0, node.getValue());
    }

    @Test
    public void nodeConstructorSetsCorrectDefaultValueForIsMine() {
        assertEquals(false, node.getIsMine());
    }

}
