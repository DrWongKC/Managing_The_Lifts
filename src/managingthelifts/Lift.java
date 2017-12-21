package managingthelifts;
import java.util.ArrayList;
/**
 *
 * @author kaichong
 */
public class Lift {
    
    // For LiftID
    private static int counter=0;
    
    // Variables
    private int liftId;
    private boolean isAvailable;
    
    // Stats
    private int numberOfHackers;
    private int numberOfDeliveryPersons;
    private int numberOfDebtCollectors;
    private int numberOfInvestors;
    private int numberOfSongWriters;
    
    private int numberOfOthers;
    
    // Storage
    private ArrayList peopleInLift;
    
    // Reference address
    StatisticsSystem stats;
    ArrayList listOfRooms;
    
    // Constructor
    public Lift(StatisticsSystem stats, ArrayList listOfRooms) {
        
        this.liftId=counter; counter++;
        this.peopleInLift=new ArrayList();
        
        this.numberOfHackers=0;
        this.numberOfDeliveryPersons=0;
        this.numberOfDebtCollectors=0;
        this.numberOfInvestors=0;
        this.numberOfSongWriters=0;
        this.numberOfOthers=0;
        
        this.isAvailable=true;
        
        this.stats=stats;
        this.listOfRooms=listOfRooms;
        
    }
    
    // Send people to lift
    public void sendPersonsToLift(ArrayList listOfWaiters) {
        
        // Temporary variable
        Person temp;
        
        // Set lift to unavailable
        this.isAvailable=false;
        
        // For each element in listOfWaiters
        for (int i=0; i<listOfWaiters.size(); i++) {
            temp=(Person) listOfWaiters.get(i);
            
            // UPDATE STATS
            if (temp.getType().equalsIgnoreCase("OTHERS")) {
                this.numberOfOthers+=1;
            }
            if (temp.getType().equalsIgnoreCase("HACKER")) {
                this.numberOfHackers+=1;
            }
            if (temp.getType().equalsIgnoreCase("DELIVERYPERSON")) {
                this.numberOfDeliveryPersons+=1;
            }
            if (temp.getType().equalsIgnoreCase("DEBTCOLLECTOR")) {
                this.numberOfDebtCollectors+=1;
            }
            if (temp.getType().equalsIgnoreCase("INVESTOR")) {
                this.numberOfInvestors+=1;
            }
            if (temp.getType().equalsIgnoreCase("SONGWRITER")) {
                this.numberOfSongWriters+=1;
            }
            
            // SEND PEOPLE TO RESPECTIVE ROOMS
            Room r=(Room) listOfRooms.get(temp.getFloor());
            r.addPersonToRoom(temp);
        }
    }
    
    // Reset lift
    public void resetLift() {
        this.isAvailable=true;
    }
    
    // Get lift ID
    public int getLiftId() {
        return liftId;
    }
    
    // Get lift availability
    public boolean getAvailability() {
        return isAvailable;
    }
    
    // Get total number of persons served by this lift
    public int getTotalPersonsServed() {
        return numberOfHackers+numberOfDeliveryPersons+numberOfDebtCollectors+numberOfInvestors+numberOfSongWriters+numberOfOthers;
    }
    
    // Get number of hackers served
    public int getHackersServed() {
        return numberOfHackers;
    }
    
    // Get number of delivery persons served
    public int getDeliveryPersonsServed() {
        return numberOfDeliveryPersons;
    }
    
    // Get number of debt collectors served
    public int getDebtCollectorsServed() {
        return numberOfDebtCollectors;
    }
    
    // Get number of investors served
    public int getInvestorsServed() {
        return numberOfInvestors;
    }
    
    // Get number of song writers served
    public int getSongWritersServed() {
        return numberOfSongWriters;
    }
}
