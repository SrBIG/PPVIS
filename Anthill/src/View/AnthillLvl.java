package View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Ellipse2D;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class AnthillLvl extends JComponent{
    int frameHeight = 580;
    int frameWidth = 400;
    BufferedImage buffer;

    private int numOfAnts;
    private int maxAnts;
    private int radius;
    ArrayList angles = new ArrayList();
    float angle;

    public AnthillLvl() {
        setSize(frameWidth, frameHeight);
        setDoubleBuffered(true);
        //this.radius = radius;
        //this.maxAnts = maxAnts;
        //createAngles();
        angle = 0;
        Timer timer = new Timer(1, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                angle += 0.001;
                if (angle > 6.28) angle = 0;
                rebuildBuffer();
                repaint();
            }
        });
        timer.start();
    }

    private void rebuildBuffer(){
        int w = getWidth();
        int h = getHeight();
        buffer = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2d = buffer.createGraphics();
        int width = frameWidth;
        int height = frameHeight;
        g2d.setColor(Color.black);
        g2d.setStroke(new BasicStroke(1f));
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        g2d.draw(circle(width/2, height/2, 100));
        double x = width / 2;
        double y = height / 2;
        double r = 5;
        double an = angle;
        x += 100 * Math.cos(an);
        y += 100 * Math.sin(an);
        g2d.fill(circle(x, y, r));

        //g2d.draw(circle(width/2, height/2, 100));
        double x1 = width / 2;
        double y1= height / 2;
        double r1 = 5;
        double an1 = angle + 0.5;
        x1 += 100 * Math.cos(an1);
        y1 += 100 * Math.sin(an1);
        g2d.fill(circle(x1, y1, r1));
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (buffer == null) {
            rebuildBuffer();
        }
        g.drawImage(buffer, 0, 0, this);
    }

    private Shape circle(double x, double y, double r) {
        return new Ellipse2D.Double(x - r, y - r, 2 * r, 2 * r);
    }

    private void createAngles(){
        float angle = 0;
        float circumference = 6.28f;
        float step = circumference/maxAnts;
        for(int count = 0; count < maxAnts; count++){
            angles.add(angle);
            angle += step;
        }
    }

    public int getNumOfAnts(){
        return numOfAnts;
    }

    public void setNumOfAnts (int num){
        this.numOfAnts = num;
    }

    public int getMaxAnts() {
        return maxAnts;
    }

    public void setMaxAnts(int maxAnts) {
        this.maxAnts = maxAnts;
    }

    public boolean isFull(){
        if(numOfAnts == maxAnts) return true;
        else return false;
    }

}
