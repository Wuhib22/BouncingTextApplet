/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package chapter2_challenge_applet;
import java.applet.Applet;
import java.awt.Color;
import java.awt.Graphics;

public class BouncingTextApplet extends Applet implements Runnable {

    private String text;
    private int x;
    private Thread animator;
    private int width;

    @Override
    public void init() {
        setSize(400, 100);
        setBackground(Color.BLACK);
        text = "SOLOMON MOGES"; // Replace with your actual name
        x = 0;
        width = getWidth();
    }

    @Override
    public void start() {
        animator = new Thread(this);
        animator.start();
    }

    @Override
    public void stop() {
        animator = null;
    }

    @Override
    public void run() {
        while (Thread.currentThread() == animator) {
            x += 10;
            // Reset if text goes beyond right edge (approximate)
            if (x > width) {
                x = 0;
            }
            repaint();
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                // Ignore interruptions
            }
        }
    }

    @Override
    public void paint(Graphics g) {
        g.setColor(Color.WHITE);
        g.drawString(text, x, 50);
    }
}