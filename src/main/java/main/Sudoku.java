package main;

import sudoku.GridSolver;
import sudoku.GrilleImpl;

/**
 * main.Sudoku main.
 */
public final class Sudoku {

    private Sudoku() {
    }

    /**
     * Program main.
     * @param args arguments passed to the program
     */
    public static void main(final String[] args) {
        GrilleImpl grille = new GrilleImpl(new char[][] {
                {'9', '@', '@', '1', '@', '@', '@', '@', '5'},
                {'@', '@', '5', '@', '9', '@', '2', '@', '1'},
                {'8', '@', '@', '@', '4', '@', '@', '@', '@'},
                {'@', '@', '@', '@', '8', '@', '@', '@', '@'},
                {'@', '@', '@', '7', '@', '@', '@', '@', '@'},
                {'@', '@', '@', '@', '2', '6', '@', '@', '@'},
                {'2', '@', '@', '3', '@', '@', '@', '@', '6'},
                {'@', '@', '@', '2', '@', '@', '9', '@', '@'},
                {'@', '@', '1', '9', '@', '4', '5', '7', '@'},
        });
        GridSolver solver = new GridSolver(grille);
        System.out.println(solver.solve(0, 0));
        for (int i = 0; i < grille.getDimension(); i++) {
            for (int j = 0; j < grille.getDimension(); j++) {
                System.out.print(grille.getGrid()[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println(grille.complete());
    }
}
