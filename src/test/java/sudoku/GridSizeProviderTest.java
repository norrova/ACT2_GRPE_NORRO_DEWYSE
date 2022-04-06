package sudoku;

import org.junit.Assert;
import org.junit.Test;

public class GridSizeProviderTest {
    /**
     * Test provider with valid length.
     */
    @Test
    public void testProvide() {
        Assert.assertEquals(
                GridSizeEnum.NORMAL_GRID_SIZE, GridSizeProvider.provide(9)
        );
        Assert.assertEquals(
                GridSizeEnum.LARGE_GRID_SIZE, GridSizeProvider.provide(16)
        );
    }

    /**
     * Test provider with invalid length.
     */
    @Test(expected = IllegalArgumentException.class)
    public void testProvideUnsupportedLength() {
        GridSizeProvider.provide(2);
    }
}
