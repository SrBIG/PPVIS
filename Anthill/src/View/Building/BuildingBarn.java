package View.Building;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BuildingBarn extends JPanel {
    JButton actionZone = new JButton("Коровник");

    public BuildingBarn(){
        setLayout(new GridBagLayout());
        actionZone.setBackground(new Color(107, 80, 17));
        setSize(200, 200);
        actionZone.setPreferredSize(new Dimension(150, 150));
        actionZone.addActionListener(new ActionZoneListener());
        add(actionZone);
    }

    protected class ActionZoneListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            JDialog warningDialog = new JDialog();
            warningDialog.add(new JTextField("Sorry, this function is not yet implemented"));
            warningDialog.setVisible(true);
        }
    }
}
