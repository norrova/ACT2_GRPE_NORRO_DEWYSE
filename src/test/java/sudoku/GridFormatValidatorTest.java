package sudoku;

import org.junit.Assert;
import org.junit.Test;

public class GridFormatValidatorTest {

    /**
     * Assert valid format of an array in two-dimensional.
     */
    @Test
    public void testIsValidFormatTwoDimensionArray() {
        char[][] grid = new char[][]{
                {'1', '2', '3', '4', '5', '6', '7', '8', '9'},
                {'4', '5', '6', '7', '8', '9', '1', '2', '3'},
                {'7', '8', '9', '1', '2', '3', '4', '5', '6'},
                {'9', '1', '2', '3', '4', '5', '6', '7', '8'},
                {'3', '4', '5', '6', '7', '8', '9', '1', '2'},
                {'6', '7', '8', '9', '1', '2', '3', '4', '5'},
                {'8', '9', '1', '2', '3', '4', '5', '6', '7'},
                {'2', '3', '4', '5', '6', '7', '8', '9', '1'},
                {'5', '6', '7', '8', '9', '1', '2', '3', '4'}
        };

        char[] availableCharacters = new char[]
                {'1', '2', '3', '4', '5', '6', '7', '8', '9'};

        Assert.assertTrue(
                GridFormatValidator.isValidFormat(grid, availableCharacters)
        );

        grid[0][0] = 'X';
        Assert.assertFalse(
                GridFormatValidator.isValidFormat(grid, availableCharacters)
        );
    }

    /**
     * Assert bad format for an invalid array.
     */
    @Test
    public void testIsValidFormatWithInvalidTwoDimensionSizeArray() {
        char[][] grid = new char[][]{
                {'1', '2', '3', '4', '5', '6', '7', '8', '9'}
        };

        char[] availableCharacters = new char[]
                {'1', '2', '3', '4', '5', '6', '7', '8', '9'};

        Assert.assertFalse(
                GridFormatValidator.isValidFormat(
                        grid,
                        availableCharacters)
        );
    }

    /**
     * Assert bad format children size array.
     */
    @Test
    public void testIsValidFormatWithBadUniformArray() {
        char[][] grid = new char[][]{
                {'1', '2', '3', '4', '5', '6', '7'},
                {'4', '5', '6', '7', '8', '9', '1', '2', '3'},
                {'7', '8', '9', '1', '2', '3', '4', '5', '6'},
                {'9', '1', '2', '3', '4', '5', '6', '7', '8'},
                {'3', '4', '5', '6', '7', '8', '9', '1', '2'},
                {'6', '7', '8', '9', '1', '2', '3', '4', '5'},
                {'8', '9', '1', '2', '3', '4', '5', '6', '7'},
                {'2', '3', '4', '5', '6', '7', '8', '9', '1'},
                {'5', '6', '7', '8', '9', '1', '2', '3', '4'}
        };

        char[] availableCharacters = new char[]
                {'1', '2', '3', '4', '5', '6', '7', '8', '9'};
        Assert.assertFalse(GridFormatValidator.isValidFormat(
                grid,
                availableCharacters)
        );
    }

    /**
     * Assert valid format (length + characters) in array.
     */
    @Test
    public void testIsValidFormat() {
        char[] grid = new char[]{'1', '2', '3', '4', '5', '6', '7', '8', '9'};
        char[] availableCharacters = new char[]
                {'1', '2', '3', '4', '5', '6', '7', '8', '9'};

        Assert.assertTrue(
                GridFormatValidator.isValidFormat(
                        grid,
                        availableCharacters)
        );
    }

    /**
     * Assert bad format length.
     */
    @Test
    public void testIsValidFormatWithBadDimensionArray() {
        char[] grid = new char[]{'1', '2', '3', '4', '5', '6', '7', '8'};
        char[] availableCharacters = new char[]
                {'1', '2', '3', '4', '5', '6', '7', '8', '9'};

        Assert.assertFalse(
                GridFormatValidator.isValidFormat(
                        grid,
                        availableCharacters)
        );
    }

    /**
     * Assert that the array and sub-arrays are of equal length.
     */
    @Test
    public void testIsUniformTwoDimensionArray() {
        char[][] grid = new char[][]{
                {'1', '2', '3', '4', '5', '6', '7', '8', '9'},
                {'4', '5', '6', '7', '8', '9', '1', '2', '3'},
                {'7', '8', '9', '1', '2', '3', '4', '5', '6'},
                {'9', '1', '2', '3', '4', '5', '6', '7', '8'},
                {'3', '4', '5', '6', '7', '8', '9', '1', '2'},
                {'6', '7', '8', '9', '1', '2', '3', '4', '5'},
                {'8', '9', '1', '2', '3', '4', '5', '6', '7'},
                {'2', '3', '4', '5', '6', '7', '8', '9', '1'},
                {'5', '6', '7', '8', '9', '1', '2', '3', '4'}
        };

        Assert.assertTrue(GridFormatValidator.isUniform(grid));
    }

    /**
     * Assert not equals length between parent and children.
     */
    @Test
    public void testIsUniformWithBadTwoDimensionArray() {
        char[][] grid = new char[][]{
                {'1', '2', '3', '4', '5', '6', '7', '8', '9'},
        };

        Assert.assertFalse(GridFormatValidator.isUniform(grid));
    }

    /**
     * Ensure that the size of the tables are
     * uniform between the parent and child tables.
     */
    @Test
    public void testIsUniform() {
        char[][] grid = new char[][]{
                {'1'},
        };

        Assert.assertTrue(GridFormatValidator.isUniform(grid));
    }

    /**
     * Test that the size of the parent
     * is different from the size of the child array.
     */
    @Test
    public void testIsUniformWithBadDimensionArray() {
        char[][] grid = new char[][]{
                {'1', '2'},
        };

        Assert.assertFalse(GridFormatValidator.isUniform(grid));
    }

    /**
     * Check that an array size is valid.
     */
    @Test
    public void testIsValidSize() {
        Assert.assertTrue(GridFormatValidator.isValidSize(
                GridSizeEnum.NORMAL_GRID_SIZE.getValue()));
        Assert.assertTrue(GridFormatValidator.isValidSize(
                GridSizeEnum.LARGE_GRID_SIZE.getValue()));
        Assert.assertFalse(GridFormatValidator.isValidSize(12));
        Assert.assertFalse(GridFormatValidator.isValidSize(2));
    }
}
