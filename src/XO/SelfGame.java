package XO;

public class SelfGame extends Game{
	SelfPlayer player1 =new SelfPlayer('X',this);
	SelfPlayer player2=new SelfPlayer('O',this);
	public SelfGame() {
		player1.start();
		player2.start();
	}
  
}
