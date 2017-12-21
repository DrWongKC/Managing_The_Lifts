package managingthelifts;
import java.util.ArrayList;
/**
 *
 * @author kaichong
 */
public class StatisticsSystem {
    
    // Entered building
    private int numberOfHackersEnteredBuilding;
    private int numberOfDeliveryPersonsEnteredBuilding;
    private int numberOfDebtCollectorsEnteredBuilding;
    private int numberOfInvestorsEnteredBuilding;
    private int numberOfSongWritersEnteredBuilding;
    
    private int numberOfOthersEnteredBuilding;
    
    // Entered floor
    // 50 floors by 5 types. 0 is hacker, 1 is delivery persons, 2 is debt collectors, 3 is investors and 4 is songwriters. 50x5
    private int[][] numberOfTypeByFloor;
    
    // Average time spent of all people
    private long averageTimeSpentByAll;
    
    public StatisticsSystem() {
        this.numberOfHackersEnteredBuilding=0;
        this.numberOfDeliveryPersonsEnteredBuilding=0;
        this.numberOfDebtCollectorsEnteredBuilding=0;
        this.numberOfInvestorsEnteredBuilding=0;
        this.numberOfSongWritersEnteredBuilding=0;
        
        this.numberOfOthersEnteredBuilding=0;
        
        this.numberOfTypeByFloor=new int[50][6];
        for (int i=0; i<50; i++) {
            for (int j=0; j<5; j++) {
                numberOfTypeByFloor[i][j]=0;
            }
        }
        
        this.averageTimeSpentByAll=0;
    }
    
    // Increase type that entered building
    public void increaseCountOfHackersEnteredBuilding() {
        this.numberOfHackersEnteredBuilding+=1;
    }
    
    public void increaseCountOfDeliveryPersonsEnteredBuilding() {
        this.numberOfDeliveryPersonsEnteredBuilding+=1;
    }
    
    public void increaseCountOfDebtCollectorsEnteredBuilding() {
        this.numberOfDebtCollectorsEnteredBuilding+=1;
    }
    
    public void increaseCountOfInvestorsEnteredBuilding() {
        this.numberOfInvestorsEnteredBuilding+=1;
    }
    
    public void increaseCountOfSongWritersEnteredBuilding() {
        this.numberOfSongWritersEnteredBuilding+=1;
    }
    
    public void increaseCountOfOthersEnteredBuilding() {
        this.numberOfOthersEnteredBuilding+=1;
    }
    
    // Increase type that entered floor
    public void increaseCountOfHackersWentToFloor(int f) {
        this.numberOfTypeByFloor[(f-1)][0]+=1;
    }
    
    public void increaseCountOfDeliveryPersonsWentToFloor(int f) {
        this.numberOfTypeByFloor[(f-1)][1]+=1;
    }
    
    public void increaseCountOfDebtCollectorsWentToFloor(int f) {
        this.numberOfTypeByFloor[(f-1)][2]+=1;
    }
    
    public void increaseCountOfInvestorsWentToFloor(int f) {
        this.numberOfTypeByFloor[(f-1)][3]+=1;
    }
    
    public void increaseCountOfSongWritersWentToFloor(int f) {
        this.numberOfTypeByFloor[(f-1)][4]+=1;
    }
    
    public void increaseCountOfOthersWentToFloor(int f) {
        this.numberOfTypeByFloor[(f-1)][5]+=1;
    }
    
    // Add to total average milliseconds
    public void addToTimeSpentByAllInMilliseconds(long time) {
        this.averageTimeSpentByAll+=time;
    }
    
    // Get type that entered building
    public int getNumberOfHackersEnteredBuilding() {
        return numberOfHackersEnteredBuilding;
    }
    
    public int getNumberOfDeliveryPersonsEnteredBuilding() {
        return numberOfDeliveryPersonsEnteredBuilding;
    }
    
    public int getNumberOfDebtCollectorsEnteredBuilding() {
        return numberOfDebtCollectorsEnteredBuilding;
    }
    
    public int getNumberOfInvestorsEnteredBuilding() {
        return numberOfInvestorsEnteredBuilding;
    }
    
    public int getNumberOfSongWritersEnteredBuilding() {
        return numberOfSongWritersEnteredBuilding;
    }
    public int getNumberOfOthersEnteredBuilding() {
        return numberOfOthersEnteredBuilding;
    }
    
    // Get type that entered floor
    public int getNumberOfHackersWentToFloor(int f) {
        return numberOfTypeByFloor[(f-1)][0];
    }
    
    public int getNumberOfDeliveryPersonsWentToFloor(int f) {
        return numberOfTypeByFloor[(f-1)][1];
    }
    
    public int getNumberOfDebtCollectorsWentToFloor(int f) {
        return numberOfTypeByFloor[(f-1)][2];
    }
    
    public int getNumberOfInvestorsWentToFloor(int f) {
        return numberOfTypeByFloor[(f-1)][3];
    }
    
    public int getNumberOfSongWritersWentToFloor(int f) {
        return numberOfTypeByFloor[(f-1)][4];
    }
    
