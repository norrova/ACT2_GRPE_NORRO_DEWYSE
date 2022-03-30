package sudoku;

import java.util.Arrays;

/**
 * Grid format validator class
 */
final public class GridFormatValidator {

    /**
     * Validates a two-dimensional array
     * of characters according to the allowed characters and checks if array is
     * uniform
     * 
     * @param grid two-dimensional character array
     * @param availableCharacter allowed characters in two-dimensional array
     * @return returns false if a character is not valid in the array
     *         or if the size of the children is not equal to the parent, otherwise
     *         true.
     */
    public static boolean isValidFormat(char[][] grid, char[] availableCharacter) {
        int parentLength = grid.length;

        if (!isValidSize(parentLength)) {
            return false;
        }

        for (int y = 0; y < parentLength; y++) {
            if (!isUniform(grid[y], parentLength)) {
                return false;
            }

            if (!isValidFormat(grid[y], availableCharacter)) {
                return false;
            }
        }

        return true;
    }

    /**
     * Validates a character array according to the allowed characters
     * 
     * @param row                character array
     * @param availableCharacter allowed characters in array
     * @return returns false if a character is not valid in the array otherwise true
     */
    public static boolean isValidFormat(char[] row, char[] availableCharacter) {
        int length = row.length;

        if (!isValidSize(length)) {
            return false;
        }

        for (int index = 0; index < length; index++) {
            if (!Arrays.toString(availableCharacter).contains("" + row[index])) {
                return false;
            }
        }

        return true;
    }

    /**
     * Checks if two-dimensional array of characters is uniform
     * 
     * @param grid two-dimensional character array
     * @return returns false if the size of the children is not equal to the parent,
     *         otherwise true.
     */
    public static boolean isUniform(char[][] grid) {
        int parentLength = grid.length;
        for (int y = 0; y < parentLength; y++) {
            if (!isUniform(grid[y], parentLength)) {
                return false;
            }
        }
        return true;
    }

    /**
     * Checks if array of characters is uniform to the parent length
     * 
     * @param row          character array
     * @param parentLength length of parent array
     * @return returns false if the size of the children is not equal to the parent,
     *         otherwise true.
     */
    private static boolean isUniform(char[] row, int parentLength) {
        return row.length == parentLength;
    }

    /**
     * Validates length of an element
     * 
     * @param length length element
     * @return returns false if the length is not equal to
     *         {@link GridSizeEnum#NORMAL_GRID_SIZE}
     *         or {@link GridSizeEnum#LARGE_GRID_SIZE} otherwise true
     */
    public static boolean isValidSize(int length) {
        return length == GridSizeEnum.NORMAL_GRID_SIZE.getValue() || length == GridSizeEnum.LARGE_GRID_SIZE.getValue();
    }
}
