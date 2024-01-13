package XO;

import java.util.Random;

//import java.util.Scanner;

public class SelfPlayer extends Player {
	Coordinates s=new Coordinates(0,0);
    public SelfPlayer(char type,Game a){
        super(type,a);
    }
    public void run() {
     	for(int i=0;i<13;i++) {
     		if(!checkWin(a,type)&&a.getFreeCells().size()>0) {
     			if(a.getFreeCells().size()==0) {
     				System.out.println("Game Over , Board is full");
     				break;
     			}
     			if(a.getTurn()!=type) { 
     				try {
     					i--;
     					sleep(500);
     				} catch (InterruptedException e) {
    				e.getMessage();
    			}
    		}
     			else{	
     				if(!checkWin(a,'O')&&!checkWin(a,'X')){
    					Random x=new Random();
    					s=a.getFreeCells().get(x.nextInt(a.getFreeCells().size()));
    					a.setGameBoard(s,this.getType());
    					a.setTurn();
    					a.printBoard();
     					}
				else break;
			}
    	}
		else {
			if(checkWin(a,'O')) {
				System.out.println("Game Over .O Win.");		
				break;		
			}
			else if(checkWin(a,'X')) {
				System.out.println("Game Over .X Win.");
				break;	
			}
			else {
				System.out.println("Game Over ,Board is full ");
				break;
			  }	
			}
		}
  	}
}
