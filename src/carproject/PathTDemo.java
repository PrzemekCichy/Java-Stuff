/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package carproject;

/**
 *
 * @author b00662244
 */
import Test.BasicOpsTest;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.CountDownLatch;
import javafx.animation.Animation;
import javafx.animation.Interpolator;
import javafx.animation.PathTransition;
import javafx.animation.PathTransition.OrientationType;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.embed.swing.SwingFXUtils;
import javafx.scene.Group;
import javafx.scene.Scene;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;

import javafx.scene.shape.ArcTo;
import javafx.scene.shape.ClosePath;
import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.scene.shape.PathElement;
import javafx.stage.Stage;
import javafx.util.Duration;
import javax.imageio.ImageIO;

public class PathTDemo extends Thread{

    private HashMap<String, PathElement[]> transitions = new HashMap<String, PathElement[]>();
    private ImageView background = new ImageView();
    private ImageView[] carImg = new ImageView[4];
    private PathTransition[] anim = new PathTransition[4];
   
    public synchronized void start(Stage primaryStage) {
        //Initialize images

        loadImages();

        populateTransitions();
        
        createNodes();

        Group root = new Group();
        root.getChildren().addAll(background, carImg[0], carImg[1], carImg[2], carImg[3]);
        
        Scene scene = new Scene(root, 852, 855, Color.BLACK);
        primaryStage.setTitle("Junction Demo");
        primaryStage.setScene(scene);
        primaryStage.show();         
    }

    public void translateCar(String coordinates, int direction){
        System.out.println("Deirection " + direction);
        Path path0 = new Path();
        path0.getElements().addAll(transitions.get(coordinates));
        anim[direction].stop();
        anim[direction].setPath(path0);
        anim[direction].play();
    }
    
    private void loadImages() {
        try {
            background.setImage(SwingFXUtils.toFXImage(ImageIO.read(BasicOpsTest.class.getResource("Background1.png")), null));
            BufferedImage car = ImageIO.read(BasicOpsTest.class.getResource("Cars.png"));

            for (int i = 0; i < 4; i++) {
                BufferedImage tempCar = car.getSubimage(104 * i, 208, 104, 100);
                carImg[i] = new ImageView();
                carImg[i].setImage(SwingFXUtils.toFXImage(tempCar, null));
            }
        } catch (IOException ex) {

        }
    }

    private void createNodes(){
            for (int i = 0; i < 4; i++) {
            anim[i] = new PathTransition();
            anim[i].setNode(carImg[i]);
            anim[i].setOrientation(OrientationType.ORTHOGONAL_TO_TANGENT);
            anim[i].setInterpolator(Interpolator.LINEAR);
            anim[i].setDuration(new Duration(500));
            anim[i].setCycleCount(0);
        }
    }
    
    private void populateTransitions() {
        //0
        //268,348
        //1
        //351,348
        //2
        //435,348
        //3
        //515,348
        //4
        //515,429
        //5
        //435,429
        //6
        //351,429
        //7
        //268,429
        //8
        //351,515
        //9
        //351,268
        //10
        //435,268
        //11
        //435,515

        //Move Right
        transitions.put("0,1", new PathElement[]{
            new MoveTo(298, 398),
            new LineTo(381, 398)
        });
        transitions.put("1,2", new PathElement[]{
            new MoveTo(381, 398),
            new LineTo(465, 398)
        });
        transitions.put("2,3", new PathElement[]{
            new MoveTo(465, 398),
            new LineTo(545, 398)
        });
        transitions.put("3,", new PathElement[]{
            new MoveTo(545, 398),
            new LineTo(630, 398)
        });

        //Move Down
        transitions.put("10,2", new PathElement[]{
            new MoveTo(465, 318),
            new LineTo(465, 398)
        });
        transitions.put("2,5", new PathElement[]{
            new MoveTo(465, 398),
            new LineTo(465, 479)
        });
        transitions.put("5,11", new PathElement[]{
            new MoveTo(465, 479),
            new LineTo(465, 565)
        });
        transitions.put("11,", new PathElement[]{
            new MoveTo(465, 565),
            new LineTo(465, 655)
        });

        //Move Left
        transitions.put("4,5", new PathElement[]{
            new MoveTo(545, 479),
            new LineTo(465, 479)
        });
        transitions.put("5,6", new PathElement[]{
            new MoveTo(465, 479),
            new LineTo(361, 479)
        });
        transitions.put("6,7", new PathElement[]{
            new MoveTo(361, 479),
            new LineTo(271, 479)
        });
        transitions.put("7,", new PathElement[]{
            new MoveTo(271, 479),
            new LineTo(181, 479)
        });

        //Move Up
        transitions.put("8,6", new PathElement[]{
            new MoveTo(381, 565),
            new LineTo(381, 479)
        });
        transitions.put("6,1", new PathElement[]{
            new MoveTo(381, 479),
            new LineTo(381, 389)
        });
        transitions.put("1,9", new PathElement[]{
            new MoveTo(381, 389),
            new LineTo(381, 299)
        });
        transitions.put("9,", new PathElement[]{
            new MoveTo(381, 299),
            new LineTo(381, 209)
        });
    }
}
