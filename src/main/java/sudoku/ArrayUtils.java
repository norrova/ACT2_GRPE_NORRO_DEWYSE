package sudoku;

/**
 * Array utils class.
 */
public final class ArrayUtils {

    /**
     * Constructor.
     */
    private ArrayUtils() {
    }

    /**
     * concatenation of several arrays.
     * @param arrays
     * @return arrays concatenated
     */
    public static char[] concat(final char[]... arrays) {
        int length = 0;
        for (char[] array : arrays) {
            length += array.length;
        }
        char[] output = new char[length];
        int index = 0;
        for (char[] array : arrays) {
            for (int i = 0; i < array.length; i++) {
                output[index] = array[i];
                ++index;
            }
        }
        return output;
    }
}
