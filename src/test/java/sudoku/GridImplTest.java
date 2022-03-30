package sudoku;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class GridImplTest {
    private GrilleImpl gridImplementation;

    @Before
    public void setUp() throws Exception {
        gridImplementation = new GrilleImpl(new char[][] {
                { GrilleImpl.EMPTY, '2', '3', '4', '5', '6', '7', '8', '9' },
                { '4', '5', '6', '7', '8', '9', '1', '2', '3' },
                { '7', '8', '9', '1', '2', '3', '4', '5', '6' },
                { '9', '1', '2', '3', '4', '5', '6', '7', '8' },
                { '3', '4', '5', '6', '7', '8', '9', '1', '2' },
                { '6', '7', '8', '9', '1', '2', '3', '4', '5' },
                { '8', '9', '1', '2', '3', '4', '5', '6', '7' },
                { '2', '3', '4', '5', '6', '7', '8', '9', '1' },
                { '5', '6', '7', '8', '9', '1', '2', '3', '4' }
        });
    }

    @Test
    public void testGetGrid() {
        Assert.assertArrayEquals(new char[][] {
                { GrilleImpl.EMPTY, '2', '3', '4', '5', '6', '7', '8', '9' },
                { '4', '5', '6', '7', '8', '9', '1', '2', '3' },
                { '7', '8', '9', '1', '2', '3', '4', '5', '6' },
                { '9', '1', '2', '3', '4', '5', '6', '7', '8' },
                { '3', '4', '5', '6', '7', '8', '9', '1', '2' },
                { '6', '7', '8', '9', '1', '2', '3', '4', '5' },
                { '8', '9', '1', '2', '3', '4', '5', '6', '7' },
                { '2', '3', '4', '5', '6', '7', '8', '9', '1' },
                { '5', '6', '7', '8', '9', '1', '2', '3', '4' }
        }, this.gridImplementation.getGrid());
    }

    @Test
    public void testGetGridSize() {
        Assert.assertEquals(GridSizeEnum.NORMAL_GRID_SIZE.getValue(), this.gridImplementation.getDimension());
    }

    @Test
    public void testGetSubgridSize() {
        Assert.assertEquals(GridSizeEnum.NORMAL_SUBGRID_SIZE.getValue(), this.gridImplementation.getSubgridSize());
    }

    @Test
    public void testSetValue() {
        Assert.assertEquals(GrilleImpl.EMPTY, this.gridImplementation.getGrid()[0][0]);
        this.gridImplementation.setValue(0, 0, '1');
        Assert.assertEquals('1', this.gridImplementation.getGrid()[0][0]);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSetValueWithBadValue() {
        GrilleImpl grid = new GrilleImpl(new char[][] {
                { GrilleImpl.EMPTY, '2', '3', '4', '5', '6', '7', '8', '9' },
                { '4', '5', '6', '7', '8', '9', '1', '2', '3' },
                { '7', '8', '9', '1', '2', '3', '4', '5', '6' },
                { '9', '1', '2', '3', '4', '5', '6', '7', '8' },
                { '3', '4', '5', '6', '7', '8', '9', '1', '2' },
                { '6', '7', '8', '9', '1', '2', '3', '4', '5' },
                { '8', '9', '1', '2', '3', '4', '5', '6', '7' },
                { '2', '3', '4', '5', '6', '7', '8', '9', '1' },
                { '5', '6', '7', '8', '9', '1', '2', '3', '4' }
        });
        grid.setValue(0, 0, 'y');
        grid.setValue(0, 0, 'a');
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSetValueWithBadPosition() {
        GrilleImpl grid = new GrilleImpl(new char[][] {
                { GrilleImpl.EMPTY, '2', '3', '4', '5', '6', '7', '8', '9' },
                { '4', '5', '6', '7', '8', '9', '1', '2', '3' },
                { '7', '8', '9', '1', '2', '3', '4', '5', '6' },
                { '9', '1', '2', '3', '4', '5', '6', '7', '8' },
                { '3', '4', '5', '6', '7', '8', '9', '1', '2' },
                { '6', '7', '8', '9', '1', '2', '3', '4', '5' },
                { '8', '9', '1', '2', '3', '4', '5', '6', '7' },
                { '2', '3', '4', '5', '6', '7', '8', '9', '1' },
                { '5', '6', '7', '8', '9', '1', '2', '3', '4' }
        });
        grid.setValue(-1, -1, '1');
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSetValueWithNotUniqueNumber() {
        GrilleImpl grid = new GrilleImpl(new char[][] {
                { GrilleImpl.EMPTY, '2', '3', '4', '5', '6', '7', '8', '9' },
                { '4', '5', '6', '7', '8', '9', '1', '2', '3' },
                { '7', '8', '9', '1', '2', '3', '4', '5', '6' },
                { '9', '1', '2', '3', '4', '5', '6', '7', '8' },
                { '3', '4', '5', '6', '7', '8', '9', '1', '2' },
                { '6', '7', '8', '9', '1', '2', '3', '4', '5' },
                { '8', '9', '1', '2', '3', '4', '5', '6', '7' },
                { '2', '3', '4', '5', '6', '7', '8', '9', '1' },
                { '5', '6', '7', '8', '9', '1', '2', '3', '4' }
        });
        grid.setValue(0, 0, '2');
    }

    @Test
    public void testGetValue() {
        Assert.assertEquals(GrilleImpl.EMPTY, this.gridImplementation.getValue(0, 0));
        Assert.assertEquals('5', this.gridImplementation.getValue(1, 1));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetValueWithBadPositionX() {
        this.gridImplementation.getValue(-2, 1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetValueWithBadPositionY() {
        this.gridImplementation.getValue(2, -3);
    }

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

    @Test
    public void testAllowedCharacterInNormalSize() {
        Assert.assertArrayEquals(
                new char[] { '1', '2', '3', '4', '5', '6', '7', '8', '9' },
                GrilleImpl.NormalSizeAllowedCharacter);
    }

    @Test
    public void testAllowedCharacterInLargeSize() {
        Assert.assertArrayEquals(
                new char[] { '1', '2', '3', '4', '5', '6', '7', '8', '9', '0', 'a', 'b', 'c', 'd', 'e', 'f' },
                GrilleImpl.possible);
    }
}