    public int getNumberOfOthersWentToFloor(int f) {
        return numberOfTypeByFloor[(f-1)][5];
    }
    
    // Get total that entered floor
    public int getTotalNumberWhoWentToFloor(int f) {
        return numberOfTypeByFloor[(f-1)][0] 
                + numberOfTypeByFloor[(f-1)][1] 
                + numberOfTypeByFloor[(f-1)][2] 
                + numberOfTypeByFloor[(f-1)][3] 
                + numberOfTypeByFloor[(f-1)][4]
                + numberOfTypeByFloor[(f-1)][5];
    }
    
    // Get average time spent by all (check this)
    public long getAverageTimeSpentByAll() {
        return averageTimeSpentByAll/(numberOfHackersEnteredBuilding
                +numberOfDeliveryPersonsEnteredBuilding
                +numberOfDebtCollectorsEnteredBuilding
                +numberOfInvestorsEnteredBuilding
                +numberOfSongWritersEnteredBuilding
                +numberOfOthersEnteredBuilding);
    }
    
    // Get most popular floor
    public int getMostPopularFloor() {
        int highestCount=0;
        int mostPopularFloor=0;
        for (int i=0; i<50; i++) {
            if (this.getTotalNumberWhoWentToFloor(i+1)>highestCount) {
                highestCount=this.getTotalNumberWhoWentToFloor(i+1);
                mostPopularFloor=(i+1);
            }
        }
        return mostPopularFloor;
    }
    
    // Get floor with most hackers
    public int getFloorWithMostHackers() {
        int highestCount=0;
        int mostPopularHackerFloor=0;
        for (int i=0; i<50; i++) {
            if (this.getNumberOfHackersWentToFloor(i+1)>highestCount) {
                highestCount=this.getNumberOfHackersWentToFloor(i+1);
                mostPopularHackerFloor=(i+1);
            }
        }
        return mostPopularHackerFloor;
    }
    
    // Get floor with most delivery persons
    public int getFloorWithMostDeliveryPersons() {
        int highestCount=0;
        int mostPopularDeliveryPersonFloor=0;
        for (int i=0; i<50; i++) {
            if (this.getNumberOfDeliveryPersonsWentToFloor(i+1)>highestCount) {
                highestCount=this.getNumberOfDeliveryPersonsWentToFloor(i+1);
                mostPopularDeliveryPersonFloor=(i+1);
            }
        }
        return mostPopularDeliveryPersonFloor;
    }
    
    // Get floor with most debt collectors
    public int getFloorWithMostDebtCollectors() {
        int highestCount=0;
        int mostPopularDebtCollectorFloor=0;
        for (int i=0; i<50; i++) {
            if (this.getNumberOfDebtCollectorsWentToFloor(i+1)>highestCount) {
                highestCount=this.getNumberOfDebtCollectorsWentToFloor(i+1);
                mostPopularDebtCollectorFloor=(i+1);
            }
        }
        return mostPopularDebtCollectorFloor;
    }
    
    // Get floor with most investors
    public int getFloorWithMostInvestors() {
        int highestCount=0;
        int mostPopularInvestorFloor=0;
        for (int i=0; i<50; i++) {
            if (this.getNumberOfInvestorsWentToFloor(i+1)>highestCount) {
                highestCount=this.getNumberOfInvestorsWentToFloor(i+1);
                mostPopularInvestorFloor=(i+1);
            }
        }
        return mostPopularInvestorFloor;
    }
    
    // Get floor with most song writers
    public int getFloorWithMostSongWriters() {
        int highestCount=0;
        int mostPopularInvestorFloor=0;
        for (int i=0; i<50; i++) {
            if (this.getNumberOfSongWritersWentToFloor(i+1)>highestCount) {
                highestCount=this.getNumberOfSongWritersWentToFloor(i+1);
                mostPopularInvestorFloor=(i+1);
            }
        }
        return mostPopularInvestorFloor;
    }
    
    // Generate a defined range of numbers
    public int generateNumWithRange(int min, int max) {
        int range = (max-min)+1;
        return (int)(Math.random()*range)+min;
    }
    
    // Lift which carried most people
    public int liftWhichCarriedMostPeople(ArrayList listOfLift) {
        int highestCount=0;
        int liftThatCarriedMostPeople=0;
        for (int i=1; i<=4; i++) {
            Lift thisLift=(Lift) listOfLift.get(i);
            if (thisLift.getTotalPersonsServed()>highestCount) {
                highestCount=thisLift.getTotalPersonsServed();
                liftThatCarriedMostPeople=i;
            }
        }
        return liftThatCarriedMostPeople;
    }
    
    // Lift which carried most hackers
    public int liftWhichCarriedMostHackers(ArrayList listOfLift) {
        int highestCount=0;
        int liftThatCarriedMostHackers=0;
        for (int i=1; i<=4; i++) {
            Lift thisLift=(Lift) listOfLift.get(i);
            if (thisLift.getHackersServed()>highestCount) {
                highestCount=thisLift.getHackersServed();
                liftThatCarriedMostHackers=i;
            }
        }
        return liftThatCarriedMostHackers;
    }
    
