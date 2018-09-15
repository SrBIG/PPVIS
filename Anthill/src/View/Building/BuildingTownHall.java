package View.Building;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BuildingTownHall extends JPanel {
    protected JButton actionZone = new JButton("Ратуша");

    public BuildingTownHall(){
        setLayout(new GridBagLayout());
        actionZone.setBackground(new Color(244, 170, 66));
        setSize(200, 200);
        actionZone.setPreferredSize(new Dimension(150, 150));
        actionZone.addActionListener(new ActionZoneListener());
        add(actionZone);
    }

    protected class ActionZoneListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            JDialog warningDialog = new JDialog();
            warningDialog.add(new JTextField("Sorry, this function is not yet implemented"));
            warningDialog.setVisible(true);
        }
    }
}