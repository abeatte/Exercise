package com.artbeatte.exercises.memorygame;

import com.artbeatte.exercises.test.Repeat;
import com.artbeatte.exercises.test.RepeatRule;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

/**
 * @author csarbora
 * @version 1/22/16
 */
public class MemoryGameSolverTest {
    private static final int WIDTH = 5;
    private static final int HEIGHT = 6;
    private static final int TEST_RUNS = 1000;

    private static final Solver SOLVER = new MemoryGameSolver();

    private MemoryGameBoard mBoard;

    @Rule public final RepeatRule REPEAT = new RepeatRule();

    @Before
    public void setUp() throws Exception {
        mBoard = new MemoryGameBoard(WIDTH, HEIGHT);
    }

    @Test
    public void testSolvesBoard() throws Exception {
        SOLVER.solve(mBoard);
        assertTrue(mBoard.isGameOver());
    }

    @Test
    @Repeat(times = TEST_RUNS)
    public void testBeatsNaiveImpl() throws Exception {
        testSolvesBoard();

        int maxNaiveFlips = 0;
        for (int i = WIDTH * HEIGHT; i > 0; i -= 2) {
            maxNaiveFlips += (i - 1) * 2;
        }
        assertTrue(mBoard.getTotalFlips() < maxNaiveFlips);
    }

    @Test
    @Repeat(times = TEST_RUNS)
    public void testDoesntCheat() throws Exception {
        testSolvesBoard();

        assertTrue(mBoard.getTotalFlips() >= WIDTH * HEIGHT);
    }
}
