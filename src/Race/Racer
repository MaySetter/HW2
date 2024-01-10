package Race;

public class Racer extends Thread{

    static private int globalId = 1;
    private final int id;
    private int speed;
    private Track track;

    public Racer(int speed, Track track) {
        if (speed<1 || speed >10){
            new Exception("Error: Racer's speed must be between 1-10.");
        }
        this.speed = speed;
        this.track = track;
        id = globalId;
        globalId++;
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
