/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Test;

/**
 *
 * @author b00662244
 */
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
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

public class PathTDemo extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        //Initialize images
        ImageView background = new ImageView();
        ImageView[] carImg = new ImageView[4];

        try {
            background.setImage(SwingFXUtils.toFXImage(ImageIO.read(BasicOpsTest.class.getResource("Background1.png")), null));
            BufferedImage car = ImageIO.read(BasicOpsTest.class.getResource("Cars.png"));

            for (int i = 0; i < 4; i++) {
                BufferedImage tempCar = car;//.getSubimage(104 * i, 208, 104, 100);
                carImg[i] = new ImageView();
                carImg[i].setImage(SwingFXUtils.toFXImage(tempCar, null));
            }

        } catch (IOException ex) {

        }

        //Create paths between tiles
        //ArrayList<PathElement[]> paths = new ArrayList<PathElement[]>();        
        PathElement[] path = {
            new MoveTo(0, 0),
            new LineTo(0, 0),
            new LineTo(0, 400),
            new LineTo(400, 400),
            new LineTo(400, 0),
            new LineTo(0, 0),
            new ClosePath()
        };
        
        Path road = new Path();
        road.setStroke(Color.BLACK);
        road.setStrokeWidth(75);
        road.getElements().addAll(path);

        HashMap<String,PathElement[]> transitions = new HashMap<String, PathElement[]>();
        
        transitions.put("01", new PathElement[] {
            new MoveTo(0, 0),
            new LineTo(0, 0),
            new LineTo(0, 400),
            new LineTo(400, 400),
            new LineTo(400, 0),
            new LineTo(0, 0),
            new ClosePath()
        });
        
        PathElement[] path01 = {
            new MoveTo(0, 0),
            new LineTo(0, 0),
            new LineTo(0, 400),
            new LineTo(400, 400),
            new LineTo(400, 0),
            new LineTo(0, 0),
            new ClosePath()
        };


        //0
        carImg[1].setX(268);
        carImg[1].setY(348);
        carImg[1].setRotate(270);
        
        //1
        carImg[0].setX(351);
        carImg[0].setY(348);
        carImg[0].setRotate(270);
        
        //2
        carImg[2].setX(435);
        carImg[2].setY(348);
        carImg[2].setRotate(270);
        
        //3
        carImg[2].setX(515);
        carImg[2].setY(348);
        carImg[2].setRotate(270);
        
        //4
        carImg[3].setX(515);
        carImg[3].setY(429);
        carImg[3].setRotate(270);
    
        //5
        carImg[3].setX(435);
        carImg[3].setY(429);
        carImg[3].setRotate(270);

        //6
        carImg[3].setX(351);
        carImg[3].setY(429);
        carImg[3].setRotate(270);
        
        //7
        carImg[3].setX(268);
        carImg[3].setY(429);
        carImg[3].setRotate(270);        

        //8
        carImg[3].setX(351);
        carImg[3].setY(515);
        carImg[3].setRotate(270);

        //9
        carImg[2].setX(351);
        carImg[2].setY(268);
        carImg[2].setRotate(270);
        
        
        //11
        carImg[3].setX(435);
        carImg[3].setY(515);
        carImg[3].setRotate(270);    
        
        PathTransition[] anim = new PathTransition[4];
        for (int i = 0; i < 4; i++) {
            anim[i] = new PathTransition();
            anim[i].setNode(carImg[i]);
            anim[i].setPath(road);
            anim[i].setOrientation(OrientationType.ORTHOGONAL_TO_TANGENT);
            anim[i].setInterpolator(Interpolator.LINEAR);
            anim[i].setDuration(new Duration(500));
            anim[i].setCycleCount(0);
        }

        Group root = new Group();
        root.getChildren().addAll(background, carImg[0], carImg[1], carImg[2], carImg[3]);

        
        
        root.setOnMouseClicked(me  -> {            
            if (Math.random() < 0.5) {
                PathElement[] newPath = {
                    new MoveTo(0, 0),
                    new LineTo(0, 0),
                    new LineTo(0, 200)
                };
                Path newRoad = new Path();
                newRoad.getElements().addAll(newPath);

                System.out.println("Ayy lmao 89");
                anim[0].stop();
                anim[0].setPath(newRoad);
                anim[0].play();
            } else {

                PathElement[] newPath1 = {
                    new MoveTo(0, 200),
                    new LineTo(0, 200),
                    new LineTo(200, 200)
                };
                Path newRoad1 = new Path();
                newRoad1.getElements().addAll(newPath1);

                System.out.println("Ayy lmao 89");
                anim[0].stop();
                anim[0].setPath(newRoad1);
                anim[0].play();

            }
        });

        //anim.play();
        //anim[0].play();
        //anim[1].play();
        //anim[2].play();
        //anim[3].play();

        Scene scene = new Scene(root, 852, 855, Color.BLACK);

        primaryStage.setTitle("PathTransition Demo");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
