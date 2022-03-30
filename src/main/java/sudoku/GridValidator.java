package sudoku;

public class GridValidator {
    public static boolean valid(char[][] grid) throws IllegalArgumentException {
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

    public static boolean isValidValueAccordingToGrid(char[][] grid, int x, int y, char value) {
        if (valueExistsInRow(grid, x, y, value)
                || valueExistsInColumn(grid, x, y, value)
                || valueExistsInSubgrid(grid, x, y, value)) {
            return false;
        }

        return true;
    }

    public static boolean valueExistsInRow(char[][] grid, int x, int y, char value) {
        for (int index = 0; index < grid.length; index++) {
            if (index != x && value == grid[y][index]) {
                return true;
            }
        }

        return false;
    }

    public static boolean valueExistsInColumn(char[][] grid, int x, int y, char value) {
        for (int index = 0; index < grid.length; index++) {
            if (index != y && value == grid[index][x]) {
                return true;
            }
        }

        return false;
    }

    public static boolean valueExistsInSubgrid(char[][] grid, int x, int y, char value) {
        int length = GridSubgridSizeProvider.provide(grid.length).getValue();

        // Get the start point of subgrid
        int x0 = (int) (x / length) * length;
        int y0 = (int) (y / length) * length;
        for (int y1 = 0; y < length; y++) {
            for (int x1 = 0; x < length; x++) {
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
