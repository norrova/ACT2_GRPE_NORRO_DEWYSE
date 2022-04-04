package sudoku;

public enum GridSizeEnum {
    /**
     * Normal size of sudoku grid.
     */
    NORMAL_GRID_SIZE(9),

    /**
     * Normal size of subgrid sudoku.
     */
    NORMAL_SUBGRID_SIZE(3),

    /**
     * Large size of sudoku grid.
     */
    LARGE_GRID_SIZE(16),

    /**
     * Large size of subgrid sudoku.
     */
    LARGE_SUBGRID_SIZE(4);

    /**
     * Value for enum type.
     */
    private final int value;

    GridSizeEnum(final int paramValue) {
        this.value = paramValue;
    }

    /**
     * Getter value for enum type.
     * @return value of enum type
     */
    public int getValue() {
        return value;
    }
}
