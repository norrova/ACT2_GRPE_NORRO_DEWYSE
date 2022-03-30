package sudoku;

import org.junit.Assert;
import org.junit.Test;

public class GridSubgridSizeProviderTest {
    @Test
    public void testProvide() {
        Assert.assertEquals(GridSizeEnum.NORMAL_SUBGRID_SIZE, GridSubgridSizeProvider.provide(9));
        Assert.assertEquals(GridSizeEnum.LARGE_SUBGRID_SIZE, GridSubgridSizeProvider.provide(16));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testProvideUnsupportedLength() {
        GridSubgridSizeProvider.provide(2);
    }
}
