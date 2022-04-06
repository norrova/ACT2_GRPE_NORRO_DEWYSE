package sudoku;

import org.junit.Assert;
import org.junit.Test;

public class MathUtilsTest {
    /**
     * Test if a number is between min and max.
     */
    @Test
    public void testIsNumberBetween() {
        Assert.assertTrue(MathUtils.isNumberBetween(1, 0, 2));
        Assert.assertTrue(MathUtils.isNumberBetween(1, 1, 1));
        Assert.assertTrue(MathUtils.isNumberBetween(1, -2, 3));
        Assert.assertTrue(MathUtils.isNumberBetween(-2, -5, -1));
        Assert.assertFalse(MathUtils.isNumberBetween(1, 2, 3));
    }
}
