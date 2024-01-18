package XO;
/**
 * This class represent user game in the game.
 * build two player 1 user 1 self player.
 * @author Nir Hazan 316009489 , May Seter 312123037
 *
 */

public class UserGame extends Game {
	SelfPlayer player1 =new SelfPlayer(SIGNS.X.asChar,this);
	UserPlayer player2=new UserPlayer(SIGNS.O.asChar,this);
	public UserGame() {
		player1.start();
		player2.start();
	}
  
}
