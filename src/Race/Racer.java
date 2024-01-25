package Race;

import java.util.Scanner;

public class Racer extends Thread{

    static private int globalId = 1;
    private final int id;
    private int speed;
    private final Track track;
    private final Scanner input = new Scanner(System.in);

    public Racer(int speed, Track track) {
        do{
            try {
                this.speed = setSpeed(speed);
            }catch (Exception e){
                System.out.println(e.getMessage()+"\nEnter valid speed: ");
                speed = input.nextInt();
            }
        }while (this.speed == 0);

        this.speed = speed;
        this.track = track;
        id = globalId;
        globalId++;
    }

    private int setSpeed(int speed) throws Exception{
        if (speed<1 || speed>10)
            throw new Exception("Error: speed must be between 1-10.");
        else return speed;
    }

    public void go(){
        setPriority(speed);
        for (int i=1; i<=100; i++)
            System.out.println("Runner " + id + " ran " + i + " meters");
        track.setFinishedRacers();
        System.out.println("Runner " + id + " finished " + track.getFinishedRacers() + suffix());
    }

    public void run(){
        go();
    }

    private String suffix(){
        return switch (track.getFinishedRacers()) {
            case (1) -> "st";
            case (2) -> "nd";
            case (3) -> "rd";
            default -> "th";
        };
    }
}
