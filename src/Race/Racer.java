package Race;
/**
 * Class that represent racer in the race.
 * has speed,id,and global id.
 * @author Nir Hazan 316009489 , May Seter 312123037
 *
 */
public class Racer implements Runnable{

    static private int globalId = 1;
    private final int id;              // Define Variables
    private int speed;
    private Track track;
/**
 * 
 * @param speed of racer
 * @param track which track.
 * @throws Exception if speed not between 1-10.
 */
    public Racer(int speed, Track track) throws Exception{
        if (speed<1 || speed >10){
            new Exception("Error: Racer's speed must be between 1-10.");
        }
        this.speed = speed;
        this.track = track;
        id = globalId;
        globalId++;
    }
/**
 * function that make the racer start running 100m according to speed (priority).
 */
    public void go(){
    	Thread.currentThread().setPriority(speed);
        for (int i=1; i<=100; i++)
            System.out.println("Runner " + id + " ran " + i + " meters");
        track.setFinishedRacers();
        System.out.println("Runner " + id + " finished " + track.getFinishedRacers() + suffix());
    }
/**
 * racer is thread runing go function when start (run).
 */

    public void run(){
        go();
    }

    private String suffix(){  // using string to print suffix of racers.
        return switch (track.getFinishedRacers()) {
            case (1) -> "st";
            case (2) -> "nd";
            case (3) -> "rd";
            default -> "th";
        };
    }
}
