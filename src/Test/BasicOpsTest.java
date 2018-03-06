/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Test;
 
import Visual.Display;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.embed.swing.SwingFXUtils;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.shape.ArcType;
import javafx.stage.Stage;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
 
public class BasicOpsTest extends Application {
 
    public static void main(String[] args) {
        launch(args);
    }
 
    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Drawing Operations Test");
        Group root = new Group();
        Canvas canvas = new Canvas(900, 900);
        GraphicsContext gc = canvas.getGraphicsContext2D();
        drawBackground(gc);
        root.getChildren().add(canvas);
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
        BufferedImage background = null;
        BufferedImage car = null;
        try {
            background = ImageIO.read(BasicOpsTest.class.getResource("Background1.png"));
            car = ImageIO.read(BasicOpsTest.class.getResource("Cars.png"));
        } catch (IOException ex) {
            
        }
        gc.drawImage(SwingFXUtils.toFXImage(background, null ), 0, 0);
        car = car.getSubimage(0, 0, 130, 115);
        gc.drawImage(SwingFXUtils.toFXImage(car, null ), 330, 15);  
        //car.
        
        
    }

    private void drawBackground(GraphicsContext gc) {
        Image image = new Image("file:///C:/Users/cef14cip/Downloads/Java-Stuff-master/Java-Stuff-master/src/Test/Background1.png");
        gc.drawImage(image, 0, 0);
    }
    private void drawCar(GraphicsContext gc) {
        Image cars = new Image("file:///C:/Users/cef14cip/Downloads/Java-Stuff-master/Java-Stuff-master/src/Test/Cars.png");
        //cars = cars.
        gc.drawImage(cars, 0, 0, 55, 55);
    }
}