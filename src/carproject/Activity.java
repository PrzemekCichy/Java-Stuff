package carproject;

import java.util.concurrent.CopyOnWriteArrayList;
import java.util.Iterator;

// Represents the road junction activity in a thread-safe CopyOnWriteArrayList<String>
// called theActivities
// - addMovementTo(<Integer>) adds a car movement (destination) activity to the record
// - addMessage(<String>) adds a message to the record 
// - printActivities() display all the activity history of the car movement
// - roadJunctionString() takes a snapshot of the road junction (with cars) for printing

public class Activity {

    private final CopyOnWriteArrayList<String> theActivities;

    private final String[] roadJunction;

    // Constructor for objects of class Activity
    // A reference to the roadJunctionis passed as a parameter
    public Activity(String[] roadJunction) {
        theActivities = new CopyOnWriteArrayList<>();
        this.roadJunction = roadJunction;
    }

    public void addMovedTo(int section) {
        // add an activity message to the activity history
        String tempString1 = "Car" + roadJunction[section] + " moved to [" + section + "]";
        theActivities.add(tempString1);
        // add the current state of the road junction to the activity history
        theActivities.add(roadJunctionString());
    }// end addMovedTo  

    public void addMessage(String message) {
        // add an activity message to the activity history
        String tempString1 = message;
        theActivities.add(tempString1);
    }// end addMessage  

    public void printActivities() {
        // print all the road junction activity history	
        System.out.println("ROAD JUNCTION ACTIVITY");
        System.out.println("---- -------- --------");
        
        Iterator<String> iterator = theActivities.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }// end printActivities

    // Utility method to represent the road junction as a string for printing/display
    public String roadJunctionString() {
        String roadJunctionStateAsString = "    " + roadJunction[9] + roadJunction[10] + "\n"
                + roadJunction[0] + roadJunction[1] + roadJunction[2] + roadJunction[3] + "\n"
                + roadJunction[7] + roadJunction[6] + roadJunction[5] + roadJunction[4] + "\n"
                                  + "    " + roadJunction[8] + roadJunction[11] + "\n";
        return (roadJunctionStateAsString);
    }// end roadJunctionString

}// end Activity
