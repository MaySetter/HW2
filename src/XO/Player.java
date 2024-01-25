package XO;
import java.util.List;
import XO.Game.SIGNS;

/**
 * This class represents a player in the game.
 * there are two kind of players that inherits Player (UserPlayer and SelfPlayer).
 * @author Nir Hazan 316009489 , May Seter 312123037
 */
public abstract class Player extends Thread {
    protected char type;
    protected Game game;
    protected static boolean win = false; // will change to true once there will be a winner (or a tie).

    public Player(char type) { // constructor
        this.type = type;
    }

    public void setGameForPlayer(Game game){
        this.game = game;
    }

    public abstract void run(); // implementation in SelfPlayer and UserPlayer classes.
    public char getType() {
        return type;
    }

    /**
     * Method checks if given cell is free.
     * Creates a Coordinate object from parameters and checks if it's in free cells list (getFreeCells method).
     * @param row cell's row
     * @param col cell's column
     * @return true if cell free. otherwise false.
     */
    protected boolean isFreeCell(int row, int col) { 
        Coordinates temp = new Coordinates(row,col);
        List<Coordinates> freeCells = game.getFreeCells();
        for (Coordinates run : freeCells) {
            if (temp.row() == run.row() && temp.col() == run.col()) {
                return true;
            }
        }
		return false;
	}

    /**
     * Method checks if there's a win. 
     * If cell is not empty, will use checkSeq method to check if cell creates a sequence of 4
     * or more equal signs.
     * if so, changes static variable 'win' to true.
     */
    public synchronized void checkWin() {
        for (int x = 0; x < game.getGameBoard().length; x++) { // row
            for (int y = 0; y < game.getGameBoard()[x].length; y++) { // col
                char symbol = game.getGameBoard()[y][x];
                if(symbol !=SIGNS.NON.asChar)
                    if ( checkSeq(y, x, symbol, game.getGameBoard()) ) {
                        win = true;
                }
            }
        }
    }

    /**
     * Method checks if there is a sequence of 4 (or more) equal signs in a row, column, or diagonal on the board.
     * each counter variables will count the length of the sequence.
     * @param y cell's row number
     * @param x cell's column number
     * @param symbol cell's sign
     * @param board game board
     * @return true if one of the count variables reached 4 (no need to count if sequence is longer). 
     */
    private boolean checkSeq(int y, int x, char symbol, char[][] board) { 
        int col = 1, row = 1, diagonal1 = 1, diagonal2 = 1; // counter variables.
        for (int i = 1; i < game.getGameBoard().length-1; i++) {
            if (x < 2 && board[y][x + i] == symbol) row++; // row sequence
            if (y < 2 && board[y + i][x] == symbol) col++; // col sequence
            if ((x < 2 && y < 2) && board[y + i][x + i] == symbol) diagonal1++; // up to down-right diagonal seq
            if ((x > 2 && y < 2) && board[y + i][x - i] == symbol) diagonal2++; // up to down-left diagonal seq
            if (col == 4 || row == 4 || diagonal1 == 4 || diagonal2 == 4) return true;
        }
        return false;
    }
}
