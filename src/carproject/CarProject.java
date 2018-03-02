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
    
    public static String[] junctionString = new String[12];
    public static Activity activity;

    
    public static void main(String[] args) {
        CarProject start = new CarProject();
        start.init();       
        
        // TODO code application logic here
        System.out.println("Finished running ok");
    }   
    
    private void init() {
        this.junction = new MageeSemaphore(3);        
        this.roadTiles = new MageeSemaphore[junctionSize];
        
        activity = new Activity(junctionString);
        
        
        for(int i = 0; i < junctionString.length; i++){
            junctionString[i] = "[..]";
        }
        System.out.println(this.activity.roadJunctionString());
        
        for(int i = 0; i < roadTiles.length; i++){
            System.out.println("road tile semaphore");
            roadTiles[i] = new MageeSemaphore(1);
        }
        
        this.DispatcherA = new Dispatcher(this.junction, this.roadTiles, "A");
        this.DispatcherB = new Dispatcher(this.junction, this.roadTiles, "B");
        this.DispatcherC = new Dispatcher(this.junction, this.roadTiles, "C");
        this.DispatcherD = new Dispatcher(this.junction, this.roadTiles, "D");        
                
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
        
        
        
    }     
        
    private void RenderGraphics(){
    
    }
    
}

