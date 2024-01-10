package Race;

public class Track {
    private int finishedRacers;
    Track(){
      this.finishedRacers=0;
    }
    public int getFinishedRacers(){ return finishedRacers;}
    public void setFinishedRacers(){ finishedRacers++;}
}

