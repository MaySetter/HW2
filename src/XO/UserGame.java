package XO;

public class UserGame extends Game {
	SelfPlayer player1 =new SelfPlayer('X',this);
	UserPlayer player2=new UserPlayer('O',this);
	public UserGame() {
		player1.start();
		player2.start();
	}
  
}
