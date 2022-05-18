package sudoku;

public class GridSolver {

    /**
     * Grid.
     */
    private Grille grid;

    /**
     * Constructor.
     * @param paramGrid
     */
    public GridSolver(final Grille paramGrid) {
        this.grid = paramGrid;
    }

    /**
     * Getter.
     * @return grid
     */
    public Grille getGrid() {
        return grid;
    }

    /**
     * Setter grid.
     * @param paramGrid
     */
    public void setGrid(final Grille paramGrid) {
        this.grid = paramGrid;
    }

    /**
     * Solve a grid.
     * @param x position
     * @param y position
     * @return true if grid is solved, otherwise false
     */
    public boolean solve(int x, int y) {
        if (x == this.grid.getDimension()) {
            x = 0;
            ++y;
        }

        if (this.grid.getGrid()[y][x] != GrilleImpl.EMPTY) {
            return solve(x + 1, y);
        }

        for (char value : this.grid.getAllowedCharacters()) {
            if (
                    GridValidator.isValidValueAccordingToGrid(
                            this.grid.getGrid(),
                            x,
                            y,
                            value)
            ) {
                this.grid.setValue(x, y, value);

                if (
                        x == this.grid.getDimension() - 1
                        && y == this.grid.getDimension() - 1
                        || solve(x + 1, y)) {
                    return true;
                }

                this.grid.setValue(x, y, Grille.EMPTY);
            }
        }

        return false;
    }
}
