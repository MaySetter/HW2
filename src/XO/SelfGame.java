package XO;
/**
 * This class represent user game in the game.
 * build two player 2 self players.
 * @author Nir Hazan 316009489 , May Seter 312123037
 *
 */
public class SelfGame extends Game{
	SelfPlayer player1 =new SelfPlayer(SIGNS.X.asChar,this);
	SelfPlayer player2=new SelfPlayer(SIGNS.O.asChar,this);
	public SelfGame() {
		player1.start();
		player2.start();
	}
  
}
