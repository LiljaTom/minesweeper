
import minesweeper.domain.DifficultyLevel;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author lilja
 */
public class DifficultyLevelTest {

    private DifficultyLevel easy;
    private DifficultyLevel medium;
    private DifficultyLevel hard;
    private DifficultyLevel custom;

    @Before
    public void setUp() {
        this.easy = new DifficultyLevel("easy");
        this.medium = new DifficultyLevel("medium");
        this.hard = new DifficultyLevel("hard");
        this.custom = new DifficultyLevel("custom");
    }

    @Test
    public void initSetsCorrectMinesForEasy() {
        this.easy.initDifficulty();

        assertEquals(10, this.easy.getMines());
    }

    @Test
    public void initSetsCorrectMinesForMedium() {
        this.medium.initDifficulty();

        assertEquals(40, this.medium.getMines());
    }

    @Test
    public void initSetsCorrectMinesForHard() {
        this.hard.initDifficulty();

        assertEquals(99, this.hard.getMines());
    }

    @Test
    public void initSetsCorrectHeightForEasy() {
        this.easy.initDifficulty();

        assertEquals(10, this.easy.getHeight());
    }

    @Test
    public void initSetsCorrectWidthForEasy() {
        this.easy.initDifficulty();

        assertEquals(10, this.easy.getWidth());
    }

    @Test
    public void initSetsCorrectHeightForMedium() {
        this.medium.initDifficulty();

        assertEquals(18, this.medium.getHeight());
    }

    @Test
    public void initSetsCorrectWidthForMedium() {
        this.medium.initDifficulty();

        assertEquals(18, this.medium.getWidth());
    }

    @Test
    public void initSetsCorrectHeightForHard() {
        this.hard.initDifficulty();

        assertEquals(24, this.hard.getHeight());
    }

    @Test
    public void initSetsCorrectWidthForHard() {
        this.hard.initDifficulty();

        assertEquals(24, this.hard.getWidth());
    }
}
