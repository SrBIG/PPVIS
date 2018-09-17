package View.Building;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Building extends JPanel{
    private JButton actionZone = new JButton("Default");

    public Building(){
        setLayout(new GridBagLayout());
        actionZone.setBackground(new Color(40,2,2));
        setSize(200, 200);
        actionZone.setPreferredSize(new Dimension(150, 150));
        actionZone.addActionListener(new ActionZoneListener());
        add(actionZone);
    }

    private class ActionZoneListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            run();
        }
    }

    protected void run(){
        JDialog warningDialog = new JDialog();
        warningDialog.setSize(250,100);
        warningDialog.setLocationRelativeTo(null);
        warningDialog.add(new JTextField("Sorry, this function is not yet implemented"));
        warningDialog.setVisible(true);
    }

    protected void rename(String newName){
        actionZone.setText(newName);
    }

    protected void setColor(int r, int g, int b){
        actionZone.setBackground(new Color(r,g,b));
    }
}
