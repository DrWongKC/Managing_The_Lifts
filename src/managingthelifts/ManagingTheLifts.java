package managingthelifts;
import java.util.ArrayList;
import java.util.Scanner;

import java.util.TimerTask;
import java.util.Timer;
/**
 *
 * @author kaichong
 */
public class ManagingTheLifts {

    public static void main(String[] args) {
        
        // To accept user's input
        Scanner sc=new Scanner(System.in);
        
        // To keep statistics of program
        StatisticsSystem stats=new StatisticsSystem();
        
        // Seperate peopleWaitingForLift into the respective 4 Arraylist
        ArrayList waitingForLiftOne=new ArrayList();
        ArrayList waitingForLiftTwo=new ArrayList();
        ArrayList waitingForLiftThree=new ArrayList();
        ArrayList waitingForLiftFour=new ArrayList();
        
        // To run task at specified interval
        Timer simulatorTicker=new Timer();
        
        // ROOMS (50 Room instances)
        ArrayList<Room> listOfRooms=new ArrayList();
        listOfRooms.add(new Room(stats, 0));                    // skip index 0 (floor 0 doesn't exist)
        for (int i=0; i<50; i++) // Fill index of 1 to 50 inclusive, with Room
        {
            listOfRooms.add(new Room(stats, (i+1)));
        }
        
        // LIFT LOBBY (4 Lift instances)
        ArrayList<Lift> liftLobby=new ArrayList();
        liftLobby.add(new Lift(stats, listOfRooms));   // skip index 0 (lift 0 should not exist)
        for (int i=0;i<4; i++) { // Fill index of 1 to 4 inclusive, with Lift
            liftLobby.add(new Lift(stats, listOfRooms));
        }
        
        /*
        ** CODE BLOCKS
        */
        // Person of type requests to use lift
        TimerTask personWalksIntoBuilding=new TimerTask() {
            @Override
            public void run() {
                
                // Temporary variables
                Person thisPerson=new Person("some name", "some nric", "some type");
                String name;
                String nric;
                String answer;
                int designationNum;
                int floorToGo=0;
                
                // Retrieve designation number
                designationNum=stats.generateNumWithRange(1, 5);
                
                // Generic questions
                System.out.println("What is your name?");
                name=sc.nextLine();
                System.out.println("What is your nric?");
                nric=sc.nextLine();
                
                                            // HACKER
                                            if (designationNum==1) {
                                            System.out.println("What is your country of birth?");
                                            answer=sc.nextLine();
                                            thisPerson=new Hacker(name, nric, answer);
                                            // Floor to go (40-50)
                                            do {
                                                System.out.println("Which floor to go to? (between 40 and 50 inclusive only)");
                                                while (!sc.hasNextInt()) {
                                                    System.out.println("That's not a number!");
                                                    sc.next();
                                                }
                                                floorToGo=sc.nextInt();
                                                sc.nextLine();
                                            } while (floorToGo<40||floorToGo>50);
                                            // Update stats
                                            stats.increaseCountOfHackersEnteredBuilding();
                                            stats.increaseCountOfHackersWentToFloor(floorToGo);
                                            }
                
                                    // DELIVERY PERSON
                                    if (designationNum==2) {
                                    System.out.println("What type of food are you delivering?");
                                    answer=sc.nextLine();
                                    thisPerson=new DeliveryPerson(name, nric, answer);
                                    // Floor to go (2-30)
                                    do {
                                        System.out.println("Which floor to go to? (between 2 and 30 inclusive only)");
                                        while (!sc.hasNextInt()) {
                                            System.out.println("That's not a number!");
                                            sc.next();
                                        }
                                        floorToGo=sc.nextInt();
                                        sc.nextLine();
                                    } while (floorToGo<2||floorToGo>30);
                                    // Update stats
                                    stats.increaseCountOfDeliveryPersonsEnteredBuilding();
                                    stats.increaseCountOfDeliveryPersonsWentToFloor(floorToGo);
                                    }
                                        
                                                    // DEBT COLLECTOR
                                                    if (designationNum==3) {
                                                    System.out.println("Who is the person in debt?");
                                                    answer=sc.nextLine();
                                                    thisPerson=new DebtCollector(name, nric, answer);
                                                    // Floor to go (30-40)
                                                    do {
                                                        System.out.println("Which floor to go to? (between 30 and 40 inclusive only)");
                                                        while (!sc.hasNextInt()) {
                                                            System.out.println("That's not a number!");
                                                            sc.next();
                                                        }
                                                        floorToGo=sc.nextInt();
                                                    } while (floorToGo<30||floorToGo>40);
                                                    // Update stats
                                                    stats.increaseCountOfDebtCollectorsEnteredBuilding();
                                                    stats.increaseCountOfDebtCollectorsWentToFloor(floorToGo);
                                                    }
                                    
                                    // INVESTOR
                                    if (designationNum==4) {
                                    System.out.println("What company are you investing?");
                                    answer=sc.nextLine();
                                    thisPerson=new Investor(name, nric, answer);
                                    // Floor to go (30-50)
                                    do {
                                        System.out.println("Which floor to go to? (between 30 and 50 only)");
                                        while (!sc.hasNextInt()) {
                                            System.out.println("That's not a number!");
                                            sc.next();
                                        }
                                        floorToGo=sc.nextInt();
                                        sc.nextLine();
                                    } while (floorToGo<30||floorToGo>50);
                                    // Update stats
                                    stats.increaseCountOfInvestorsEnteredBuilding();
                                    stats.increaseCountOfInvestorsWentToFloor(floorToGo);
                                    }
                                                 
                                                // SONG WRITER
                                                if (designationNum==5) {
                                                System.out.println("What is the title of your song?");
                                                answer=sc.nextLine();
                                                thisPerson=new SongWriter(name, nric, answer);
                                                // Floor to go (1-20)
                                                do {
                                                    System.out.println("Which floor to go to? (between 1 and 20 only)");
                                                    while (!sc.hasNextInt()) {
                                                        System.out.println("That's not a number!");
                                                        sc.next();
                                                    }
                                                    floorToGo=sc.nextInt();
                                                    sc.nextLine();
                                                } while (floorToGo<1||floorToGo>20);
                                                // Update stats
                                                stats.increaseCountOfSongWritersEnteredBuilding();
                                                stats.increaseCountOfSongWritersWentToFloor(floorToGo);
                                                }

                    // Store floor into person
                    thisPerson.setFloor(floorToGo);
                    // Store person into list of people waiting for respective lift
                    int whichLift=stats.generateNumWithRange(1, 4);
                    if (whichLift==1) {
                        waitingForLiftOne.add(thisPerson);
                    }
                    if (whichLift==2) {
                        waitingForLiftTwo.add(thisPerson);
                    }
                    if (whichLift==3) {
                        waitingForLiftThree.add(thisPerson);
                    }
                    if (whichLift==4) {
                        waitingForLiftFour.add(thisPerson);
                    }
            }
        };
        
        // Random person requests to use lift
        TimerTask randomPersonWalksIntoBuilding=new TimerTask() {
            @Override
            public void run() {
                
                int randomNumberOfPeopleWhoEntered=stats.generateNumWithRange(5, 40);
                System.out.println(randomNumberOfPeopleWhoEntered+" people of type OTHERS entered the building.");
                for (int i=0;i<randomNumberOfPeopleWhoEntered; i++) {
                    
                    // random person arrives
                    Person thisPerson=new Person("RANDOM", "RANDOM", "OTHERS");
                    // random person chooses a random floor
                    int floor=stats.generateNumWithRange(1, 10);
                    thisPerson.setFloor(floor);
                    // Update stats
                    stats.increaseCountOfOthersEnteredBuilding();
                    stats.increaseCountOfOthersWentToFloor(floor);
                    // Store random person into list of people waiting for respective lift
                    int whichLift=stats.generateNumWithRange(1, 4);
                    if (whichLift==1) {
                        waitingForLiftOne.add(thisPerson);
                    }
                    if (whichLift==2) {
                        waitingForLiftTwo.add(thisPerson);
                    }
                    if (whichLift==3) {
                        waitingForLiftThree.add(thisPerson);
                    }
                    if (whichLift==4) {
                        waitingForLiftFour.add(thisPerson);
                    }
                    
                }
                
                
                
            }
        };
        
        // Lifts fetch person to respective rooms
        TimerTask fetchToRoom=new TimerTask() {
            @Override
            public void run() {
                    
                for (int i=1; i<=4; i++) {
                    if (liftLobby.get(i).getAvailability()==true) {
                        
                        if (i==1&&!waitingForLiftOne.isEmpty()) {
                            liftLobby.get(1).sendPersonsToLift(waitingForLiftOne);
                            waitingForLiftOne.clear();
                        }
                        if (i==2&&!waitingForLiftTwo.isEmpty()) {
                            liftLobby.get(2).sendPersonsToLift(waitingForLiftTwo);
                            waitingForLiftTwo.clear();
                        }
                        if (i==3&&!waitingForLiftThree.isEmpty()) {
                            liftLobby.get(3).sendPersonsToLift(waitingForLiftThree);
                            waitingForLiftThree.clear();
                        }
                        if (i==4&&!waitingForLiftFour.isEmpty()) {
                            liftLobby.get(4).sendPersonsToLift(waitingForLiftFour);
                            waitingForLiftFour.clear();
                        }
                    }
                }
                
            }
        };
        
        // Reset lifts
        TimerTask liftsBecomeAvailable=new TimerTask() {
            @Override
            public void run() {
                for (int i=1; i<=4; i++) {
                    liftLobby.get(i).resetLift();
                }
            }
        };
        
        // Check if anyone needs to leave
        TimerTask somePeopleLeaveBuilding=new TimerTask() {
            @Override
            public void run() {
                
                ArrayList peopleDone=new ArrayList();
                
                for (int i=0; i<50; i++) {
                    ArrayList temp;
                    temp=listOfRooms.get(i).removePersonsDoneInRoom();
                    while (!temp.isEmpty()) {
                        peopleDone.add(temp.remove(0));
                    }
                }
                
                if (!peopleDone.isEmpty()) {
                    System.out.println("People leaving is "+peopleDone.size());
                }
                
            }
        };
        
        // Prints out program statistics
        TimerTask haltSimulator=new TimerTask() {
            @Override
            public void run() {
                
                //
                System.out.println("The number of others who entered building is            : "+stats.getNumberOfOthersEnteredBuilding());
                // Number of hackers who entered building
                System.out.println("The number of hackers who entered building is           : "+stats.getNumberOfHackersEnteredBuilding());
                // Number of delivery persons who entered building
                System.out.println("The number of delivery persons who entered building is  : "+stats.getNumberOfDeliveryPersonsEnteredBuilding());
                // Number of debt collectors who entered building
                System.out.println("The number of debt collectors who entered building is   : "+stats.getNumberOfDebtCollectorsEnteredBuilding());
                // Number of investors who entered building
                System.out.println("The number of investors who entered building is         : "+stats.getNumberOfInvestorsEnteredBuilding());
                // Number of song writers who entered building
                System.out.println("The number of song writers who entered building is      : "+stats.getNumberOfSongWritersEnteredBuilding());
                
                // Number of persons by floor
                System.out.println("The number of persons at, ");
                for (int i=0; i<50; i++) {
                    System.out.println("- Floor "+(i+1)+" is                                : "+stats.getTotalNumberWhoWentToFloor(i+1));
                }
                
                // Number of person types by floor
                System.out.println("The number of persons by type at, ");
                for (int i=0; i<50; i++) {
                    // Others
                    System.out.println("- no. of others at Floor "+(i+1)+" is               : "+stats.getNumberOfOthersWentToFloor(i+1));
                    // Hackers
                    System.out.println("- no. of hackers at Floor "+(i+1)+" is              : "+stats.getNumberOfHackersWentToFloor(i+1));
                    // Delivery persons
                    System.out.println("- no. of delivery persons at Floor "+(i+1)+" is     : "+stats.getNumberOfDeliveryPersonsWentToFloor(i+1));
                    // Debt collectors
                    System.out.println("- no. of debt collectors at Floor "+(i+1)+" is      : "+stats.getNumberOfDebtCollectorsWentToFloor(i+1));
                    // Investors
                    System.out.println("- no. of investors at Floor "+(i+1)+" is            : "+stats.getNumberOfInvestorsWentToFloor(i+1));
                    // Song writers
                    System.out.println("- no. of song writers at Floor "+(i+1)+" is         : "+stats.getNumberOfSongWritersWentToFloor(i+1));
                }
                
                // Average amount of time spent by everyone
                System.out.println("The average amount of time spent by all people in the building is "+stats.getAverageTimeSpentByAll()+" milliseconds. ");
                
                // Most popular floor
                System.out.println("The most popular floor is                               : Floor "+stats.getMostPopularFloor()+". ");
                // Floor with most hackers
                System.out.println("The floor with the most hackers is                      : Floor "+stats.getFloorWithMostHackers()+". ");
                // Floor with most delivery persons
                System.out.println("The floor with the most delivery persons is             : Floor "+stats.getFloorWithMostDeliveryPersons()+". ");
                // Floor with most debt collectors
                System.out.println("The floor with the most debt collectors is              : Floor "+stats.getFloorWithMostDebtCollectors()+". ");
                // Floor with most investors
                System.out.println("The floor with the most investors is                    : Floor "+stats.getFloorWithMostInvestors()+". ");
                // Floor with most song writers
                System.out.println("The floor with the most song writers is                 : Floor "+stats.getFloorWithMostSongWriters()+". ");
                
                // Floors not used by anyone
                int floorsEmpty;
                System.out.println("The floors which are not used by anyone are: ");
                int floorsNotUsed=0;
                for (int i=0; i<50; i++) {
                    if (stats.getTotalNumberWhoWentToFloor(i+1)==0) {
                        System.out.println("- Floor "+(i+1));
                        floorsNotUsed++;
                    }
                }
                if (floorsNotUsed==0) {
                    System.out.println("- all Floors are used!");
                }
                
                // Lift which carried most people
                System.out.println("The lift that carried most people is lift with              : Lift ID-"+stats.liftWhichCarriedMostPeople(liftLobby));
                
                // Lift which carried most hackers
                System.out.println("The lift that carried most hackers is lift with             : Lift ID-"+stats.liftWhichCarriedMostHackers(liftLobby));
                
                // Lift which carried least hackers
                System.out.println("The lift that carried least hackers is lift with            : Lift ID-"+stats.liftWhichCarriedLeastHackers(liftLobby));
                
                // Lift which carried most delivery persons
                System.out.println("The lift that carried most delivery persons is lift with    : Lift ID-"+stats.liftWhichCarriedMostDeliveryPersons(liftLobby));
                
                // Lift which carried least delivery persons
                System.out.println("The lift that carried least delivery persons is lift with   : Lift ID-"+stats.liftWhichCarriedLeastDeliveryPersons(liftLobby));
                        
                // Lift which carried most debt collectors
                System.out.println("The lift that carried most debt collectors is lift with     : Lift ID-"+stats.liftWhichCarriedMostDebtCollectors(liftLobby));
                
                // Lift which carried least debt collectors
                System.out.println("The lift that carried least debt collectors is lift with    : Lift ID-"+stats.liftWhichCarriedLeastDebtCollectors(liftLobby));
                
                // Lift which carried most investors
                System.out.println("The lift that carried most investors is lift with           : Lift ID-"+stats.liftWhichCarriedMostInvestors(liftLobby));
                
                // Lift which carried least investors
                System.out.println("The lift that carried least investors is lift with          : Lift ID-"+stats.liftWhichCarriedLeastInvestors(liftLobby));
                
                // Lift which carried most song writers
                System.out.println("The lift that carried most song writers is lift with        : Lift ID-"+stats.liftWhichCarriedMostSongWriters(liftLobby));
                
                // Lifts which carried least song writers
                System.out.println("The lift that carried least song writers is lift with       : Lift ID-"+stats.liftWhichCarriedLeastSongWriters(liftLobby));
                
                // Stop simulator
                System.exit(0);
            }
        };
        
        /**
        * PROGRAM BEGINS HERE5
        */
        // Time in minutes taken to run program
        int runningMinutes;
        // Get user's input for how long simulator should run
        do {
            System.out.println("Please enter the number of minutes you'd like this simulator to run: (between 10 and 200 minutes only)");
            while (!sc.hasNextInt()) {
                System.out.println("Please enter the duration in number! (i.e. 50)");
                sc.next();
            }
            runningMinutes=sc.nextInt();
            sc.nextLine();
        } while (runningMinutes<10 || runningMinutes>200);
        System.out.println("The simulator will run for: "+runningMinutes+" minutes.");
        
            simulatorTicker.scheduleAtFixedRate(personWalksIntoBuilding, 0, 120000); // Every 2 minutes
            simulatorTicker.scheduleAtFixedRate(randomPersonWalksIntoBuilding, 1, 300000); // Every 5 minutes
            simulatorTicker.scheduleAtFixedRate(liftsBecomeAvailable, 2, 180000); // Every 3 minutes
            simulatorTicker.scheduleAtFixedRate(fetchToRoom, 3, 180000); // Every 3 minutes
            simulatorTicker.scheduleAtFixedRate(somePeopleLeaveBuilding, 4, 240000); // Every 4 minutes
            simulatorTicker.schedule(haltSimulator, (runningMinutes*60000)); // Executes at the end of specified runningMinutes
            
        /**
        * PROGRAM ENDS HERE
        */

        
        
    }
    
}
