package XO;
import java.util.List;
public abstract class Player extends Thread {
    protected char type;
    protected Game a;
    public Player(char type,Game a) {
        this.type = type;
        this.a=a;
    }
    public abstract void run();
    public char getType() {
        return type;
    }
    protected boolean isFreeCell(Game a) {     
        if( a.getFreeCells().size()==0)
        	return false;
        else return true;
    }
    protected boolean isFreeCell(int row, int col) {
    	 Coordinates temp = new Coordinates(row,col);
    	  List<Coordinates> freeCells = a.getFreeCells();
		for(int i=0;i<freeCells.size();i++) {
			Coordinates run=freeCells.get(i);
			if(temp.getRow()==run.getRow()&&temp.getCol()==run.getCol()){
				return true;
			}
		}
		return false;
	}
public synchronized boolean checkWin(Game a, char symbol) {
	char[][] gameBoard = a.getGameBoard();
    int size = gameBoard.length;
//check diagonals in board.
if (a.getGameBoard()[0][1] == symbol && a.getGameBoard()[1][2] == symbol &&a.getGameBoard()[2][3] == symbol && a.getGameBoard()[3][4] == symbol)
        return true;
if (a.getGameBoard()[1][0] == symbol && a.getGameBoard()[2][1] == symbol &&a.getGameBoard()[3][2] == symbol && a.getGameBoard()[4][3] == symbol) 
        return true;
if (a.getGameBoard()[0][3] == symbol && a.getGameBoard()[1][2] == symbol && a.getGameBoard()[2][1] == symbol && a.getGameBoard()[3][0] == symbol) 
       return true;
if (a.getGameBoard()[1][4] == symbol && a.getGameBoard()[2][3] == symbol &&a.getGameBoard()[3][2] == symbol && a.getGameBoard()[4][1] == symbol) 
        return true;
if (a.getGameBoard()[0][0] == symbol && a.getGameBoard()[1][1] == symbol &&a.getGameBoard()[2][2] == symbol && a.getGameBoard()[3][3] == symbol) 
return true;
if (a.getGameBoard()[4][4] == symbol && a.getGameBoard()[1][1] == symbol &&a.getGameBoard()[2][2] == symbol && a.getGameBoard()[3][3] == symbol) 
return true;
if (a.getGameBoard()[4][0] == symbol && a.getGameBoard()[3][1] == symbol &&a.getGameBoard()[2][2] == symbol && a.getGameBoard()[1][3] == symbol) 
return true;
if (a.getGameBoard()[0][4] == symbol && a.getGameBoard()[3][1] == symbol &&a.getGameBoard()[2][2] == symbol && a.getGameBoard()[1][3] == symbol) 
return true;
// Check for winning sequences in rows and columns
for (int i = 0; i < size; i++) {
    if (checkSequence(gameBoard[i], symbol) || checkSequence(getColumn(gameBoard, i), symbol)) {
        return true;
    }
}





return false;
   
}
private static char[] getColumn(char[][] matrix, int columnIndex) {
    int size = matrix.length;
    char[] column = new char[size];
    for (int i = 0; i < size; i++) {
        column[i] = matrix[i][columnIndex];
    }
    return column;
}
private static boolean checkSequence(char[] sequence, char symbol) {
    int count = 0;
    for (char cell : sequence) {
        if (cell == symbol) {
            count++;
            if (count == 4) {
                return true;
            }
        } else {
            count = 0;
        }
    }
    return false;
} 

    
}
