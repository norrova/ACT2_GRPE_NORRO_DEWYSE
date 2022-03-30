package sudoku;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class GridValidatorTest {

    private char[][] validGrid;

    @Before
    public void setUp() {
        this.validGrid = new char[][] {
                { '1', '2', '3', '4', '5', '6', '7', '8', '9' },
                { '4', '5', '6', '7', '8', '9', '1', '2', '3' },
                { '7', '8', '9', '1', '2', '3', '4', '5', '6' },
                { '9', '1', '2', '3', '4', '5', '6', '7', '8' },
                { '3', '4', '5', '6', '7', '8', '9', '1', '2' },
                { '6', '7', '8', '9', '1', '2', '3', '4', '5' },
                { '8', '9', '1', '2', '3', '4', '5', '6', '7' },
                { '2', '3', '4', '5', '6', '7', '8', '9', '1' },
                { '5', '6', '7', '8', '9', '1', '2', '3', '4' }
        };
    }

    @Test()
    public void testValidWithValidGrid() {
        Assert.assertTrue(GridValidator.valid(this.validGrid));
    }

    @Test()
    public void testValidWithBadGrid() {
        char[][] grid = new char[][] {
                { '4', '4', '5', '2', '6', '9', '7', '8', '1' },
                { '6', '8', '2', '5', '7', '1', '4', '9', '3' },
                { '1', '9', '7', '8', '3', '2', '5', '6', '2' },
                { '8', '2', '6', '1', '9', '5', '3', '4', '7' },
                { '3', '7', '4', '6', '8', '2', '9', '1', '5' },
                { '1', '5', '9', '7', '4', '3', '6', '2', '8' },
                { '5', '1', '9', '3', '2', '6', '8', '7', '4' },
                { '2', '4', '8', '9', '5', '7', '1', '3', '6' },
                { '7', '6', '3', '4', '1', '8', '2', '5', '9' }
        };

        Assert.assertFalse(GridValidator.valid(grid));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testValidWithBadFormat() {
        char[][] grid = new char[][] {
                { '1', '2' },
        };

        GridValidator.valid(grid);
    }

    @Test
    public void testIsValidValueAccordingToGrid() {
        char[][] grid = new char[][] {
                { '@', '2', '3', '4', '5', '6', '7', '8', '9' },
                { '4', '5', '6', '7', '8', '9', '1', '2', '3' },
                { '7', '8', '9', '1', '2', '3', '4', '5', '6' },
                { '9', '1', '2', '3', '4', '5', '6', '7', '8' },
                { '3', '4', '5', '6', '7', '8', '9', '1', '2' },
                { '6', '7', '8', '9', '1', '2', '3', '4', '5' },
                { '8', '9', '1', '2', '3', '4', '5', '6', '7' },
                { '2', '3', '4', '5', '6', '7', '8', '9', '1' },
                { '5', '6', '7', '8', '9', '1', '2', '3', '4' }
        };

        Assert.assertTrue(GridValidator.isValidValueAccordingToGrid(grid, 0, 0, '1'));
        Assert.assertFalse(GridValidator.isValidValueAccordingToGrid(grid, 0, 0, '2'));
    }

    @Test
    public void testValueExistsInRow() {
        Assert.assertTrue(GridValidator.valueExistsInRow(this.validGrid, 0, 0, '2'));
        Assert.assertFalse(GridValidator.valueExistsInRow(this.validGrid, 0, 0, '@'));
    }

    @Test
    public void testValueExistsInColumn() {
        Assert.assertTrue(GridValidator.valueExistsInColumn(this.validGrid, 0, 0, '2'));
        Assert.assertFalse(GridValidator.valueExistsInColumn(this.validGrid, 0, 0, '@'));
    }

    @Test
    public void testValueExistsInSubgrid() {
        Assert.assertTrue(GridValidator.valueExistsInSubgrid(this.validGrid, 1, 1, '1'));
        Assert.assertFalse(GridValidator.valueExistsInSubgrid(this.validGrid, 0, 0, '@'));
    }
}
