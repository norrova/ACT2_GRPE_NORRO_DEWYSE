package sudoku;

import java.util.Arrays;

/**
 * Implementation d'une grille.
 */
public final class GrilleImpl implements Grille {

    /**
     * Dimension de la grille.
     */
    private GridSizeEnum gridSize;

    /**
     * Taille d'une sous grille.
     */
    private GridSizeEnum subgridSize;

    /**
     * Allowed characters in the grid.
     */
    private final char[] allowedCharacters;

    /**
     * Grille de jeu.
     */
    private final char[][] grid;

    /**
     * Allowed characters in normal size grid 9X9.
     */
    public static final char[] NORMAL_SIZE_ALLOWED_CHARACTER = new char[] {
            '1', '2', '3', '4', '5', '6', '7', '8', '9'
    };

    /**
     * Constructor.
     * @param data
     * @throws IllegalArgumentException
     */
    public GrilleImpl(final char[][] data) throws IllegalArgumentException {
        this.setDimension(data.length);

        this.allowedCharacters = ArrayUtils.concat(
                this.getAllowedCharactersAccordingToDimension(data.length),
                new char[] {GrilleImpl.EMPTY});

        if (!GridFormatValidator.isValidFormat(data, this.allowedCharacters)) {
            throw new IllegalArgumentException(
                    "two-dimensional array must be uniform "
                            + "and contains valid characters "
                    + Arrays.toString(this.allowedCharacters)
            );
        }

        this.grid = data;
    }

    /**
     * Get grid of the sudoku game.
     * @return grid
     */
    public char[][] getGrid() {
        return grid;
    }

    /**
     * Get allowed characters.
     * @return allowed characters
     */
    public char[] getAllowedCharacters() {
        return allowedCharacters;
    }

    /**
     * Get subgrid size.
     * @return subgrid size
     */
    public int getSubgridSize() {
        return subgridSize.getValue();
    }

    /**
     * Set subgrid size.
     * @param value
     * @throws IllegalArgumentException
     */
    private void setSubgridSize(
            final int value
    ) throws IllegalArgumentException {
        this.subgridSize = GridSubgridSizeProvider.provide(value);
    }

    @Override
    public int getDimension() {
        return this.gridSize.getValue();
    }

    /**
     * Set Dimension.
     * @param value
     * @return self
     * @throws IllegalArgumentException
     */
    private GrilleImpl setDimension(
            final int value
    ) throws IllegalArgumentException {
        this.setSubgridSize(value);
        this.gridSize = GridSizeProvider.provide(value);

        return this;
    }

    private char[] getAllowedCharactersAccordingToDimension(final int size) {
        if (size == GridSizeEnum.NORMAL_GRID_SIZE.getValue()) {
            return GrilleImpl.NORMAL_SIZE_ALLOWED_CHARACTER;
        }

        if (size == GridSizeEnum.LARGE_GRID_SIZE.getValue()) {
            return GrilleImpl.DEFAULT_CHARACTERS;
        }

        throw new IllegalArgumentException("Size not supported");
    }

    @Override
    public void setValue(
            final int x,
            final int y,
            final char value
    ) throws IllegalArgumentException {
        this.possible(x, y, value);
        if (!GridValidator.isValidValueAccordingToGrid(grid, x, y, value)) {
            throw new IllegalArgumentException(
                    "Value must be unique in column, row and subgrid"
            );
        }
        this.grid[y][x] = value;
    }

    @Override
    public char getValue(
            final int x,
            final int y
    ) throws IllegalArgumentException {
        this.validCoord(x, y);
        return this.grid[y][x];
    }

    @Override
    public boolean complete() {
        return GridValidator.valid(this.grid);
    }

    @Override
    public boolean possible(
            final int x,
            final int y,
            final char value
    ) throws IllegalArgumentException {
        if (GrilleImpl.EMPTY == value) {
            return true;
        }
        this.validCoord(x, y);
        if (
                !String.valueOf(this.getAllowedCharacters())
                        .contains("" + value)
        ) {
            throw new IllegalArgumentException(
                    "Value must be char in "
                            + Arrays.toString(this.getAllowedCharacters()));
        }

        return true;
    }

    private boolean validCoord(
            final int x,
            final int y
    ) throws IllegalArgumentException {
        if (!MathUtils.isNumberBetween(x, 0, this.getDimension() - 1)) {
            throw new IllegalArgumentException(
                    "x must be in the range of 0 to "
                            + (this.getDimension() - 1)
            );
        }

        if (!MathUtils.isNumberBetween(y, 0, this.getDimension() - 1)) {
            throw new IllegalArgumentException(
                    "y must be in the range of 0 to "
                            + (this.getDimension() - 1)
            );
        }

        return true;
    }
}
