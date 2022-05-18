package sudoku;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class GridSolverTest {

    /**
     * Solver instance.
     */
    private GridSolver solver;

    /**
     * GrilleImpl instance.
     */
    private GrilleImpl grid;

    /**
     * Prepare data for tests.
     */
    @Before
    public void setUp() {
        this.grid = new GrilleImpl(new char[][]{
                {'9', '@', '@', '1', '@', '@', '@', '@', '5'},
                {'@', '@', '5', '@', '9', '@', '2', '@', '1'},
                {'8', '@', '@', '@', '4', '@', '@', '@', '@'},
                {'@', '@', '@', '@', '8', '@', '@', '@', '@'},
                {'@', '@', '@', '7', '@', '@', '@', '@', '@'},
                {'@', '@', '@', '@', '2', '6', '@', '@', '@'},
                {'2', '@', '@', '3', '@', '@', '@', '@', '6'},
                {'@', '@', '@', '2', '@', '@', '9', '@', '@'},
                {'@', '@', '1', '9', '@', '4', '5', '7', '@'}
        });

        this.solver = new GridSolver(this.grid);
    }

    /**
     * Test solver.
     */
    @Test
    public void testSolve() {
        this.solver.solve(0, 0);
        Assert.assertArrayEquals(
                new char[][]{
                    {'9', '3', '4', '1', '7', '2', '6', '8', '5'},
                    {'6', '7', '5', '8', '9', '3', '2', '4', '1'},
                    {'8', '1', '2', '6', '4', '5', '3', '9', '7'},
                    {'4', '2', '3', '5', '8', '1', '7', '6', '9'},
                    {'1', '5', '6', '7', '3', '9', '4', '2', '8'},
                    {'7', '9', '8', '4', '2', '6', '1', '5', '3'},
                    {'2', '4', '9', '3', '5', '7', '8', '1', '6'},
                    {'5', '6', '7', '2', '1', '8', '9', '3', '4'},
                    {'3', '8', '1', '9', '6', '4', '5', '7', '2'}
                },
                this.grid.getGrid()
        );
    }
}
