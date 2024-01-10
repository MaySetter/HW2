package XO;

import java.util.ArrayList;
import java.util.List;

public abstract class Game {

    public char[][] gameBoard = new char[5][5];

    public enum SIGNS {X,O}

    public Game(){}

    public void printBoard(){
        for (int i=0; i<gameBoard.length; i++){
            System.out.println("+---+---+---+---+---+");
            for (int j=0; j<gameBoard[i].length; j++){
                System.out.print("| " + gameBoard[i][j] + " | ");
            }
        }
        System.out.println("+---+---+---+---+---+");
    };

    public abstract int getTurn();

    public List<Coordinates> getFreeCells(){
        List<Coordinates> freeCells = new ArrayList<>();
        for (int i = 0; i < gameBoard.length; i++) {
            for (int j = 0; j < gameBoard[i].length; j++) {
                if (gameBoard[i][j] == ' ')
                    freeCells.add(new Coordinates(i, j));
            }
        }
        return freeCells;
    }
}
