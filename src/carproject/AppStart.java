/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package carproject;

import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.stage.Stage;

public class AppStart extends Application {

    public static void main(String[] args) {
        launch(args);

        // TODO code application logic here
        System.out.println("Finished running ok");

    }

    @Override
    public void start(Stage primaryStage) {
        CarProject carApp = new CarProject();
        PathTDemo p = new PathTDemo();
        p.start(primaryStage);
                
        try {
            p.join();
        } catch (InterruptedException ex) {
            Logger.getLogger(AppStart.class.getName()).log(Level.SEVERE, null, ex);
        }
        CDS.idle(1000);
        
        carApp.start(p);
    }
    
}
