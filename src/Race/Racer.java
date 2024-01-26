package Race;

import java.util.Scanner;

/**
 * This class represents a participant (racer) in the racer.
 * A racer has an ID made from a static variable, speed, and track.
 * @author Nir Hazan 316009489 , May Seter 312123037
 */
public class Racer extends Thread{

    static private int globalId = 1;
    private final int id;
    private int speed;
    private final Track track;

    public Racer(int speed, Track track) {      // constructor
        do{         // do loop while speed is invalid
            try {
                this.speed = setSpeed(speed);
            }catch (Exception e){
                System.out.println(e.getMessage()+"\nEnter valid speed: ");
                Scanner input = new Scanner(System.in);
                speed = input.nextInt();
            }
        }while (this.speed == 0);

        this.speed = speed;
        this.track = track;
        id = globalId;
        globalId++;
    }

    /**
     * Method checks validity of speed variable. Speed is the var in setPriority()
     * and thus it has to an int between 1 and 10.
     * @param speed racer's speed.
     * @return speed if valid.
     * @throws Exception if speed is not between 1 and 10.
     */
    private int setSpeed(int speed) throws Exception{
        if (speed<1 || speed>10)
            throw new Exception("Error: speed must be between 1-10.");
        else return speed;
    }

    /**
     * Method determines the priority of the thread as the speed of the racer.
     * Runs a loop from 1 to 100 that simulates the number of meters the racer ran.
     * After each meter, racer's id and number of meters are printed.
     */
    public void go(){
        setPriority(speed);
        for (int i=1; i<=100; i++)
            System.out.println("Runner " + id + " ran " + i + " meters");
        track.setFinishedRacers();
        int finishNum = track.getFinishedRacers();
        System.out.println("Runner " + id + " finished " + finishNum + suffix(finishNum));
    }

    // from Runnable
    public void run(){
        go();
    }

    /**
     * Method determines the suffix of a given number.
     * @return string suffix (st, nd, rd, th).
     */
    private String suffix(int num){
        return switch (num) {
            case (1) -> "st";
            case (2) -> "nd";
            case (3) -> "rd";
            default -> "th";
        };
    }
}
