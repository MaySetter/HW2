package XO;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static Scanner input = new Scanner(System.in);

    public static void main(String[] args) throws Exception{

        System.out.println("Choose Game");
        System.out.println("1...........");
        System.out.println("2...........");
        System.out.println("3.Exit Game");


        int choice;
        do{
            switch (choice = getChoice()) {
                case 1 -> startUserGame();
                case 2 -> startSelfGame();
            }
        } while (choice !=3); // finishes loop if user input is 5.
        System.out.println("\nEXIT");
    }

    private static void startUserGame() {
    }

    private static void startSelfGame() {
    }


    public static int getChoice() throws Exception{
        int choice;
        try {
            choice = input.nextInt();
            while (choice < 1 || choice > 3) { // allows user to enter new digit if not in range.
                System.out.print("Invalid input! Enter a number between 1 to 3: \n");
                choice = input.nextInt(); // enter new and valid input.
            }
            return choice;
        }catch (InputMismatchException e) {
            throw new Exception("Mismatch, input is not a number.");
        }catch (Exception e){
            throw new Exception(e);
        }
    }
}
