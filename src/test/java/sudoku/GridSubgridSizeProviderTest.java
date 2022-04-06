package sudoku;

import org.junit.Assert;
import org.junit.Test;

public class GridSubgridSizeProviderTest {
    /**
     * Test provider with valid length.
     */
    @Test
    public void testProvide() {
        Assert.assertEquals(
                GridSizeEnum.NORMAL_SUBGRID_SIZE,
                GridSubgridSizeProvider.provide(9)
        );
        Assert.assertEquals(
                GridSizeEnum.LARGE_SUBGRID_SIZE,
                GridSubgridSizeProvider.provide(16)
        );
    }

    /**
     * Test provider with invalid length.
     */
    @Test(expected = IllegalArgumentException.class)
    public void testProvideUnsupportedLength() {
        GridSubgridSizeProvider.provide(2);
    }
}
