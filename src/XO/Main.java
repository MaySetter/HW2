package XO;
import java.util.Scanner;
/**
 * This class represent main program in the game. user can choose mode.
 * @author Nir Hazan 316009489 , May Seter 312123037
 *
 */
public class Main {
	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		int checker=0;
		System.out.println("Choose :");
		System.out.println("1.Self Game.");          //Using input from user to decide which game mode should be run.
		System.out.println("2.User Game.");
		int mode=input.nextInt();
		while (checker==0) {
		switch(mode) {
		case 1:
			@SuppressWarnings("unused") SelfGame Self =new SelfGame() ;
			checker=1;
			break;
		case 2:
			@SuppressWarnings("unused") UserGame User=new UserGame();
			checker=1;
			break;
		default:{
			System.out.println("Choose 1 or 2");
			mode=input.nextInt();
			}
			}
		}
	}		
}	
