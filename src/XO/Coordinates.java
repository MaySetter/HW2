package XO;
/**
 * This class represents a cell in the game board using rows and columns.
 * @author Nir Hazan 316009489 , May Seter 312123037
 */

public class Coordinates { 

    private int row;
    private int col;  // Define Variables.
    
/**
 * Constructor get row and column and create coordinate.
 * @param row cell's row number
 * @param col cell's column number
 */
    public Coordinates(int row, int col){ // Constructor
        this.row = row;
        this.col = col;
    }

    public int getRow(){return row;} // Getters for variables.
    public int getCol(){return col;}
}
