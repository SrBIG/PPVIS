package View;

import View.Building.*;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JComponent{
    JFrame frame = new JFrame("Anthill");

    Anthill anthill = new Anthill();
    BuildingTownHall townHall = new BuildingTownHall();
    BuildingFoodStorage foodStorage = new BuildingFoodStorage();
    BuildingQueensRoom queensRoom = new BuildingQueensRoom();
    BuildingCowshed cowshed = new BuildingCowshed();
    BuildingChurch church = new BuildingChurch();
    BuildingScienceCenter scienceCenter = new BuildingScienceCenter();

    JPanel left = new JPanel();
    JPanel center = new JPanel();
    JPanel right = new JPanel();

    JLabel numberAnts = new JLabel("0/300");

    public MainFrame(){
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);
        frame.getContentPane().setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.X_AXIS));

        left.setLayout(new BoxLayout(left, BoxLayout.Y_AXIS));
        left.setPreferredSize(new Dimension(200, 600));
        left.add(townHall);
        left.add(foodStorage);
        left.add(queensRoom);

        right.setLayout(new BoxLayout(right, BoxLayout.Y_AXIS));
        right.setPreferredSize(new Dimension(200, 600));
        right.add(cowshed);
        right.add(church);
        right.add(scienceCenter);

        center.setLayout(new BorderLayout());
        center.setPreferredSize(new Dimension(400, 600));
        center.add(numberAnts, BorderLayout.NORTH);
        center.add(anthill);

        frame.add(left);
        frame.add(center);
        frame.add(right);
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