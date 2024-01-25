package XO;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
/**
 * This class represents a game board in the XO game.
 * @author Nir Hazan 316009489 , May Seter 312123037
 *
 */
public abstract class Game {
    public enum SIGNS { // Using enum to represent the signs of each player.(X OR O).
        X('X'), O('O'), NON(' ');
        final char asChar;
        SIGNS(char asChar) {
            this.asChar = asChar;
        }
        public char asChar() {
            return asChar;
        }
    }

    private final int COL=5, ROW=5; // Numbers of rows and columns in game.
    private final char[][] gameBoard = new char[ROW][COL];   // Define matrix for game board.
    private char turn;
    private char winner = SIGNS.NON.asChar();


    /**
     * Game class constructor.
     * Builds game board, decides which sign's turn is first and prints the board.
     */
    public Game() {
        for (char[] chars : gameBoard) {  // Empty Constructor builds an empty board.
            Arrays.fill(chars, SIGNS.NON.asChar()); // Fills board with ' '.
        }
        Random random = new Random();
        int temp = random.nextInt(2);     // Using random to decide who starts the game.
        if (temp == 1)
            this.turn = SIGNS.X.asChar();
        else this.turn = SIGNS.O.asChar();
        System.out.println("First turn : " + this.turn);
        printBoard();
    }

    public abstract void startGame() throws InterruptedException; // abstract

    public char[][] getGameBoard() {   // getter for game board.
        return this.gameBoard;
    }

    /**
     * Set the sign on the board.
     * @param c Coordinates for new sign
     * @param symbol sign of player
     */
    public void setGameBoard(Coordinates c, char symbol) {  //
        this.gameBoard[c.row()][c.col()] = symbol;
    }

    /**
     * Sets turn for other player. Changes from one symbol to the other.
     */
    public void setTurn() {
        if (turn == SIGNS.X.asChar())
            turn = SIGNS.O.asChar();
        else
            turn = SIGNS.X.asChar();
    }

    // Getter for turn
    public char getTurn() {
        return turn;
    }

    public void setWinner(char winner){ this.winner = winner; }
    public char getWinner() {return winner;}


    /**
     * Prints the board on the screen. Must be synchronized because no change can be made on the board when printing.
     */
    public synchronized void printBoard() {
        System.out.println("----------BOARD----------\n\n"); // Header.
        for(int i=0; i<COL; i++)
            System.out.print("    " + (i+1) ); // columns' numbers.
        System.out.println();
        for (int i = 0; i < ROW; i++) {
            System.out.print(" +");
            for(int k=0; k<COL; k++) System.out.print("----+"); // rows' separators .
            System.out.println();
            System.out.print(i+1); // row's numbers
            for (int j = 0; j < COL; j++)
                System.out.printf("| %s  ", gameBoard[i][j]); // columns' separators + sign.
            System.out.println("|"); // last column separator.
        }
        System.out.print(" +");
        for(int k=0; k<COL; k++) System.out.print("----+"); // last row separator.
        System.out.println("\n\n");

    }
    /**
     * Method uses ArrayList to list all the free cells on board.
     * @return List of coordinates of free cells.
     */
    public List<Coordinates> getFreeCells(){
        List<Coordinates> freeCells = new ArrayList<>();
        for (int i = 0; i < ROW; i++) {
            for (int j = 0; j < COL; j++) {
                if (gameBoard[i][j] == SIGNS.NON.asChar())
                    freeCells.add(new Coordinates(i, j));
            }
        }
        return freeCells;
    }
}
