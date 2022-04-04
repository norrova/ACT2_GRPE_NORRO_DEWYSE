package sudoku;

public final class MathUtils {

    private MathUtils() {
    }

    /**
     * Check if value is between min and max.
     * @param value
     * @param min
     * @param max
     * @return true if value is between min and max, otherwise false
     */
    public static boolean isNumberBetween(
            final int value, final int min, final int max
    ) {
        return value >= min && value <= max;
    }
}
