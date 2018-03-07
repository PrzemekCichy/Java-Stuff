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

    private HashMap<String, PathElement[]> transitions = new HashMap<String, PathElement[]>();
    private ImageView background = new ImageView();
    private ImageView[] carImg = new ImageView[4];

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        //Initialize images

        loadImages();

        populateTransitions();

        PathTransition[] anim = new PathTransition[4];
        for (int i = 0; i < 4; i++) {
            anim[i] = new PathTransition();
            anim[i].setNode(carImg[i]);
            anim[i].setOrientation(OrientationType.ORTHOGONAL_TO_TANGENT);
            anim[i].setInterpolator(Interpolator.LINEAR);
            anim[i].setDuration(new Duration(1500));
            anim[i].setCycleCount(122);
        }

        Group root = new Group();
        root.getChildren().addAll(background, carImg[0], carImg[1], carImg[2], carImg[3]);

        Path path0 = new Path();
        path0.getElements().addAll(transitions.get("0,1"));
        Path path1 = new Path();
        path1.getElements().addAll(transitions.get("1,2"));
        Path path2 = new Path();
        path2.getElements().addAll(transitions.get("2,3"));
        Path path3 = new Path();
        path3.getElements().addAll(transitions.get("1,9"));

        anim[0].setPath(path0);
        anim[1].setPath(path1);
        anim[2].setPath(path2);
        anim[3].setPath(path3);

        anim[0].play();
        anim[1].play();
        anim[2].play();
        anim[3].play();
        Scene scene = new Scene(root, 852, 855, Color.BLACK);

        primaryStage.setTitle("PathTransition Demo");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void loadImages() {
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
            new MoveTo(268, 348),
            new LineTo(351, 348)
        });
        transitions.put("1,2", new PathElement[]{
            new MoveTo(351, 348),
            new LineTo(435, 348)
        });
        transitions.put("2,3", new PathElement[]{
            new MoveTo(435, 348),
            new LineTo(515, 348)
        });
        transitions.put("3,", new PathElement[]{
            new MoveTo(515, 348),
            new LineTo(600, 348)
        });

        //Move Down
        transitions.put("10,2", new PathElement[]{
            new MoveTo(435, 268),
            new LineTo(435, 348),
            new ClosePath()
        });
        transitions.put("2,5", new PathElement[]{
            new MoveTo(435, 348),
            new LineTo(435, 429)
        });
        transitions.put("5,11", new PathElement[]{
            new MoveTo(435, 429),
            new LineTo(435, 515)
        });
        transitions.put("11,", new PathElement[]{
            new MoveTo(435, 515),
            new LineTo(351, 348)
        });

        //Move Left
        transitions.put("4,5", new PathElement[]{
            new MoveTo(515, 429),
            new LineTo(435, 429)
        });
        transitions.put("5,6", new PathElement[]{
            new MoveTo(435, 429),
            new LineTo(351, 429)
        });
        transitions.put("6,7", new PathElement[]{
            new MoveTo(351, 429),
            new LineTo(268, 429)
        });
        transitions.put("7,", new PathElement[]{
            new MoveTo(268, 429),
            new LineTo(351, 348)
        });

        //Move Up
        transitions.put("8,6", new PathElement[]{
            new MoveTo(351, 515),
            new LineTo(351, 429)
        });
        transitions.put("6,1", new PathElement[]{
            new MoveTo(351, 429),
            new LineTo(351, 348)
        });
        transitions.put("1,9", new PathElement[]{
            new MoveTo(351, 348),
            new LineTo(351, 268)
        });
        transitions.put("9,", new PathElement[]{
            new MoveTo(351, 268),
            new LineTo(351, 348)
        });
    }
}
