package Old;

import java.awt.image.BufferedImage;
import javax.swing.*;

public class Display {

    public Display() {
        ImageIcon icon = new ImageIcon(Display.class.getResource("/carproject/71e.png"));
        BufferedImage i = icon.getImage();
        JLabel label = new JLabel(icon);

        JFrame frame = new JFrame();
        frame.add(label);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationByPlatform(true);
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new Display();
            }
        });
    }
}