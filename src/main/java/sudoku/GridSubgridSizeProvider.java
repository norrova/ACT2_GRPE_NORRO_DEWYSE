package sudoku;

public class GridSubgridSizeProvider {
    public static GridSizeEnum provide(int length) throws IllegalArgumentException {
        if (length == GridSizeEnum.NORMAL_GRID_SIZE.getValue()) {
            return GridSizeEnum.NORMAL_SUBGRID_SIZE;
        }

        if (length == GridSizeEnum.LARGE_GRID_SIZE.getValue()) {
            return GridSizeEnum.LARGE_SUBGRID_SIZE;
        }

        throw new IllegalArgumentException("Subgrid size not found for the length" + length);
    }
}
