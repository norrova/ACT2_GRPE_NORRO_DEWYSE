package sudoku;

import java.util.Arrays;
import java.util.stream.Stream;

public class ArrayUtils {
    public static char[] concat(char[]... arrays) {
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
