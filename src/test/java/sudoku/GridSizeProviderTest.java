package sudoku;

import org.junit.Assert;
import org.junit.Test;

public class GridSizeProviderTest {
    @Test
    public void testProvide() {
        Assert.assertEquals(GridSizeEnum.NORMAL_GRID_SIZE, GridSizeProvider.provide(9));
        Assert.assertEquals(GridSizeEnum.LARGE_GRID_SIZE, GridSizeProvider.provide(16));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testProvideUnsupportedLength() {
        GridSizeProvider.provide(2);
    }
}
