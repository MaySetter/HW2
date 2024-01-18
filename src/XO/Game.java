package XO;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * This class represents a game object.
 * @author Nir Hazan 316009489 , May Seter 312123037
 */

public abstract class Game { // Using enum to represent the signs of each player.(X OR O).
	
    public enum SIGNS { // enum of game's signs (player's X or O, as well as empty)
        X('X'),O('O'), NON(' '); 
        private final char asChar;
        SIGNS(char asChar) { this.asChar = asChar; }
        public char asChar(){ return asChar; }
    }
	
    private final int COL = 5, ROW = 5;
    private char[][] gameBoard = new char[ROW][COL];   // Define Variables.
    private char turn;
	
    public Game(){ // Empty Constructor builds an empty board and prints.
    	for (int i = 0; i < ROW; i++) {  
            Arrays.fill(gameBoard[i], ' ');
    	}
    	Random random=new Random();
    	int temp=random.nextInt(2);     // Using random to decide who start the game.
    	if(temp==1)
    		this.turn=SIGNS.X.asChar;
    	else this.turn=SIGNS.O.asChar;
    	System.out.println("First turn : "+this.turn);
    	printBoard();
    }
	
    public char[][] getGameBoard() {   // getter for game board .
	    return this.gameBoard;
	}
	
    /**
     * Set the sign on the board.
     * @param coordinate cell for new mark
     * @param symbol mark's sign (X or O)
     */ 
	
    public char[][] getGameBoard() {   // get game board .
        return this.gameBoard;
    }
	
    public void setTurn() { // changes the sign for the next player's turn
        if (turn == SIGNS.X.asChar())
            turn = SIGNS.O.asChar();
        else
            turn = SIGNS.X.asChar();
    }
	
    public char getTurn() { // getter
        return turn;
    }
	
   /**
    * Prints the board on the screen. Must be synchronized because board can't be changed while printing
    */
    public synchronized void printBoard(){
        System.out.println("-----------BOARD----------\n\n");
        System.out.println("    0    1    2    3    4 ");
        for (int i=0; i<gameBoard.length; i++){
            System.out.println(" +----+----+----+----+----+");
            System.out.print(i);
            for (int j=0; j<gameBoard[i].length; j++)
                System.out.printf("| %s  ", gameBoard[i][j]);
            System.out.println("|");
        }
        System.out.println(" +----+----+----+----+----+");
        System.out.println("\n\n");

    }
	
    /**
     * Method creates an ArrayList of all the empty cells in board.
     * @return List of coordinates of free cells.
     */
    public List<Coordinates> getFreeCells(){
        List<Coordinates> freeCells = new ArrayList<>();
        for (int i = 0; i < gameBoard.length; i++) {
            for (int j = 0; j < gameBoard[i].length; j++) {
                if (gameBoard[i][j] == ' ')
                    freeCells.add(new Coordinates(i, j));
            }
        }
        return freeCells;
    }
}
