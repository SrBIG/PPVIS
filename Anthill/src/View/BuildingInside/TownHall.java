package View.BuildingInside;

import Controller.Controller;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TownHall extends JDialog {
    Controller controller;
    JPanel info = new JPanel();

    public TownHall(Controller controller) {
        this.controller = controller;
        setName("Ратуша");

        info.add(new JLabel("Муравьёв-"+controller.getNumAnts()));
        add(info);

        add(new Raid());

        setModal(true);
        setSize(300, 400);
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);
    }


    class Raid extends JPanel{
        JTextField antsForRaid = new JTextField();
        JButton sendToRaid = new JButton("Отправить в рейд");

        public Raid(){
            setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
            setPreferredSize(new Dimension(300, 100));
            //setMaximumSize(new Dimension(300, 100));
            add(new JLabel("Введите кол-во муравьёв для рейда:"));
            add(antsForRaid);

            sendToRaid.addActionListener(new RaidListener());
            add(sendToRaid);
        }

        class RaidListener implements ActionListener{

            @Override
            public void actionPerformed(ActionEvent actionEvent) {

            }
        }
    }
}
