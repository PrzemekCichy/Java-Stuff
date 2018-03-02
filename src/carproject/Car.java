/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package carproject;

import java.util.*;


/**
 *
 * @author Przemek
 */
public class Car {

    public static enum Origins {
        A,
        B,
        C,
        D
    }
        
    public static enum Directions {
        FORWARD,
        LEFT,
        RIGHT
    }
    
    private static final Random RANDOM = new Random();
    private static final Directions[] DIRECTION = Directions.values();
    private static final Origins[] ORIGIN = Origins.values();
    
    public static Directions randomDirection()  {
      return DIRECTION[RANDOM.nextInt(3)];
    }
    
    public static Origins randomOrigin()  {
      return ORIGIN[RANDOM.nextInt(4)];
    }
  
    public final Origins origin; 
    public final Directions direction;
    public int[] tiles;
    public int index;
    
    public Car(int index){        
        this.origin = randomOrigin();
        this.direction = randomDirection();        
        this.tiles = GetTiles(randomOrigin(), randomDirection());
        this.index = index;
    }
        
    private int[] GetTiles(Origins origin, Directions direction){
        switch(origin){
         case A: 
            switch(direction){
                case LEFT: 
                    return new int[]{8, 6, 7};                
                case RIGHT: 
                    return new int[]{8, 6, 1, 2, 3};                   
                case FORWARD: 
                    return new int[]{8, 6, 1, 9};                   
            }          
         case B:
            switch(direction){
                case LEFT: 
                    return new int[]{0, 1, 9};                
                case RIGHT: 
                    return new int[]{0, 1, 2, 5, 11};                   
                case FORWARD: 
                    return new int[]{0, 1, 2, 3};                   
            }              
         case C:
            switch(direction){
                case LEFT: 
                    return new int[]{10, 2, 3};                
                case RIGHT: 
                    return new int[]{10, 2, 5, 6, 7};                   
                case FORWARD: 
                    return new int[]{10, 2, 5, 11};                   
            }    
         case D:
            switch(direction){
                case LEFT: 
                    return new int[]{4, 5, 11};                
                case RIGHT: 
                    return new int[]{4, 5, 6, 1, 9};                   
                case FORWARD: 
                    return new int[]{4, 5, 6, 7};                   
            }            
        }
        System.out.println("Could not determine the direction or origin of the car " + direction + " " + origin);
        return null;
    }    
}
