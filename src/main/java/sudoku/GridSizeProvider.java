package sudoku;

public class GridSizeProvider {
    public static GridSizeEnum provide(int length) {
        if (length == GridSizeEnum.NORMAL_GRID_SIZE.getValue()) {
            return GridSizeEnum.NORMAL_GRID_SIZE;
        }

        if (length == GridSizeEnum.LARGE_GRID_SIZE.getValue()) {
            return GridSizeEnum.LARGE_GRID_SIZE;
        }

        throw new IllegalArgumentException("Grid size not found for the length" + length);
    }
}
