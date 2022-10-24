/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simplecargame;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 *
 * @author saliya
 */
public class Ui extends javax.swing.JFrame implements KeyListener {

    private Dimension FRAME_SIZE;

    private BufferedImage BUFFERED_IMAGE = new BufferedImage(50, 50, BufferedImage.TYPE_INT_RGB);

    private Graphics2D G2D;

    private static String imagesPath = "src/res/";

    int CAR_POSITION_X, CAR_POSITION_Y;

    int ROAD_X, ROAD_Y;

    boolean P = false;

    /**
     * Creates new form Ui
     */
    public Ui() {
        initComponents();
        addKeyListener(this);
        FRAME_SIZE = this.getContentPane().getSize();

        ROAD_X = ROAD_Y = -999;
        CAR_POSITION_X = CAR_POSITION_Y = 300;

        updater();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("simple Car Game");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 485, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 469, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Ui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Ui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Ui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Ui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new Ui().setVisible(true);
        });
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        P = true;
        movecar(e);

    }

    @Override
    public void keyReleased(KeyEvent e) {
        P = false;
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
  @Override
    public void paint(Graphics g) {
        update(g);
    }

    @Override
    public void update(Graphics g) {
        Graphics2D G2 = (Graphics2D) g;
        G2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        BufferedImage road = null;
        BufferedImage cross_road = null;
        BufferedImage car = null;
        try {
            road = ImageIO.read(new File(imagesPath + "1.png"));
            cross_road = ImageIO.read(new File(imagesPath + "2.png"));
            car = ImageIO.read(new File(imagesPath + "3.png"));
        } catch (IOException ex) {

        }
        int scaleXroad = (int) (road.getWidth());
        int scaleYroad = (int) (road.getHeight());

        int scaleXcroad = (int) (cross_road.getWidth());
        int scaleYcroad = (int) (cross_road.getHeight());

        int scaleXcar = (int) (car.getWidth());
        int scaleYcar = (int) (car.getHeight());

        Image image_road = road.getScaledInstance(scaleXroad, scaleYroad, Image.SCALE_SMOOTH);

        Image image_cross_road = cross_road.getScaledInstance(scaleXcroad, scaleYcroad, Image.SCALE_SMOOTH);

        Image image_car = car.getScaledInstance(scaleXcar, scaleYcar, Image.SCALE_SMOOTH);

        BUFFERED_IMAGE = (BufferedImage) createImage(FRAME_SIZE.width, FRAME_SIZE.height);

        BUFFERED_IMAGE.getGraphics().drawImage(image_road, 0, 0, null);

        if (ROAD_Y >= -499 && ROAD_X >= -499) {
            BUFFERED_IMAGE.getGraphics().drawImage(image_cross_road, ROAD_X, ROAD_Y, null);
        }

        BUFFERED_IMAGE.getGraphics().drawImage(image_car, CAR_POSITION_X, CAR_POSITION_Y, null);

        G2D = BUFFERED_IMAGE.createGraphics();

        G2.drawImage(BUFFERED_IMAGE, 0, 0, this);

    }

    int count = 1, c = 1;

    public void movecar(KeyEvent e) {

        Thread KEP = new Thread(() -> {
            while (P) {
                switch (e.getKeyCode()) {
                    case KeyEvent.VK_UP:
                        if (CAR_POSITION_Y < 16) {
                            return;
                        }
                        CAR_POSITION_Y = CAR_POSITION_Y - 2;

                        break;
                    case KeyEvent.VK_DOWN:
                        if (CAR_POSITION_Y > 328) {
                            return;
                        }
                        CAR_POSITION_Y = CAR_POSITION_Y + 2;
                        break;
                    case KeyEvent.VK_LEFT:
                        if (CAR_POSITION_X < 110) {
                            return;
                        }
                        CAR_POSITION_X = CAR_POSITION_X - 2;

                        break;
                    case KeyEvent.VK_RIGHT:
                        if (CAR_POSITION_X > 310) {
                            return;
                        }
                        CAR_POSITION_X = CAR_POSITION_X + 2;
                        break;
                    default:
                        break;
                }
                try {
                    Thread.sleep(5);
                } catch (InterruptedException ex) {

                }

            }
        });
        KEP.start();

    }

    public void updater() {
        Thread GT = new Thread(() -> {
            for (;;) {
                this.moveRoad(count);
                while (c <= 1) {
                    this.repaint();
                    try {
                        Thread.sleep(5);
                    } catch (Exception e) {
                        System.out.println(e);
                    }
                    c++;
                }
                c = 1;
                count++;

            }
        });
        GT.start();

    }

    void moveRoad(int count) {
        if (ROAD_X == -999 && ROAD_Y == -999) {
            if (count % 10 == 0) {
                ROAD_X = 0;
                ROAD_Y = -499;
            }
        } else {
            ROAD_Y++;
        }
        if (ROAD_X == 0 && ROAD_Y == 499) {
            ROAD_X = ROAD_Y = -999;
        }

    }
}
