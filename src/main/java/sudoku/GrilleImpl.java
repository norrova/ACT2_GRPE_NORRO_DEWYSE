package sudoku;

import java.util.Arrays;

/**
 * Implementation d'une grille
 */
public class GrilleImpl implements Grille {

    /**
     * Dimension de la grille
     */
    private GridSizeEnum gridSize;

    /**
     * Taille d'une sous grille
     */
    private GridSizeEnum subgridSize;

    /**
     * Grille de jeu
     */
    public final char[][] grid;

    public static final char[] NormalSizeAllowedCharacter = new char[] {
            '1', '2', '3', '4', '5', '6', '7', '8', '9'
    };

    public GrilleImpl(char[][] data) throws IllegalArgumentException {
        this.setDimension(data.length);

        char[] allowedCharacter = ArrayUtils.concat(
                this.getAllowedCharacterAccordingToDimension(data.length),
                new char[] { GrilleImpl.EMPTY });

        if (!GridFormatValidator.isValidFormat(data, allowedCharacter)) {
            throw new IllegalArgumentException("two-dimensional array must be uniform and contains valid characters "
                    + Arrays.toString(allowedCharacter));
        }

        this.grid = data;
    }

    public char[][] getGrid() {
        return grid;
    }

    public int getSubgridSize() {
        return subgridSize.getValue();
    }

    private void setSubgridSize(int value) throws IllegalArgumentException {
        this.subgridSize = GridSubgridSizeProvider.provide(value);
    }

    @Override
    public int getDimension() {
        return this.gridSize.getValue();
    }

    private GrilleImpl setDimension(int value) throws IllegalArgumentException {
        this.setSubgridSize(value);
        this.gridSize = GridSizeProvider.provide(value);
        ;

        return this;
    }

    private char[] getAllowedCharacterAccordingToDimension(int size) {
        if (size == GridSizeEnum.NORMAL_GRID_SIZE.getValue()) {
            return GrilleImpl.NormalSizeAllowedCharacter;
        }

        if (size == GridSizeEnum.LARGE_GRID_SIZE.getValue()) {
            return GrilleImpl.possible;
        }

        throw new IllegalArgumentException("Size not supported");
    }

    @Override
    public void setValue(int x, int y, char value) throws IllegalArgumentException {
        this.possible(x, y, value);
        if (!GridValidator.isValidValueAccordingToGrid(grid, x, y, value)) {
            throw new IllegalArgumentException("Value must be unique in column, row and subgrid");
        }
        this.grid[x][y] = value;
    }

    @Override
    public char getValue(int x, int y) throws IllegalArgumentException {
        this.validCoord(x, y);
        return this.grid[y][x];
    }

    @Override
    public boolean complete() {
        return GridValidator.valid(this.grid);
    }

    @Override
    public boolean possible(int x, int y, char value) throws IllegalArgumentException {
        this.validCoord(x, y);
        String values = String.valueOf(GrilleImpl.possible);
        if (!values.contains("" + value)) {
            throw new IllegalArgumentException("Value must be char in " + Arrays.toString(GrilleImpl.possible));
        }

        return true;
    }

    private boolean validCoord(int x, int y) throws IllegalArgumentException {
        if (!MathUtils.isNumberBetween(x, 0, this.getDimension() - 1)) {
            throw new IllegalArgumentException("x must be in the range of 0 to " + (this.getDimension() - 1));
        }

        if (!MathUtils.isNumberBetween(y, 0, this.getDimension() - 1)) {
            throw new IllegalArgumentException("y must be in the range of 0 to " + (this.getDimension() - 1));
        }

        return true;
    }
}
