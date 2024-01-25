package XO;
import java.util.Scanner;
/**
 * This class is thread represent User player in the game.
 * user can decide where to put his sign.
 * @author Nir Hazan 316009489 , May Seter 312123037
 *
 */
public class UserPlayer extends Player{
	Coordinates s;
	Scanner input = new Scanner(System.in);
	public UserPlayer(char type){
		super(type);
	}

	public void  run() {

		while(!win) {

			synchronized(game) { // when his turn ask the user where to put the sign.

				if(game.getFreeCells().size()==0) {
					System.out.println("Game Over, Board is full");
					win = true;
					break;
				}

				if(game.getTurn()==type&&game.getFreeCells().size()>0 && !win) {
					System.out.println("Enter row for your move:");
					int row = input.nextInt()-1;
					System.out.println("Enter  column for your move:");
					int col = input.nextInt()-1;                            // must be synchronized because when player need to play we wait until the end of his turn.
					while (!isFreeCell(row,col)){                              //
						System.out.println("Invalid move. Try again.");
						row = input.nextInt()-1;
						col = input.nextInt()-1;
					}
					s = new Coordinates(row,col);
					game.setGameBoard(s,this.type);
					game.setTurn();
					game.printBoard();       // after put sign if win print the winner and the game will stopped.
					checkWin();
					if(win) game.setWinner(this.type);
				}
			}
		}
	}
}
