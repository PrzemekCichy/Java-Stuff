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
    private String name;
                
    public Queue<Car> queue;
    
     public Dispatcher(MageeSemaphore junction, MageeSemaphore[] roadTiles, String name) 
     {
        this.junction = junction;        
        this.roadTiles = roadTiles;
        this.name = name;

        this.queue = new ArrayDeque<>();    
        
     }

     public void run() 
     {
             this.junction.p();
             Car c = this.queue.remove();
             //Dispatcher.activity.addMessage("Car " + c.origin + 
             //        Integer.toString(c.index) + " is approaching the junction at section " 
             //                + c.tiles[0] + " going "  + c.direction + ".");
             
             for (int i = 0; i < c.tiles.length; i++) {
                this.roadTiles[c.tiles[i]].p();     
                //this.activity. slots[1]=”[…..]”
                
                System.out.println(this.name + " " +  c.tiles[i]);
                CDS.idleQuietly(500);
                //Dispatcher.activity.addMovedTo(i);

                //Dispatcher.activity.printActivities();
                //Dispatcher.activity.addMessage("Message " + Integer.toString(i));                
                
                //SSystem.out.println(Dispatcher.activity.roadJunctionString());
                
                this.roadTiles[c.tiles[i]].v();
             }
             //System.out.print("\n");
             //System.out.println(this.name + " released lock");
             this.junction.v();
             //System.out.println(this.name + " released lock");
         
     } // end run
}
