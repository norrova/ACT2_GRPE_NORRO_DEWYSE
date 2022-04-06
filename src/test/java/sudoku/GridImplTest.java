package sudoku;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class GridImplTest {

    /**
     * GrilleImpl instance.
     */
    private GrilleImpl gridImplementation;

    /**
     * Prepare data for tests.
     */
    @Before
    public void setUp() throws Exception {
        gridImplementation = new GrilleImpl(new char[][]{
                {GrilleImpl.EMPTY, '2', '3', '4', '5', '6', '7', '8', '9'},
                {'4', '5', '6', '7', '8', '9', '1', '2', '3'},
                {'7', '8', '9', '1', '2', '3', '4', '5', '6'},
                {'9', '1', '2', '3', '4', '5', '6', '7', '8'},
                {'3', '4', '5', '6', '7', '8', '9', '1', '2'},
                {'6', '7', '8', '9', '1', '2', '3', '4', '5'},
                {'8', '9', '1', '2', '3', '4', '5', '6', '7'},
                {'2', '3', '4', '5', '6', '7', '8', '9', '1'},
                {'5', '6', '7', '8', '9', '1', '2', '3', '4'}
        });
    }

    /**
     * Test constructor with bad size array.
     */
    @Test(expected = IllegalArgumentException.class)
    public void testWithBadSizeArray() {
        new GrilleImpl(new char[][]{
                {'X', '2', '3', '4', '5', '6', '7', '8', '9'}
        });
    }

    /**
     * Test constructor with bad characters in grid.
     */
    @Test(expected = IllegalArgumentException.class)
    public void testWithBadCharactersInGrid() {
        new GrilleImpl(new char[][]{
                {'X', '2', '3', '4', '5', '6', '7', '8', '9'},
                {'4', '5', '6', '7', '8', '9', '1', '2', '3'},
                {'7', '8', '9', '1', '2', '3', '4', '5', '6'},
                {'9', '1', '2', '3', '4', '5', '6', '7', '8'},
                {'3', '4', '5', '6', '7', '8', '9', '1', '2'},
                {'6', '7', '8', '9', '1', '2', '3', '4', '5'},
                {'8', '9', '1', '2', '3', '4', '5', '6', '7'},
                {'2', '3', '4', '5', '6', '7', '8', '9', '1'},
                {'5', '6', '7', '8', '9', '1', '2', '3', '4'}
        });
    }

    /**
     * Test getter grid.
     */
    @Test
    public void testGetGrid() {
        Assert.assertArrayEquals(new char[][]{
                {GrilleImpl.EMPTY, '2', '3', '4', '5', '6', '7', '8', '9'},
                {'4', '5', '6', '7', '8', '9', '1', '2', '3'},
                {'7', '8', '9', '1', '2', '3', '4', '5', '6'},
                {'9', '1', '2', '3', '4', '5', '6', '7', '8'},
                {'3', '4', '5', '6', '7', '8', '9', '1', '2'},
                {'6', '7', '8', '9', '1', '2', '3', '4', '5'},
                {'8', '9', '1', '2', '3', '4', '5', '6', '7'},
                {'2', '3', '4', '5', '6', '7', '8', '9', '1'},
                {'5', '6', '7', '8', '9', '1', '2', '3', '4'}
        }, this.gridImplementation.getGrid());
    }

    /**
     * Test getter grid size dimension.
     */
    @Test
    public void testGetGridSize() {
        Assert.assertEquals(
                GridSizeEnum.NORMAL_GRID_SIZE.getValue(),
                this.gridImplementation.getDimension());
    }

    /**
     * Test getter subgrid size.
     */
    @Test
    public void testGetSubgridSize() {
        Assert.assertEquals(
                GridSizeEnum.NORMAL_SUBGRID_SIZE.getValue(),
                this.gridImplementation.getSubgridSize());
    }

    /**
     * Test setter value.
     */
    @Test
    public void testSetValue() {
        Assert.assertEquals(
                GrilleImpl.EMPTY,
                this.gridImplementation.getGrid()[0][0]);
        this.gridImplementation.setValue(0, 0, '1');
        Assert.assertEquals(
                '1',
                this.gridImplementation.getGrid()[0][0]);
    }

    /**
     * Test setter with bad value.
     */
    @Test(expected = IllegalArgumentException.class)
    public void testSetValueWithBadValue() {
        GrilleImpl grid = new GrilleImpl(new char[][]{
                {GrilleImpl.EMPTY, '2', '3', '4', '5', '6', '7', '8', '9'},
                {'4', '5', '6', '7', '8', '9', '1', '2', '3'},
                {'7', '8', '9', '1', '2', '3', '4', '5', '6'},
                {'9', '1', '2', '3', '4', '5', '6', '7', '8'},
                {'3', '4', '5', '6', '7', '8', '9', '1', '2'},
                {'6', '7', '8', '9', '1', '2', '3', '4', '5'},
                {'8', '9', '1', '2', '3', '4', '5', '6', '7'},
                {'2', '3', '4', '5', '6', '7', '8', '9', '1'},
                {'5', '6', '7', '8', '9', '1', '2', '3', '4'}
        });
        grid.setValue(0, 0, 'y');
        grid.setValue(0, 0, 'a');
    }

    /**
     * Test set value with bad position.
     */
    @Test(expected = IllegalArgumentException.class)
    public void testSetValueWithBadPosition() {
        GrilleImpl grid = new GrilleImpl(new char[][]{
                {GrilleImpl.EMPTY, '2', '3', '4', '5', '6', '7', '8', '9'},
                {'4', '5', '6', '7', '8', '9', '1', '2', '3'},
                {'7', '8', '9', '1', '2', '3', '4', '5', '6'},
                {'9', '1', '2', '3', '4', '5', '6', '7', '8'},
                {'3', '4', '5', '6', '7', '8', '9', '1', '2'},
                {'6', '7', '8', '9', '1', '2', '3', '4', '5'},
                {'8', '9', '1', '2', '3', '4', '5', '6', '7'},
                {'2', '3', '4', '5', '6', '7', '8', '9', '1'},
                {'5', '6', '7', '8', '9', '1', '2', '3', '4'}
        });
        grid.setValue(-1, -1, '1');
    }

    /**
     * Test set value with no unique number in row.
     */
    @Test(expected = IllegalArgumentException.class)
    public void testSetValueWithNotUniqueNumber() {
        GrilleImpl grid = new GrilleImpl(new char[][]{
                {GrilleImpl.EMPTY, '2', '3', '4', '5', '6', '7', '8', '9'},
                {'4', '5', '6', '7', '8', '9', '1', '2', '3'},
                {'7', '8', '9', '1', '2', '3', '4', '5', '6'},
                {'9', '1', '2', '3', '4', '5', '6', '7', '8'},
                {'3', '4', '5', '6', '7', '8', '9', '1', '2'},
                {'6', '7', '8', '9', '1', '2', '3', '4', '5'},
                {'8', '9', '1', '2', '3', '4', '5', '6', '7'},
                {'2', '3', '4', '5', '6', '7', '8', '9', '1'},
                {'5', '6', '7', '8', '9', '1', '2', '3', '4'}
        });
        grid.setValue(0, 0, '2');
    }

    /**
     * Test get value.
     */
    @Test
    public void testGetValue() {
        Assert.assertEquals(
                GrilleImpl.EMPTY,
                this.gridImplementation.getValue(0, 0));
        Assert.assertEquals(
                '5',
                this.gridImplementation.getValue(1, 1));
    }

    /**
     * Test get value with bad negative X.
     */
    @Test(expected = IllegalArgumentException.class)
    public void testGetValueWithBadPositionX() {
        this.gridImplementation.getValue(-2, 1);
    }

    /**
     * Test get value with bad negative Y.
     */
    @Test(expected = IllegalArgumentException.class)
    public void testGetValueWithBadPositionY() {
        this.gridImplementation.getValue(2, -3);
    }

    /**
     * Test set value on sixteen array.
     */
    @Test
    public void testSetValueOnSixteenArray() {
        int length = GridSizeEnum.LARGE_GRID_SIZE.getValue();
        char[][] grid = new char[length][length];
        for (int y = 0; y < length; y++) {
            for (int x = 0; x < length; x++) {
                grid[y][x] = '@';
            }
        }

        GrilleImpl gridImplementationLargeSize = new GrilleImpl(grid);
        gridImplementationLargeSize.setValue(0, 0, '1');
        gridImplementationLargeSize.setValue(0, 0, 'a');
    }

    /**
     * Test set value on sixteen array.
     */
    @Test(expected = IllegalArgumentException.class)
    public void testSetValueOnSixteenArrayWithBadValue() {
        int length = GridSizeEnum.LARGE_GRID_SIZE.getValue();
        char[][] grid = new char[length][length];
        for (int y = 0; y < length; y++) {
            for (int x = 0; x < length; x++) {
                grid[y][x] = '@';
            }
        }

        GrilleImpl gridImplementationLargeSize = new GrilleImpl(grid);
        gridImplementationLargeSize.setValue(0, 0, 'i');
        gridImplementationLargeSize.setValue(0, 0, 'z');
    }

    /**
     * Test allowed characters in normal size 9x9.
     */
    @Test
    public void testAllowedCharacterInNormalSize() {
        Assert.assertArrayEquals(
                new char[]{'1', '2', '3', '4', '5', '6', '7', '8', '9'},
                GrilleImpl.NORMAL_SIZE_ALLOWED_CHARACTER);
    }

    /**
     * Test allowed characters in large size 16x16.
     */
    @Test
    public void testAllowedCharacterInLargeSize() {
        Assert.assertArrayEquals(
                new char[]
                        {'1', '2', '3', '4', '5', '6', '7',
                                '8', '9', '0', 'a', 'b', 'c', 'd', 'e', 'f'},
                GrilleImpl.DEFAULT_CHARACTERS);
    }

    /**
     * Test possible location.
     */
    @Test
    public void testPossibleWithEmptyPlace() {
        Assert.assertTrue(
                this.gridImplementation.possible(0, 0, Grille.EMPTY));
    }

    /**
     * Test complete grid.
     */
    @Test
    public void testComplete() {
        GrilleImpl grid = new GrilleImpl(new char[][]{
                {'1', '2', '3', '4', '5', '6', '7', '8', '9'},
                {'4', '5', '6', '7', '8', '9', '1', '2', '3'},
                {'7', '8', '9', '1', '2', '3', '4', '5', '6'},
                {'9', '1', '2', '3', '4', '5', '6', '7', '8'},
                {'3', '4', '5', '6', '7', '8', '9', '1', '2'},
                {'6', '7', '8', '9', '1', '2', '3', '4', '5'},
                {'8', '9', '1', '2', '3', '4', '5', '6', '7'},
                {'2', '3', '4', '5', '6', '7', '8', '9', '1'},
                {'5', '6', '7', '8', '9', '1', '2', '3', '4'}
        });
        Assert.assertTrue(grid.complete());
    }
}
