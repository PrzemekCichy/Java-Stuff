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
        }       
        //roadTile[i].acquire();
        //junction.acquire();
        //Try to get junction for semaphore
    }     
    
    private void RenderGraphics(){
    
    }
       
}

//Car A B C
//FORWARD LEFT RIGHT

//ENTER TILE