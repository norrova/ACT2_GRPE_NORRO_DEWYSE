package sudoku;

import org.junit.Assert;
import org.junit.Test;

public class MathUtilsTest {
    @Test
    public void testIsNumberBetween() {
        Assert.assertTrue(MathUtils.isNumberBetween(1, 0, 2));
        Assert.assertTrue(MathUtils.isNumberBetween(1, 1, 1));
        Assert.assertTrue(MathUtils.isNumberBetween(1, -2, 3));
        Assert.assertFalse(MathUtils.isNumberBetween(1, 2, 3));
    }
}
