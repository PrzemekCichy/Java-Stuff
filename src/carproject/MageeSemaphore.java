package carproject;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.concurrent.*;
//MageeSemaphore.java
//This is an implementation of the traditional (counting) Semaphore with P() and V() operations
class MageeSemaphore 
{
   private Semaphore sem;
	
   public MageeSemaphore (int initialCount) 
   {
	sem = new Semaphore(initialCount, true);
   } // end constructor
	
   public void p() 
   {
	try {            
	    sem.acquire();
	} catch (InterruptedException ex) {
            System.out.println("Interrupted when waiting");
        }
   } // end P()
	
   public void v() 
   {
	sem.release();
   } // end V()
	
} // end MageeSemaphore

