package View.BuildingInside;

import Controller.Controller;
import Model.Characteristics;
import Model.UpgradeLvl;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ScienceCenter extends JDialog {
    private JButton upAttack = new JButton("");
    private JButton upHealth = new JButton("");
    private JButton upConsuming = new JButton("");
    private JButton upAnthill = new JButton("");

    int upAttackCost;
    int upHealthCost;
    int upConsumingCost;
    int upAnthillCost;

    Controller controller;
    UpgradeLvl upgradeLvl;
    Characteristics characteristics;

    public ScienceCenter(Controller controller){
        this.controller = controller;
        this.upgradeLvl = controller.getUpgradeLvl();
        this.characteristics = controller.getCharacteristics();

        this.getContentPane().setLayout(new BoxLayout(this.getContentPane(), BoxLayout.Y_AXIS));

        upAttack.addActionListener(new UpAttackListener());
        upHealth.addActionListener(new UpHealthListener());
        upConsuming.addActionListener(new UpConsumingListener());
        upAnthill.addActionListener(new UpAnthillListener());

        paintUpFunctions();

        setModal(true);
        setSize(300, 200);
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);
    }

    void paintUpFunctions(){
        JPanel attack = new JPanel();
        JPanel health = new JPanel();
        JPanel consuming = new JPanel();
        JPanel anthill = new JPanel();

        upAttack.setPreferredSize(new Dimension(70, 25));
        upHealth.setPreferredSize(new Dimension(70, 25));
        upConsuming.setPreferredSize(new Dimension(70, 25));
        upAnthill.setPreferredSize(new Dimension(70, 25));

        calcCost();

        attack.add(new JLabel("Атака +1: "));
        attack.add(upAttack);

        health.add(new JLabel("Здоровье +1: "));
        health.add(upHealth);

        consuming.add(new JLabel("Потребление -1: "));
        consuming.add(upConsuming);

        anthill.add(new JLabel("Места +20: "));
        anthill.add(upAnthill);

        add(attack);
        add(health);
        add(consuming);
        add(anthill);
    }

    private void calcCost(){
        upAttackCost = upgradeLvl.calcCost(upgradeLvl.UP_ATTACK);
        upAttack.setText(String.valueOf(upAttackCost));

        upHealthCost = upgradeLvl.calcCost(upgradeLvl.UP_HEALTH);
        upHealth.setText(String.valueOf(upHealthCost));

        if(characteristics.getAntEat() > 1) {
            upConsumingCost = upgradeLvl.calcCost(upgradeLvl.UP_CONSUMING);
            upConsuming.setText(String.valueOf(upConsumingCost));
        } else upConsuming.setText("max lvl");

        upAnthillCost = upgradeLvl.calcCost(upgradeLvl.UP_ANTHILL);
        upAnthill.setText(String.valueOf(upAnthillCost));
    }

    private void updateData(){
        calcCost();
    }


    private class UpAttackListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            if(checkValid(upAttackCost)) {
                characteristics.upAntAtack(1);
                upgradeLvl.lvlUp(upgradeLvl.UP_ATTACK);
                updateData();
            }
        }
    }

    private class UpHealthListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            if(checkValid(upHealthCost)) {
                characteristics.upHealth(1);
                upgradeLvl.lvlUp(upgradeLvl.UP_HEALTH);
                updateData();
            }
        }
    }

    private class UpConsumingListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            if((characteristics.getAntEat() > 1) && checkValid(upConsumingCost)) {
                characteristics.upConsuming();
                upgradeLvl.lvlUp(upgradeLvl.UP_CONSUMING);
                updateData();
            }
        }
    }

    private class UpAnthillListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            if (checkValid(upAnthillCost)) {
                controller.addAntPlace(20);
                upgradeLvl.lvlUp(upgradeLvl.UP_ANTHILL);
                updateData();
            }
        }
    }

    private boolean checkValid(int costUpgrade){
        if(controller.getFoods() < costUpgrade){
            JOptionPane.showMessageDialog(null, "У вас недостаточно ресурсов!");
            return false;
        } else {
            controller.changeFood(-costUpgrade);
        }
        return true;

    }
}
