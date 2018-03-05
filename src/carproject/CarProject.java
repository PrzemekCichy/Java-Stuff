package carproject;

public class CarProject {
    
    final int noOfCars = 100;	
    final int maxAllowed = 3;
    final int junctionSize = 12;
    
    private MageeSemaphore junction;//Up to 3     
    private MageeSemaphore[] roadTiles; //Individual semaphores
    
    private Dispatcher DispatcherA;
    private Dispatcher DispatcherB;
    private Dispatcher DispatcherC;
    private Dispatcher DispatcherD;
    
    public String[] junctionString = new String[junctionSize];
    public Activity activity;

    
    public static void main(String[] args) {
        CarProject start = new CarProject();
        start.init();       
        
        // TODO code application logic here
        System.out.println("Finished running ok");
    }   
    
    private void init() {
        this.junction = new MageeSemaphore(maxAllowed);        
        this.roadTiles = new MageeSemaphore[this.junctionSize];
        
        this.activity = new Activity(this.junctionString);
        
        
        for(int i = 0; i < this.junctionString.length; i++){
            this.junctionString[i] = "[..]";
        }        
        
        for(int i = 0; i < this.roadTiles.length; i++){
            System.out.println("road tile semaphore");
            this.roadTiles[i] = new MageeSemaphore(1);
        }
        
        this.DispatcherA = new Dispatcher(junction,  roadTiles, junctionString, activity, "A");
        this.DispatcherB = new Dispatcher(junction, roadTiles, junctionString, activity, "B");
        this.DispatcherC = new Dispatcher(junction, roadTiles, junctionString, activity, "C");
        this.DispatcherD = new Dispatcher(junction, roadTiles, junctionString, activity, "D");        
                
    	for(int i = 0; i < noOfCars; i++)
        {
            Car car = new Car(i);
            switch(car.tiles[0]){
                case 8: 
                    this.DispatcherA.queue.add(car); 
                    break;
                case 0: 
                    this.DispatcherB.queue.add(car);
                    break;
                case 10: 
                    this.DispatcherC.queue.add(car);
                    break;
                case 4: 
                    this.DispatcherD.queue.add(car);
                    break;
            } 
        }
        //this.DispatcherA.activity.printActivities();
        
        this.DispatcherA.start();
        this.DispatcherB.start();
        this.DispatcherC.start();
        this.DispatcherD.start();  
        
        try{
        this.DispatcherA.join();
        this.DispatcherB.join();
        this.DispatcherC.join();
        this.DispatcherD.join();
        } catch(Exception e){
        
        }
        
        System.out.println(this.activity.roadJunctionString());
        
    }     
        
    private void RenderGraphics(){
    
    }
    
}

