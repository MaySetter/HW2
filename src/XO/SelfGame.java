package XO;
/**
 * This class represent self game - two independent players (SelfPlayer)
 * @author Nir Hazan 316009489 , May Seter 312123037
 */
public class SelfGame extends Game{
	SelfPlayer player1;
	SelfPlayer player2;

	public SelfGame(SelfPlayer player1, SelfPlayer player2) { 	// constructor
		this.player1 = player1;
		this.player2 = player2;
	}
	
	public void startGame(){ 	// method sets the game for the players and starts their threads
		player1.setGameForPlayer(this);
		player2.setGameForPlayer(this);
		player1.start();
		player2.start();
	}
}
