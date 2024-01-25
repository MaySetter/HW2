package XO;
import java.util.Scanner;
/**
 * This class represent main program in the game. user can choose mode.
 * @author Nir Hazan 316009489 , May Seter 312123037
 *
 */
public class Main {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		System.out.println("Choose Game Mode: ");
		System.out.println("1.Self Game.");      //Using input from user to decide which game mode should be run.
		System.out.println("2.User Game.");

		Game game = null;
		boolean checker = true; // will check if user input (game mode) is valid
		int mode = input.nextInt(); // game mode
		do switch (mode) {
			case 1 -> {
				SelfPlayer player1 = new SelfPlayer(Game.SIGNS.X.asChar());
				SelfPlayer player2 = new SelfPlayer(Game.SIGNS.O.asChar());
				game = new SelfGame(player1,player2);
			}
			case 2 -> {
				SelfPlayer player1 = new SelfPlayer(Game.SIGNS.X.asChar());
				UserPlayer player2 = new UserPlayer(Game.SIGNS.O.asChar());
				game = new UserGame(player1,player2);
			}
			default -> {   // if user input is not valid
				checker = false;
				System.out.println("Choose 1 or 2.");
				mode = input.nextInt();
			}
		} while(!checker);

		try{
			game.startGame();
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
