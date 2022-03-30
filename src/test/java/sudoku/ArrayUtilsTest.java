package sudoku;

import org.junit.Assert;
import org.junit.Test;

public class ArrayUtilsTest {
    @Test
    public void testConcat() {
        char[] array1 = new char[] { '1' };
        char[] array2 = new char[] { '2' };
        char[] expected = new char[] { '1', '2' };
        Assert.assertArrayEquals(expected, ArrayUtils.concat(array1, array2));
        Assert.assertArrayEquals(array1, ArrayUtils.concat(array1));
    }
}
