package sudoku;

public final class GridSubgridSizeProvider {

    private GridSubgridSizeProvider() {
    }

    /**
     * Provide subgrid size value according to length passed in parameters.
     * @param length
     * @return GridSizeEnum value
     * @throws IllegalArgumentException when no length is supported
     */
    public static GridSizeEnum provide(
            final int length
    ) throws IllegalArgumentException {
        if (length == GridSizeEnum.NORMAL_GRID_SIZE.getValue()) {
            return GridSizeEnum.NORMAL_SUBGRID_SIZE;
        }

        if (length == GridSizeEnum.LARGE_GRID_SIZE.getValue()) {
            return GridSizeEnum.LARGE_SUBGRID_SIZE;
        }

        throw new IllegalArgumentException(
                "Subgrid size not found for the length" + length
        );
    }
}
