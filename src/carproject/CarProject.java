/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package carproject;

import java.nio.Buffer;

/**
 *
 * @author Przemek
 */
public class CarProject {
    
    int noOfCars = 20;	
    int maxAllowed = 3;
    
    public Car[] cars;
    public MageeSemaphore junction;//Up to 3 
    
    public MageeSemaphore[] tile; //Individual semaphores
    
    private void init() {
        
        this.junction = new MageeSemaphore[4]; 
        this.cars = new Car[noOfCars];
    
    	for(int i = 0; i < noOfCars; i++)
        {
            cars[i] = new Car();
	    cars[i].start(); // starts the car thread
        }    
        
        //Try to get junction for semaphore
    }    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        CarProject start = new CarProject();
        start.init();
        
        // TODO code application logic here
        System.out.println("ok");
    }    
}

