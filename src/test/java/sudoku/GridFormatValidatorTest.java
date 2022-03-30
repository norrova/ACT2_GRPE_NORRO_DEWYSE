package sudoku;

import org.junit.Assert;
import org.junit.Test;

public class GridFormatValidatorTest {
    @Test
    public void testIsValidFormatTwoDimensionArray() {
        char[][] grid = new char[][] {
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

        char[] availableCharacters = new char[] { '1', '2', '3', '4', '5', '6', '7', '8', '9' };

        Assert.assertTrue(GridFormatValidator.isValidFormat(grid, availableCharacters));

        grid[0][0] = '@';
        Assert.assertFalse(GridFormatValidator.isValidFormat(grid, availableCharacters));
    }

    @Test
    public void testIsValidFormatWithBadTwoDimensionArray() {
        char[][] grid = new char[][] {
                { '1', '2', '3', '4', '5', '6', '7', '8', '9' }
        };

        char[] availableCharacters = new char[] { '1', '2', '3', '4', '5', '6', '7', '8', '9' };

        Assert.assertFalse(GridFormatValidator.isValidFormat(grid, availableCharacters));
    }

    @Test
    public void testIsValidFormat() {
        char[] grid = new char[] { '1', '2', '3', '4', '5', '6', '7', '8', '9' };
        char[] availableCharacters = new char[] { '1', '2', '3', '4', '5', '6', '7', '8', '9' };

        Assert.assertTrue(GridFormatValidator.isValidFormat(grid, availableCharacters));
    }

    @Test
    public void testIsValidFormatWithBadDimensionArray() {
        char[] grid = new char[] { '1', '2', '3', '4', '5', '6', '7', '8' };
        char[] availableCharacters = new char[] { '1', '2', '3', '4', '5', '6', '7', '8', '9' };

        Assert.assertFalse(GridFormatValidator.isValidFormat(grid, availableCharacters));
    }

    @Test
    public void testIsUniformTwoDimensionArray() {
        char[][] grid = new char[][] {
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

        Assert.assertTrue(GridFormatValidator.isUniform(grid));
    }

    @Test
    public void testIsUniformWithBadTwoDimensionArray() {
        char[][] grid = new char[][] {
                { '1', '2', '3', '4', '5', '6', '7', '8', '9' },
        };

        Assert.assertFalse(GridFormatValidator.isUniform(grid));
    }

    @Test
    public void testIsUniform() {
        char[][] grid = new char[][] {
                { '1' },
        };

        Assert.assertTrue(GridFormatValidator.isUniform(grid));
    }

    @Test
    public void testIsUniformWithBadDimensionArray() {
        char[][] grid = new char[][] {
                { '1', '2' },
        };

        Assert.assertFalse(GridFormatValidator.isUniform(grid));
    }

    @Test
    public void testIsValidSize() {
        Assert.assertTrue(GridFormatValidator.isValidSize(GridSizeEnum.NORMAL_GRID_SIZE.getValue()));
        Assert.assertTrue(GridFormatValidator.isValidSize(GridSizeEnum.LARGE_GRID_SIZE.getValue()));
        Assert.assertFalse(GridFormatValidator.isValidSize(12));
        Assert.assertFalse(GridFormatValidator.isValidSize(2));
    }
}
