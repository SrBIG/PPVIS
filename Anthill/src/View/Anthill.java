package View;

import javax.swing.*;
import java.util.ArrayList;

public class Anthill extends JComponent{
    private int numOfAnts;
    private int maxAnts;
    ArrayList<AnthillLvl> anthillLvls = new ArrayList();
    AnthillLvl anthillLvl = new AnthillLvl();

    public Anthill() {
        setSize(400, 600);
        //setSize(getWidth(),getHeight());
        add(anthillLvl);
    }
}

        /*
        this.radius = radius;
        this.maxAnts = maxAnts;
        createAngles();
        angle = 0;
        Timer timer = new Timer(1, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                angle += 0.001;
                if (angle > 6.28) angle = 0;
                repaint();
            }
        });
        timer.start();
    }

    protected void paintComponent(Graphics g) {
        int width = getWidth();
        int height = getHeight();
        g.setColor(Color.white);
        g.fillRect(0, 0, width, height);
        g.setColor(Color.black);
        Graphics2D g2d = (Graphics2D) g;
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

        g2d.draw(circle(width/2, height/2, 100));
        double x1 = width / 2;
        double y1= height / 2;
        double r1 = 5;
        double an1 = angle + 0.5;
        x1 += 100 * Math.cos(an1);
        y1 += 100 * Math.sin(an1);
        g2d.fill(circle(x1, y1, r1));
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
*/