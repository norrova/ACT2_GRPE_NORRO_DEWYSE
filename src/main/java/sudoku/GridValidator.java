package sudoku;

public final class GridValidator {

    private GridValidator() {
    }

    /**
     * Check if a grid is valid.
     * @param grid
     * @return true if grid is valid, otherwise false
     * @throws IllegalArgumentException
     */
    public static boolean valid(
            final char[][] grid
    ) throws IllegalArgumentException {
        if (!GridFormatValidator.isUniform(grid)) {
            throw new IllegalArgumentException("Bad format grid");
        }

        int length = grid.length;

        for (int y = 0; y < length; y++) {
            for (int x = 0; x < length; x++) {
                char value = grid[y][x];
                if (!isValidValueAccordingToGrid(grid, x, y, value)) {
                    return false;
                }
            }
        }

        return true;
    }

    /**
     * Check if value is valid according to the grid.
     * @param grid
     * @param x
     * @param y
     * @param value
     * @return boolean true if value is valid, otherwise false
     */
    public static boolean isValidValueAccordingToGrid(
            final char[][] grid,
            final int x,
            final int y,
            final char value
    ) {
        if (valueExistsInRow(grid, x, y, value)
                || valueExistsInColumn(grid, x, y, value)
                || valueExistsInSubgrid(grid, x, y, value)) {
            return false;
        }

        return true;
    }

    /**
     * Check if value exists in row.
     * @param grid
     * @param x
     * @param y
     * @param value
     * @return boolean true if value exists in the row, otherwise false
     */
    public static boolean valueExistsInRow(
            final char[][] grid,
            final int x,
            final int y,
            final char value
    ) {
        for (int index = 0; index < grid.length; index++) {
            if (index != x && value == grid[y][index]) {
                return true;
            }
        }

        return false;
    }

    /**
     * Check if value exists in column.
     * @param grid
     * @param x
     * @param y
     * @param value
     * @return boolean true if value exists in the column, otherwise false
     */
    public static boolean valueExistsInColumn(
            final char[][] grid,
            final int x,
            final int y,
            final char value
    ) {
        for (int index = 0; index < grid.length; index++) {
            if (index != y && value == grid[index][x]) {
                return true;
            }
        }

        return false;
    }

    /**
     * Check if value exists in the subgrid.
     * @param grid
     * @param x
     * @param y
     * @param value
     * @return boolean true if value exists in the subgrid, otherwise false
     */
    public static boolean valueExistsInSubgrid(
            final char[][] grid,
            final int x,
            final int y,
            final char value
    ) {
        int length = GridSubgridSizeProvider.provide(grid.length).getValue();
        int indexX = x;
        int indexY = y;

        // Get the start point of subgrid
        int x0 = (int) (x / length) * length;
        int y0 = (int) (y / length) * length;
        for (int y1 = 0; y < length; indexY++) {
            for (int x1 = 0; x < length; indexX++) {
                int x3 = x0 + x1;
                int y3 = y0 + y1;
                if (x3 != x && y3 != y && grid[y3][x3] == value) {
                    return true;
                }
            }
        }

        return false;
    }
}
