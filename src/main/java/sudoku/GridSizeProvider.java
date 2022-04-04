package sudoku;

public final class GridSizeProvider {

    private GridSizeProvider() {
    }

    /**
     * Provide grid size value according to length passed in parameters.
     * @param length
     * @return GridSizeEnum value
     * @throws IllegalArgumentException when no length is supported
     */
    public static GridSizeEnum provide(
            final int length
    ) throws IllegalArgumentException {
        if (length == GridSizeEnum.NORMAL_GRID_SIZE.getValue()) {
            return GridSizeEnum.NORMAL_GRID_SIZE;
        }

        if (length == GridSizeEnum.LARGE_GRID_SIZE.getValue()) {
            return GridSizeEnum.LARGE_GRID_SIZE;
        }

        throw new IllegalArgumentException(
                "Grid size not found for the length" + length
        );
    }
}
