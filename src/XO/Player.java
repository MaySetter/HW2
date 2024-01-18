package XO;
import java.util.List;
import XO.Game.SIGNS;
/**
 * This class represent player in the game.
 *there are two kind of players this is the father of them.
 * @author Nir Hazan 316009489 , May Seter 312123037
 *
 */
public abstract class Player extends Thread {
    protected char type;
    protected Game game;
    public Player(char type,Game game) {
        this.type = type;
		this.game=game;
    }
    public abstract void run(); // implements in players class
    public char getType() {
        return type;
    }
    /**
     * //check if specific cell if free.
     * 
     */
    protected boolean isFreeCell(int row, int col) { 
    	 Coordinates temp = new Coordinates(row,col);
    	  List<Coordinates> freeCells = game.getFreeCells();
		for(int i=0;i<freeCells.size();i++) {
			Coordinates run=freeCells.get(i);
			if(temp.getRow()==run.getRow()&&temp.getCol()==run.getCol()){
				return true;
			}
		}
		return false;
	}
    /**
     * // function that check if someone win
     * 
     */
    public synchronized boolean checkWin() {  
        for (int x = 0; x < game.getGameBoard().length; x++) { // row
            for (int y = 0; y < game.getGameBoard()[x].length; y++) { // col
                char symbol = game.getGameBoard()[y][x];
                if(symbol !=SIGNS.NON.asChar)
                if ( checkSeq(y, x, symbol, game.getGameBoard()) ) {
                    return true;
                }
            }
        }
        return false;
    }
    /**
     * // function that check if there is 4 sign in row column or diagonal on the board.
     * 
     */
    private boolean checkSeq(int y, int x, char symbol, char[][] board) { // function that
        int col = 0, row = 0, diag1 = 0, diag2 = 0;
        for (int i = 1; i < 4; i++) {
            if (x < 2 && board[y][x + i] == symbol) row++;
            if (y < 2 && board[y + i][x] == symbol) col++;
            if ((x < 2 && y < 2) && board[y + i][x + i] == symbol) diag1++;
            if ((x > 2 && y < 2) && board[y + i][x - i] == symbol) diag2++;
            if (col == 3 || row == 3 || diag1 == 3 || diag2 == 3) return true;
        }
        return false;
    }
}
