package View;

import Controller.Controller;
import View.Building.*;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JComponent{
    JFrame frame = new JFrame("Anthill");
    Controller controller;

    Anthill anthill;
    BuildingTownHall townHall;
    BuildingFoodStorage foodStorage;
    BuildingQueensRoom queensRoom;
    BuildingCowshed cowshed;
    BuildingChurch church;
    BuildingScienceCenter scienceCenter;

    JPanel left = new JPanel();
    JPanel center = new JPanel();
    JPanel right = new JPanel();

    JLabel numberAnts = new JLabel("0/300");

    public MainFrame(){
        controller = new Controller();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);
        frame.setLocationRelativeTo(null);
        frame.getContentPane().setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.X_AXIS));
        createStructure();
        frame.setVisible(true);
        frame.setResizable(false);
    }

    private void createStructure(){
        anthill = new Anthill();
        townHall = new BuildingTownHall(controller);
        foodStorage = new BuildingFoodStorage();
        queensRoom = new BuildingQueensRoom();
        cowshed = new BuildingCowshed();
        church = new BuildingChurch();
        scienceCenter = new BuildingScienceCenter();

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