    // Lift which carried least hackers
    public int liftWhichCarriedLeastHackers(ArrayList listOfLift) {
        int lowestCount=999999999;
        int liftThatCarriedLeastHackers=0;
        for (int i=1; i<=4; i++) {
            Lift thisLift=(Lift) listOfLift.get(i);
            if (thisLift.getHackersServed()<lowestCount) {
                lowestCount=thisLift.getHackersServed();
                liftThatCarriedLeastHackers=i;
            }
        }
        return liftThatCarriedLeastHackers;
    }
                
    // Lift which carried most delivery persons
    public int liftWhichCarriedMostDeliveryPersons(ArrayList listOfLift) {
        int highestCount=0;
        int liftThatCarriedMostDeliveryPersons=0;
        for (int i=1; i<=4; i++) {
            Lift thisLift=(Lift) listOfLift.get(i);
            if (thisLift.getDeliveryPersonsServed()>highestCount) {
                highestCount=thisLift.getDeliveryPersonsServed();
                liftThatCarriedMostDeliveryPersons=i;
            }
        }
        return liftThatCarriedMostDeliveryPersons;
    }
    
    // Lift which carried least delivery persons
    public int liftWhichCarriedLeastDeliveryPersons(ArrayList listOfLift) {
        int lowestCount=999999999;
        int liftThatCarriedLeastDeliveryPersons=0;
        for (int i=1; i<=4; i++) {
            Lift thisLift=(Lift) listOfLift.get(i);
            if (thisLift.getDeliveryPersonsServed()<lowestCount) {
                lowestCount=thisLift.getDeliveryPersonsServed();
                liftThatCarriedLeastDeliveryPersons=i;
            }
        }
        return liftThatCarriedLeastDeliveryPersons;
    }
    
    // Lift which carried most debt collectors
    public int liftWhichCarriedMostDebtCollectors(ArrayList listOfLift) {
        int highestCount=0;
        int liftThatCarriedMostDebtCollectors=0;
        for (int i=1; i<=4; i++) {
            Lift thisLift=(Lift) listOfLift.get(i);
            if (thisLift.getDebtCollectorsServed()>highestCount) {
                highestCount=thisLift.getDebtCollectorsServed();
                liftThatCarriedMostDebtCollectors=i;
            }
        }
        return liftThatCarriedMostDebtCollectors;
    }
    
    // Lift which carried least debt collectors
    public int liftWhichCarriedLeastDebtCollectors(ArrayList listOfLift) {
        int lowestCount=999999999;
        int liftThatCarriedLeastDebtCollectors=0;
        for (int i=1; i<=4; i++) {
            Lift thisLift=(Lift) listOfLift.get(i);
            if (thisLift.getDebtCollectorsServed()<lowestCount) {
                lowestCount=thisLift.getDebtCollectorsServed();
                liftThatCarriedLeastDebtCollectors=i;
            }
        }
        return liftThatCarriedLeastDebtCollectors;
    }
    
    // Lift which carried most investors
    public int liftWhichCarriedMostInvestors(ArrayList listOfLift) {
        int highestCount=0;
        int liftThatCarriedMostInvestors=0;
        for (int i=1; i<=4; i++) {
            Lift thisLift=(Lift) listOfLift.get(i);
            if (thisLift.getInvestorsServed()>highestCount) {
                highestCount=thisLift.getInvestorsServed();
                liftThatCarriedMostInvestors=i;
            }
        }
        return liftThatCarriedMostInvestors;
    }

    // Lift which carried least investors
    public int liftWhichCarriedLeastInvestors(ArrayList listOfLift) {
        int lowestCount=999999999;
        int liftThatCarriedLeastInvestors=0;
        for (int i=1; i<=4; i++) {
            Lift thisLift=(Lift) listOfLift.get(i);
            if (thisLift.getInvestorsServed()<lowestCount) {
                lowestCount=thisLift.getInvestorsServed();
                liftThatCarriedLeastInvestors=i;
            }
        }
        return liftThatCarriedLeastInvestors;
    }

    // Lift which carried most song writers
    public int liftWhichCarriedMostSongWriters(ArrayList listOfLift) {
        int highestCount=0;
        int liftThatCarriedMostSongWriters=0;
        for (int i=1; i<=4; i++) {
            Lift thisLift=(Lift) listOfLift.get(i);
            if (thisLift.getSongWritersServed()>highestCount) {
                highestCount=thisLift.getSongWritersServed();
                liftThatCarriedMostSongWriters=i;
            }
        }
        return liftThatCarriedMostSongWriters;
    }
    
    // Lifts which carried least song writers
    public int liftWhichCarriedLeastSongWriters(ArrayList listOfLift) {
        int lowestCount=999999999;
        int liftThatCarriedLeastSongWriters=0;
        for (int i=1; i<=4; i++) {
            Lift thisLift=(Lift) listOfLift.get(i);
            if (thisLift.getSongWritersServed()<lowestCount) {
                lowestCount=thisLift.getSongWritersServed();
                liftThatCarriedLeastSongWriters=i;
            }
        }
        return liftThatCarriedLeastSongWriters;
    }
}
