package View;

import javax.swing.*;

public class MainFrame extends JComponent{
    JFrame frame = new JFrame("Anthill");
    Anthill anthill = new Anthill();


    public MainFrame(){
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);
        frame.add(anthill);
        frame.setVisible(true);
        frame.setResizable(false);
    }
    /*private double angle;
    private double angle2;

    public MainFrame() {
        angle = 0;
        angle2 = 0.15;
        Timer timer = new Timer(10, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                angle += 0.01;
                angle2 += 0.01;
                if (angle > 6.28) angle = 0;
                if (angle2 > 6.28) angle2 = 0;
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

        //g2d.draw(circle(width/2, height/2, height/2));
        //for(int i = 0; i < 3; i++) {
            double x = width / 2;
            double y = height / 2;
            double r = 5;
            double an = angle;
            x += height / 2 * Math.cos(an);
            y += height / 2 * Math.sin(an);
            g2d.fill(circle(x, y, r));

        double x1 = width / 2;
        double y1 = height / 2;
        double r1 = 5;
        double an1 = angle2;
        x1 += height / 2 * Math.cos(an1);
        y1 += height / 2 * Math.sin(an1);
        g2d.fill(circle(x1, y1, r1));




        //}

        for (int i = 0; i <= width; i += 25) {
            for (int j = 0; j <= height; j += 25) {
                double x = width - i;
                double y = height - j;
                double r = 20;
                g2d.draw(circle(x, y, r));
                g2d.setColor(Color.black);
                x += r * Math.cos(angle);
                y += r * Math.sin(angle);
                r = 5;
                g2d.fill(circle(x, y, r));
            }
        }
    }

    private Shape circle(double x, double y, double r) {
        return new Ellipse2D.Double(x - r, y - r, 2 * r, 2 * r);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                JFrame frame = new JFrame("Points on circles");
                frame.add(new MainFrame());
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setSize(800, 600);
                frame.setVisible(true);
            }
        });
    }
*/
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new MainFrame();
            }
        });
    }
}