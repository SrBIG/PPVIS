package View;

import View.Building.BuildingBarn;
import View.Building.BuildingTownHall;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JComponent{
    JFrame frame = new JFrame("Anthill");
    Anthill anthill = new Anthill();
    BuildingBarn buildingBarn = new BuildingBarn();
    BuildingTownHall buildingTownHall = new BuildingTownHall();

    JPanel left = new JPanel();
    JPanel center = new JPanel();
    JPanel right = new JPanel();

    BuildingBarn buildingBarn2 = new BuildingBarn();
    BuildingTownHall buildingTownHall2 = new BuildingTownHall();
    BuildingTownHall buildingTownHall3 = new BuildingTownHall();



    public MainFrame(){
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);
        //frame.setLayout(new GridBagLayout());
        frame.getContentPane().setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.X_AXIS));

        left.setLayout(new BoxLayout(left, BoxLayout.Y_AXIS));
        left.setSize(200, 600);
        left.add(buildingTownHall);
        left.add(buildingBarn);

        center.setLayout(new BoxLayout(center, BoxLayout.Y_AXIS));
        center.setPreferredSize(new Dimension(400, 600));
        int i = anthill.getWidth();
        //center.add(new TextField("Status"));
        center.add(anthill);
        //center.add(buildingTownHall3);

        right.setLayout(new BoxLayout(right, BoxLayout.Y_AXIS));
        right.setSize(200, 600);
        right.add(buildingTownHall2);
        right.add(buildingBarn2);

        //anthill.setSize(400, 400);

        frame.add(left);
        //frame.add(buildingTownHall);
        //frame.add(anthill);
        frame.add(center);
        frame.add(right);
        //frame.add(buildingBarn);
        frame.setVisible(true);
        frame.setResizable(false);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new MainFrame();
            }
        });
    }
}