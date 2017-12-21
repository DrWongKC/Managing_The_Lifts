package managingthelifts;
import java.util.ArrayList;
/**
 *
 * @author kaichong
 */
public class Room {

    private StatisticsSystem stats;
    
    private Queue hackersInRoom;
    private Queue deliveryPersonsInRoom;
    private Queue debtCollectorsInRoom;
    private Queue investorsInRoom;
    private Queue songWritersInRoom;
    
    private Queue othersInRoom;
    
    private int roomFloor;
    
    public Room(StatisticsSystem stats, int floor) {
        this.roomFloor=floor;
        
        this.hackersInRoom=new Queue(100);
        this.deliveryPersonsInRoom=new Queue(100);
        this.debtCollectorsInRoom=new Queue(100);
        this.investorsInRoom=new Queue(100);
        this.songWritersInRoom=new Queue(100);
        
        this.othersInRoom=new Queue(10000);
        
        this.stats=stats;
    }
    
    public int getRoomFloor() {
        return roomFloor;
    }
    
    public void addPersonToRoom(Person p) {
        if (p.getType().equalsIgnoreCase("OTHERS")) {
            p.storeTimeBefore();
            this.othersInRoom.enqueue(p);
        }
        if (p.getType().equalsIgnoreCase("HACKER")) {
            p.storeTimeBefore();
            this.hackersInRoom.enqueue(p);
        }
        if (p.getType().equalsIgnoreCase("DELIVERYPERSON")) {
            p.storeTimeBefore();
            this.deliveryPersonsInRoom.enqueue(p);
        }
        if (p.getType().equalsIgnoreCase("DEBTCOLLECTOR")) {
            p.storeTimeBefore();
            this.debtCollectorsInRoom.enqueue(p);
        }
        if (p.getType().equalsIgnoreCase("INVESTOR")) {
            p.storeTimeBefore();
            this.investorsInRoom.enqueue(p);
        }
        if (p.getType().equalsIgnoreCase("SONGWRITER")) {
            p.storeTimeBefore();
            this.songWritersInRoom.enqueue(p);
        }
    }
    
    public ArrayList removePersonsDoneInRoom() {
        // METHOD variables
        ArrayList peopleWhoExited=new ArrayList();
        Person temp;
        Person innerTemp;
        
        // OTHERS
        if (!othersInRoom.isEmpty()) {
            temp=(Person) othersInRoom.peek();
            while (temp.getTimeDone()<System.currentTimeMillis()) {
                innerTemp=(Person) othersInRoom.dequeue();
                innerTemp.storeTimeAfter();
                stats.addToTimeSpentByAllInMilliseconds(innerTemp.getTimeSpent());
                peopleWhoExited.add(innerTemp);
                if (!othersInRoom.isEmpty()) {
                    temp=(Person) othersInRoom.peek();
                } else {
                    break;
                }
            }
        }
        
        // HACKERS
        if (!hackersInRoom.isEmpty()) {
            temp=(Person) hackersInRoom.peek();
            while (temp.getTimeDone()<System.currentTimeMillis()) {
                    innerTemp=(Person) hackersInRoom.dequeue();
                    innerTemp.storeTimeAfter();
                    stats.addToTimeSpentByAllInMilliseconds(innerTemp.getTimeSpent());
                    peopleWhoExited.add(innerTemp);
                if (!hackersInRoom.isEmpty()) {
                    temp=(Person) hackersInRoom.peek();
                } else {
                    break;
                }
            }
        }
        
        // DELIVERY PERSONS
        if (!deliveryPersonsInRoom.isEmpty()) {
            temp=(Person) deliveryPersonsInRoom.peek();
            while (temp.getTimeDone()<System.currentTimeMillis()) {
                    innerTemp=(Person) deliveryPersonsInRoom.dequeue();
                    innerTemp.storeTimeAfter();
                    stats.addToTimeSpentByAllInMilliseconds(innerTemp.getTimeSpent());
                    peopleWhoExited.add(innerTemp);
                if (!deliveryPersonsInRoom.isEmpty()) {
                    temp=(Person) deliveryPersonsInRoom.peek();
                } else {
                    break;
                }
            }
        }
        
        // DEBT COLLECTORS
        if (!debtCollectorsInRoom.isEmpty()) {
            temp=(Person) debtCollectorsInRoom.peek();
            while (temp.getTimeDone()<System.currentTimeMillis()) {
                    innerTemp=(Person) debtCollectorsInRoom.dequeue();
                    innerTemp.storeTimeAfter();
                    stats.addToTimeSpentByAllInMilliseconds(innerTemp.getTimeSpent());
                    peopleWhoExited.add(innerTemp);
                if (!debtCollectorsInRoom.isEmpty()) {
                    temp=(Person) debtCollectorsInRoom.peek();
                } else {
                    break;
                }
            }
        }
        
        // INVESTORS
        if (!investorsInRoom.isEmpty()) {
            temp=(Person) investorsInRoom.peek();
            while (temp.getTimeDone()<System.currentTimeMillis()) {
                    innerTemp=(Person) investorsInRoom.dequeue();
                    innerTemp.storeTimeAfter();
                    stats.addToTimeSpentByAllInMilliseconds(innerTemp.getTimeSpent());
                    peopleWhoExited.add(innerTemp);
                if (!investorsInRoom.isEmpty()) {
                    temp=(Person) investorsInRoom.peek();
                } else {
                    break;
                }
            }
        }
        
        // SONG WRITERS
        if (!songWritersInRoom.isEmpty()) {
            temp=(Person) songWritersInRoom.peek();
            while (temp.getTimeDone()<System.currentTimeMillis()) {
                    innerTemp=(Person) songWritersInRoom.dequeue();
                    innerTemp.storeTimeAfter();
                    stats.addToTimeSpentByAllInMilliseconds(innerTemp.getTimeSpent());
                    peopleWhoExited.add(innerTemp);
                if (!songWritersInRoom.isEmpty()) {
                    temp=(Person) songWritersInRoom.peek();
                } else {
                    break;
                }
            }
        }
        
        return peopleWhoExited;
    }
    
}
 