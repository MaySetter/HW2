package XO;
import java.util.Scanner;
public class UserPlayer extends Player{
	Coordinates s =new Coordinates(0,0);
	Scanner input = new Scanner(System.in);	
    public UserPlayer(char type,Game a){
        super(type,a);
    }
    public void  run() {
        	for(int i=0;i<13;i++) {
        		if(checkWin(a,type)) {
					System.out.println("Game Over ."+this.type+" Win.");
					break;
				}
        		if(a.getTurn()!=type) {
        			i--; 
        			try {
						sleep(500);
					} catch (InterruptedException e) {
						e.getMessage();
					}
        		}
        		if(a.getTurn()==type&&a.getFreeCells().size()>0&&!checkWin(a,'X')&&!checkWin(a,'O')) {
        			System.out.println("Enter row for your move:");
        			int row = input.nextInt();
        			System.out.println("Enter  column for your move:");
        			int col = input.nextInt();
        			while (!isFreeCell(row,col)){
        				System.out.println("Invalid move. Try again.");
        				row = input.nextInt();
        				col = input.nextInt();
        			}
        			s = new Coordinates(row,col);
        			a.setGameBoard(s,this.type);
        			a.setTurn();
        			a.printBoard();
        		}
        	}		 	
       }
}
