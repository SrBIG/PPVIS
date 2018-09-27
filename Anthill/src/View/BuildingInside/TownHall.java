package View.BuildingInside;

import Controller.Controller;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TownHall extends JDialog {
    private Controller controller;
    private JLabel viewNumAnts = new JLabel();
    private JButton exit = new JButton("Выйти");
    private JPanel info = new JPanel();

    public TownHall(Controller controller) {
        this.controller = controller;
        setName("Ратуша");
        getContentPane().setLayout(new BoxLayout(this.getContentPane(), BoxLayout.Y_AXIS));
        update();

        info.add(viewNumAnts);
        add(info);
        info.setMaximumSize(new Dimension(300, 20));

        add(new ViewRaid());

        exit.addActionListener(new ExitListener());
        add(exit);

        setModal(true);
        setSize(300, 400);
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);
    }

    public void update(){
        viewNumAnts.setText("Муравьёв: " + controller.getNumAnts());
    }

    class ViewRaid extends JPanel{
        JTextField antsForRaid = new JTextField();
        JButton sendToRaid = new JButton("Отправить в рейд");

        public ViewRaid(){
            setPreferredSize(new Dimension(300, 100));
            if(controller.getRaid() != null){
                controller.getRaid().getStatus();
                add(new JLabel("Рэйд уже идет!"));
                add(new JLabel("Время рейда: " + controller.getRaid().getTime() + "c"));
            } else {
                add(new JLabel("Введите кол-во муравьёв для рейда:"));
                antsForRaid.setPreferredSize(new Dimension(300, 20));
                add(antsForRaid);
                sendToRaid.addActionListener(new RaidListener());
                add(sendToRaid);
            }
        }

        class RaidListener implements ActionListener{

            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                int numAntsForRaid = Integer.parseInt(antsForRaid.getText());

                if(controller.getNumAnts() < numAntsForRaid){
                    JOptionPane.showMessageDialog(null, "У вас недостаточно юнитов!");
                    return;
                }

                controller.beginRaid(controller.getSubAnts(numAntsForRaid));
                JOptionPane.showMessageDialog(null, "Рэйд начат! Количество юнитов в рейде: " + numAntsForRaid);
            }
        }
    }

    class ExitListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            setVisible(false);
        }
    }
}
