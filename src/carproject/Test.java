import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class Test {

    public static void main(String[] args) {
        new Test();
    }

    public Test() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {   
                JFrame frame = new JFrame("Junction App");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.add(new BackgorundPane());
                //frame.pack();
                //frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }

    public class BackgorundPane extends JPanel {

        private BufferedImage img = null;

        public BackgorundPane() {
            try {
                img = ImageIO.read(Display.class.getResource("/carproject/71e.png"));
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }

        @Override
        public Dimension getPreferredSize() {
            return img == null ? new Dimension(200, 200) : new Dimension(img.getWidth(), img.getHeight());
        }

        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2d = (Graphics2D) g.create();
            if (img != null) {
                g2d.drawImage(img, 0, 0, this);
            }
            g2d.dispose();
        }
    }
    
        public class Cars extends JPanel {

        private BufferedImage img = null;

        public Cars() {
            try {
                img = ImageIO.read(Display.class.getResource("/carproject/71e.png"));
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }

        @Override
        public Dimension getPreferredSize() {
            return img == null ? new Dimension(200, 200) : new Dimension(img.getWidth(), img.getHeight());
        }

        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2d = (Graphics2D) g.create();
            if (img != null) {
                img = img.get
                g2d.drawImage(img, 0, 0, this);
            }
            g2d.dispose();
        }
    }
    
    
}