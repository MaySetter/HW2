package Race;
/**
 * Class that represents track in the race, and how many racers has finished.
 * @author Nir Hazan 316009489 , May Seter 312123037
 */
public class Track {
    private int finishedRacers; // Define Variables
    /**
     * Constructor of Track starting number of finihed racer to zero.
     */
    Track(){
      this.finishedRacers=0;
    }
    // getter and setter for finishedRacers variable.
    public int getFinishedRacers(){ return finishedRacers;}  
    public void setFinishedRacers(){ finishedRacers++;}
}
