package XO;
/**
 * This class represent user game - one independent player (SelfPlayer)
 * and one player controlled by user input (UserPlayer).
 * build two player 1 user 1 self player.
 * @author Nir Hazan 316009489 , May Seter 312123037
 */

public class UserGame extends Game {
	SelfPlayer player1;
	UserPlayer player2;
	public UserGame(SelfPlayer player1, UserPlayer player2) {	// constructor
		this.player1 = player1;
		this.player2 = player2;
	}
	public void startGame() throws InterruptedException { 	// method sets the game for the players and starts their threads
		player1.setGameForPlayer(this);
		player2.setGameForPlayer(this);
		player1.start();
		player2.start();
		player1.join();
		player2.join();
	}
}
