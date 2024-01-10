package XO;

import java.util.Scanner;

public class SelfPlayer extends Player {

    public SelfPlayer(char type) throws Exception{
        super(type);
    }

    public void run() {

        try {
            sleep(500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        Scanner input = new Scanner(System.in);
        System.out.println("Enter row and column for your move:");
        int row = input.nextInt();
        int col = input.nextInt();

        while (!isFreeCell(row,col)){
            System.out.println("Invalid move. Try again.");
            row = input.nextInt();
            col = input.nextInt();
        }
    }

}
