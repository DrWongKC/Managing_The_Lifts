package managingthelifts;

/**
 *
 * @author kaichong
 */
public class Person {
    
    // VARIABLES
    // Credentials
    private String name;    // Name
    private String nric;    // Nric
    private String type;    // Hacker, Delivery Person, Debt Collector, Investor, or Song Writer
    
    // TIME in milliseconds
    private long timeBefore;   // Time person leaves building
    private long timeAfter;
    private long timeDone;  // Time person should be done
    
    // FLOOR
    private int floor;      // Floor person is going to
    
    // CONSTRUCTOR
    public Person(String name, String nric, String type) {
        this.name=name;
        this.nric=nric;
        this.type=type;
    }
    
    // METHODS
    public String getName() {
        return name;
    }
    
    public String getNric() {
        return nric;
    }
    
    public String getType() {
        return type;
    }
    
    public String toString() {
        return "The name is "+name+" and the nric is "+nric;
    }
    
    // Floor
    public void setFloor(int floor) {
        this.floor=floor;
    }
    
    public int getFloor() {
        return floor;
    }
    
    // Time
    public void storeTimeBefore() {
        // Store time before entering building
        this.timeBefore=System.currentTimeMillis();
        
        // Store time person should be done
        if (this.type.equalsIgnoreCase("OTHERS")) {
            timeDone=timeBefore+(long)(Math.random()*900000)+300000;
        }
        if (this.type.equalsIgnoreCase("HACKER")) {
            timeDone=timeBefore+1800000;
        }
        if (this.type.equalsIgnoreCase("DELIVERYPERSON")) {
            timeDone=timeBefore+600000;
        }
        if (this.type.equalsIgnoreCase("DEBTCOLLECTOR")) {
            timeDone=timeBefore+300000;
        }
        if (this.type.equalsIgnoreCase("INVESTOR")) {
            timeDone=timeBefore+1200000;
        }
        if (this.type.equalsIgnoreCase("SONGWRITER")) {
            timeDone=timeBefore+900000;
        }
        
    }
    
    public long getTimeDone() {
        return timeDone;
    }
    
    public void storeTimeAfter() {
        this.timeAfter=System.currentTimeMillis();
    }
    
    public long getTimeSpent() {
        return timeAfter-timeBefore;
    }
    
}
