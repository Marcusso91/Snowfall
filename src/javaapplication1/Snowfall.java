package javaapplication1;

import java.awt.*;
import java.io.*;
import java.util.*;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.*;
import sun.audio.*;



public class Snowfall extends javax.swing.JFrame {

    private int width, height;
    
    //Creating vector and put the ball objects in it
    private Vector<Ball> balls = new Vector<Ball>();

    public Snowfall() {

        initComponents();
        this.width = this.getWidth();
        this.height = this.getHeight();
        this.setVisible(true);
        Image img = Toolkit.getDefaultToolkit().getImage("pic/christmas.jpg");
        img.getScaledInstance(this.getWidth(), this.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon image = new ImageIcon(img);
        this.setContentPane(new JLabel(image));
        this.pack();
        this.setLocationRelativeTo(null);

        //Creating background music and running continuously
        AudioStream backgroundMusic;
        AudioData musicData;
        AudioPlayer musicPlayer = AudioPlayer.player;
        ContinuousAudioDataStream loop = null;
        // create an audiostream from the inputstream
        try {
            File file = new File("music/jingle-bells.wav");
            Clip clip = AudioSystem.getClip();
            AudioInputStream Audio = AudioSystem.getAudioInputStream(file);
            clip.open(Audio);
            clip.loop(Clip.LOOP_CONTINUOUSLY);

        } catch (LineUnavailableException | IOException | UnsupportedAudioFileException ex) {

            ex.printStackTrace();
        }

        for (int i = 0; i < 50; i++) {

            this.addBall();
        }
        while (true) {
            this.update();
        }
    }

    public void addBall() {

        Ball ball = new Ball(new Point((int) (Math.random() * this.width - 50) + 5, 4), (int) (Math.random() * 10) + 2);
        int ddx = (int) (Math.random() * 5) + 1;
        int ddy = (int) (Math.random() * 19) + 1;
        ball.setMotion(ddx, ddy);
        balls.add(ball);
    }

    public void paint(Graphics g) {

        super.paint(g);
        for (int i = 0; i < balls.size(); i++) {

            balls.get(i).paint(g);
        }
    }

    public void update() {

        for (int i = 0; i < this.balls.size(); i++) {

            Ball b = this.balls.get(i);
            b.move();
            Point loc = b.getLocation();
            if (loc.y > this.height + b.getRadius() || loc.x > this.width + b.getRadius()) {

                this.balls.remove(b);
                this.addBall();
            }
        }
        repaint();
        try {
            Thread.sleep(30);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }


    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Karácsonyi hóesés");
        setPreferredSize(new java.awt.Dimension(1365, 760));
        setResizable(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 685, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 325, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
