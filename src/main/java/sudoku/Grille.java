package sudoku;

/**
 * Interface d'une grille de sudoku.
 */
public interface Grille {
    /**
     * Caractere de case vide.
     */
    char EMPTY = '@';

    /**
     * Caractere possible a mettre dans la grille.
     *
     * pour une grille 9x9 : 1..9
     *
     * pour une grille 16x16: 0..9-a..f
     */
    char[] DEFAULT_CHARACTERS = new char[] {'1', '2', '3', '4', '5', '6',
            '7', '8', '9', '0', 'a', 'b', 'c', 'd', 'e', 'f'};

    /**
     * @return grid
     */
    char[][] getGrid();

    /**
     * @return allowed characters in the grid
     */
    char[] getAllowedCharacters();

    /**
     * @return largeur/hauteur de la grille.
     */
    int getDimension();

    /**
     * Affecte une valeur dans la grille.
     *
     * @param x     position x dans la grille
     * @param y     position y dans la grille
     * @param value
     *              valeur a mettre dans la case
     * @throw IllegalArgumentException si x ou y sont hors bornes (0-8)
     * @throw IllegalArgumentException si la valeur est interdite aux vues des
     *        autres valeurs de la grille
     * @throw IllegalArgumentException si value n'est pas un caractere autorise
     *        ('1',...,'9')
     */
    void setValue(int x, int y, char value) throws IllegalArgumentException;

    /**
     * Recupere une valeur de la grille.
     *
     * @param x position x dans la grille
     * @param y position y dans la grille
     * @return valeur dans la case x,y
     * @throw IllegalArgumentException si x ou y sont hors bornes (0-8)
     */
    char getValue(int x, int y) throws IllegalArgumentException;

    /**
     * Test si une grille est terminee.
     *
     * @return true si la grille est complete
     */
    boolean complete();

    /**
     * Test si une valeur est possible dans la grille par rapport a ce qu'elle
     * contient deja.
     *
     * @param x     position x dans la grille
     * @param y     position y dans la grille
     * @param value
     *              valeur a mettre dans la case
     * @throw IllegalArgumentException si x ou y sont hors bornes (0-8)
     * @throw IllegalArgumentException si value n'est pas un caractere autorise
     *        ('1',...,'9',..)
     * @return true if value can be placed in the grid, otherwise false
     */
    boolean possible(int x, int y, char value) throws IllegalArgumentException;
}
