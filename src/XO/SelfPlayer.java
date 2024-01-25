package XO;
import java.util.Random;

/**
 * This class is a thread representing a SelfPlayer (independent player) in the game.
 * self player play alone with random choices.
 * @author Nir Hazan 316009489 , May Seter 312123037
 */
public class SelfPlayer extends Player {
	Coordinates s;

	public SelfPlayer(char type){ 	// constructor
		super(type);
	}

	public void run() {
		while(!win) {   // when someone win loop stops.

			if(game.getTurn()!=type) {   // if not thread's turn, go to sleep for 500 mils
				try {
					sleep(500);
				} catch (InterruptedException e) {
					System.out.println(e.getMessage());
				}
			}
			else {
				//must be synchronized. When thread wants to "play", it must finish its turn before changes can be made to game.
				synchronized(game) {

					if(!win && game.getFreeCells().size()==0) { // no one won but no free cells are left
						System.out.println("Game Over, Board is full");
						win = true; // changes loop's condition.
						break;
					}

					else{ 	// no one won and there are free cells
						Random x = new Random();
						s = game.getFreeCells().get(x.nextInt(game.getFreeCells().size())); // generates a random cell from the freeCells list.
						game.setGameBoard(s,this.getType()); // set sign on board
						game.setTurn(); // changed turn
						game.printBoard();
						checkWin();
						if(win) game.setWinner(this.type);
					}
				}
			}
		}
	}
}
