//Spin thread for each car & generate car type and direction
            //Create 20 Cars
           
           //
            //Try to acquire a semaphore for first tile in car's way
           //roadTile[i].acquire();
            
            //Some tiles require additional semaphore since
            //only 3 cars can enter junction to avoid livelock
            
            //Test whether tile is junction and if so check whether junction 
            //can be acquired
            //junction.acquire();
            
            //Sleep for 0.5s on each tile
            
            //Print output
            
            //Repeat acquisition process for each tile
            
            
            //Aditional
            //Create car sprites
            //Create junction GUI
            //Add transitions
package carproject;

import java.awt.List;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.concurrent.*;

/**
 *
 * @author cef14cip
 */
public class Dispatcher extends Thread{
    private MageeSemaphore junction;//Up to 3     
    private MageeSemaphore[] roadTiles;//Up to 3  
    private int name;
    private String[] junctionString;
    private Activity activity;
                
    public Queue<Car> queue;
    
     public Dispatcher(MageeSemaphore junction, MageeSemaphore[] roadTiles, String[] junctionString, Activity activity, int name) 
     {
        this.junction = junction;        
        this.roadTiles = roadTiles;
        this.name = name;
        this.activity = activity;
        this.junctionString = junctionString;
        this.queue = new ArrayDeque<>();    
        
     }

     public void run() 
     {
         while(!this.queue.isEmpty()){
             this.junction.p();
             Car c = this.queue.remove();
             //Dispatcher.activity.addMessage("Car " + c.origin + 
             //        Integer.toString(c.index) + " is approaching the junction at section " 
             //                + c.tiles[0] + " going "  + c.direction + ".");
             
             for (int i = 0; i < c.tiles.length; i++) {
                this.roadTiles[c.tiles[i]].p();     
                //this.activity. slots[1]=”[…..]”
                
                
                String next = "";
                if(i + 1 != c.tiles.length){
                    next = Integer.toString(c.tiles[i+1]);
                }
                System.out.println("Translate" + c.tiles[i] + "," + next + " N:" + this.name);
                CarProject.gui.translateCar(c.tiles[i] + "," + next, this.name);
                
                System.out.println(c.origin + " " + c.index);
                if(i != 0){
                //    junctionString[c.tiles[i-1]] = "[..]";
                }
                
                
                //Dispatcher.activity.addMovedTo(i);
                //junctionString[c.tiles[i]] = "["+ c.origin + c.index + "]";
                //System.out.println(this.activity.roadJunctionString());
                CDS.idleQuietly(550);

                //Dispatcher.activity.printActivities();
                //Dispatcher.activity.addMessage("Message " + Integer.toString(i));                
                
                //SSystem.out.println(Dispatcher.activity.roadJunctionString());
                
                this.roadTiles[c.tiles[i]].v();
             }
             //junctionString[c.tiles[c.tiles.length-1]] = "[..]";
             //System.out.println(this.activity.roadJunctionString());
             //System.out.print("\n");
             //System.out.println(this.name + " released lock");
             this.junction.v();
             //System.out.println(this.name + " released lock");
         }
     } // end run
     
}
