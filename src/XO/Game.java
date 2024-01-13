package XO;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
public abstract class Game {
    private char[][] gameBoard = new char[5][5];
    private char turn;
    public Game(){
    	for (int i = 0; i < gameBoard.length; i++) {
            for (int j = 0; j < gameBoard[i].length; j++) {
                gameBoard[i][j] = ' ';                 
            }
    	}
    	Random random=new Random();
    	int temp=random.nextInt(2);
    	if(temp==1)
    		this.turn='X';
    	else this.turn='O';
    	System.out.println("First turn : "+this.turn);
    	printBoard();
    }
    public char[][] getGameBoard() {
	    return this.gameBoard;
	}
    public void setGameBoard(Coordinates a,char symbol) {
	    this.gameBoard[a.getRow()][a.getCol()]=symbol;
	}
    public void setTurn() {
	   if(turn=='X')
		   turn='O';
	   else
		   turn='X';
	}
    public char getTurn() {
		return turn; 	
    }
    public synchronized void printBoard(){
    	 for (int i=0; i<gameBoard.length; i++){
             System.out.println("+----+----+----+----+----+");
             for (int j=0; j<gameBoard[i].length; j++)
                 System.out.printf("| %s  ", gameBoard[i][j]);
             System.out.println("|");
         }
         System.out.println("+----+----+----+----+----+");
         System.out.println("\n\n");
    }
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
