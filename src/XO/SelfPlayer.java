package XO;

import java.util.Random;


/**
 * This class is a thread represent self player in the game.
 * self player play alone with random choose.
 * @author Nir Hazan 316009489 , May Seter 312123037
 *
 */
public class SelfPlayer extends Player {
	Coordinates s=new Coordinates(0,0);
    public SelfPlayer(char type,Game game){
        super(type,game);
    }
    public void run() {
     	while(!checkWin()) {   // when some one win stop the thread.
     		if(!checkWin()&&game.getFreeCells().size()>0) {
     			if(game.getFreeCells().size()==0) {    //check if the board isnt full.
     				System.out.println("Game Over , Board is full");
     				break;
     			}
     			if(game.getTurn()!=type) {   // if not his turn go sleep for 500 mils
     				try {
     					sleep(500);
     				} catch (InterruptedException e) {
    				e.getMessage();
    			}
    		}
     			else{	
     				synchronized(game) {  //must be synchronized because when the computer want to play must finish his turn before something can change.
     				if(!checkWin()){
    					Random x=new Random();
    					s=game.getFreeCells().get(x.nextInt(game.getFreeCells().size()));
    					game.setGameBoard(s,this.getType());
    					game.setTurn();
    					game.printBoard();
    					if(checkWin()) {
    						System.out.println("Game Over ."+this.type+" Win.");
    					}
     					}
				else break;
     				}
			}
    	}
			
			else {
				System.out.println("Game Over ,Board is full ");
				break;
			  }	
			}
		}
  	}

