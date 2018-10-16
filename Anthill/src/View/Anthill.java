package View;

import Model.AntP;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Ellipse2D;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class Anthill extends JComponent{
    private java.util.List<AntP> ants = new ArrayList<>();
    private BufferedImage buffer;
    private int radius;
    private AntP awayAnt = null;

    public Anthill(int radius) {
        this.radius = radius;
        setSize(400, 600);
        Timer timer = new Timer(40, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                rebuildBuffer();
                repaint();
            }
        });
        timer.start();
    }

    private void rebuildBuffer(){
        int width = getWidth();
        int height = getHeight();
        int xCenter = width/2;
        int yCenter = height/2;
        buffer = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2d = buffer.createGraphics();
        g2d.setColor(Color.black);
        g2d.setStroke(new BasicStroke(1f));
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        g2d.draw(circle(xCenter, yCenter, radius));

        for(AntP ant : ants){
            int xAnt = ant.getX();
            int yAnt = ant.getY();
            int sizeAnt = ant.getSize();

            if (ant.isNeedAway()){
                if(ant.isAway()){
                    awayAnt = ant;
                    continue;
                }
                ant.goAway(xCenter, height);
                g2d.fill(circle(xAnt, yAnt, sizeAnt));
                continue;
            } else if ((Math.sqrt(Math.pow(xAnt-xCenter,2) + Math.pow(yAnt-yCenter,2))) > radius) {
                ant.findNewWay(xCenter, yCenter);
            }

            g2d.fill(circle(xAnt, yAnt, sizeAnt));
            ant.calcWay();
        }
        ants.remove(awayAnt);
        awayAnt = null;
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

    public void addNewAnt(){
        ants.add(new AntP(getWidth()/2, getHeight()/2, 5));
    }

    public void needAway(int awayAnts){
        for(AntP ant : ants){
            if(awayAnts > 0){
                ant.setNeedAway(true);
                awayAnts--;
                continue;
            }
            break;
        }
    }
}