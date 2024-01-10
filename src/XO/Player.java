package XO;

public abstract class Player extends Thread {

    protected char type;

    public Player(char type) throws Exception{
        if (type != 'X' || type != 'O')
            throw new Exception(".....");
        this.type = type;
    }

    public char getType() {
        return type;
    }

    public void run(){}

    protected boolean isFreeCell(int row, int col) {
        Coordinates temp = new Coordinates(row,col);
        // if getFreeCells.contains(temp)
        // return true;
        return false;
    }

}
