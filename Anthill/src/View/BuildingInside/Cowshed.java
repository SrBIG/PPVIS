package View.BuildingInside;

import Controller.Controller;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Cowshed extends JDialog {
    private Controller controller;
    private JButton killAphid = new JButton("Убить одну");
    private JPanel info = new JPanel();
    private JLabel numAphids = new JLabel();
    private JLabel maxAphids = new JLabel();

    public Cowshed(Controller controller){
        this.controller = controller;
        update();
        info.add(numAphids);
        info.add(maxAphids);
        add(info, BorderLayout.CENTER);

        killAphid.addActionListener(new KillListener());
        add(killAphid, BorderLayout.SOUTH);

        setModal(true);
        setSize(300, 200);
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);
    }

    private void update(){
        numAphids.setText("Количесвтво тли: " + controller.getAphids());
        maxAphids.setText("Вместительность коровника: " + controller.getMaxAphids());
    }

    private class KillListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            if(controller.getAphids() < 1) return;
            controller.killAphid();
            update();
        }
    }
}
