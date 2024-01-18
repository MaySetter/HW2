package XO;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
/**
 * This class represent game board in the game.
 * @author Nir Hazan 316009489 , May Seter 312123037
 *
 */
public abstract class Game {
	public enum SIGNS {
        X('X'),O('O'), NON(' ');  // Using enum to represent the signs of each player.(X OR O).
        final char asChar;
        SIGNS(char asChar) { this.asChar = asChar; }
        public char asChar(){ return asChar; }
    }

    private char[][] gameBoard = new char[5][5];   // Define Variables.
    private char turn;
    public Game(){
    	for (int i = 0; i < gameBoard.length; i++) {  // Empty Constructor which build nre empty board.
            for (int j = 0; j < gameBoard[i].length; j++) {
                gameBoard[i][j] = ' ';                 
            }
    	}
    	Random random=new Random();
    	int temp=random.nextInt(2);     // Using random to decide who start the game.
    	if(temp==1)
    		this.turn=SIGNS.X.asChar;
    	else this.turn=SIGNS.O.asChar;
    	System.out.println("First turn : "+this.turn);
    	printBoard();
    }
    public char[][] getGameBoard() {   // get game board .
	    return this.gameBoard;
	}
    /**
     * Set the sign on the board.
     * @param coordinate
     * @param symbol
     */ 
    public void setGameBoard(Coordinates c,char symbol) {  //
	    this.gameBoard[c.getRow()][c.getCol()]=symbol;
	}
    /**
     * Set turn for other player.
     */
    public void setTurn() {
	   if(turn==SIGNS.X.asChar)
		   turn=SIGNS.O.asChar;
	   else
		   turn=SIGNS.X.asChar;
	}
    public char getTurn() {
		return turn; 	
    }
   /**
    * Print the board on the screen must be synchronized because no can change the board when printing.
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
     * 
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
