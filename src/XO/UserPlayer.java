package XO;
import java.util.Scanner;
/**
 * This class is thread represent User player in the game.
 * user can decide where to put his sign.
 * @author Nir Hazan 316009489 , May Seter 312123037
 *
 */
public class UserPlayer extends Player{
	Coordinates s =new Coordinates(0,0);
	Scanner input = new Scanner(System.in);	
    public UserPlayer(char type,Game game){
        super(type,game);
    }
    public void  run() {
    	
        	while(!checkWin()) {
        		
        		if(game.getTurn()!=type) {   // Make sleep if its not his turn.
        			try {
						sleep(500);
					} catch (InterruptedException e) {
						e.getMessage();
					}
        		}
        		synchronized(game) { // when his turn ask the user where to put the sign.
        		if(game.getTurn()==type&&game.getFreeCells().size()>0&&!checkWin()) {
        			System.out.println("Enter row for your move:");
        			int row = input.nextInt();
        			System.out.println("Enter  column for your move:");
        			int col = input.nextInt();                            // must be synchronized because when player need to play we wait until the end of his turn.
        			while (!isFreeCell(row,col)){                              // 
        				System.out.println("Invalid move. Try again.");
        				row = input.nextInt();
        				col = input.nextInt();
        			}
        			s = new Coordinates(row,col);
        			game.setGameBoard(s,this.type);
        			game.setTurn();
        			game.printBoard();       // after put sign if win print the winner and the game will stopped.
        			if(checkWin()) {
        				System.out.println("Game Over ."+this.type+" Win.");
        			}
        		}
        		}
        	}		 	
       }
}
