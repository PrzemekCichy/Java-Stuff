/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package carproject;

/**
 *
 * @author Przemek
 */
public class CarProject {
    
    final int noOfCars = 20;	
    final int maxAllowed = 2;
    final int junctionSize = 12;
    
    public Car[] cars;
    public MageeSemaphore junction;//Up to 3     
    public MageeSemaphore[] roadTile; //Individual semaphores
    
    public static void main(String[] args) {
        CarProject start = new CarProject();
                start.init();       
        
        // TODO code application logic here
        System.out.println("ok");
    }   
    
    private void init() {   
        this.cars = new Car[noOfCars];
        this.junction = new MageeSemaphore(maxAllowed);
        this.roadTile = new MageeSemaphore[junctionSize];
        
        for(int i = 0; i < roadTile.length - 1; i++){
            System.out.println("road tile semaphore");
            roadTile[i] = new MageeSemaphore(1);
        }
        
    	for(int i = 0; i < noOfCars; i++)
        {
            cars[i] = new Car();
	    cars[i].start(); // starts the car thread
            //Spin thread for each car & generate car type and direction

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
        }       

    }     
    
    private void RenderGraphics(){
    
    }
       
}

