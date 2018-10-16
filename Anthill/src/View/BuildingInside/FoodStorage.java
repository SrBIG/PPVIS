package View.BuildingInside;

import Controller.Controller;
import Model.UpgradeLvl;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Comparator;

public class FoodStorage extends JDialog {
    Controller controller;

    UpgradeLvl upgradeLvl;
    int upCost;

    int foods;
    int maxFoods;

    JPanel info = new JPanel();

    JLabel numFoodsL = new JLabel();
    JLabel maxFoodsL = new JLabel();

    JButton upgrade = new JButton("Улучшить");

    public FoodStorage(Controller controller){
        this.controller = controller;

        this.foods = controller.getFoods();
        this.maxFoods = controller.getMaxFoods();
        this.upgradeLvl = controller.getUpgradeLvl();

        getContentPane().setLayout(new BorderLayout());
        update();

        info.add(numFoodsL);
        info.add(maxFoodsL);

        add(info, BorderLayout.CENTER);

        upgrade.addActionListener(new UpgradeListener());
        add(upgrade, BorderLayout.SOUTH);

        setModal(true);
        setSize(300, 200);
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);
    }

    private void update(){
        upCost = upgradeLvl.calcCost(upgradeLvl.UP_FOODSTORAGE);
        upgrade.setText("Улучшить("+upCost+")");
        numFoodsL.setText("Количество еды: " + controller.getFoods() + " ед");
        maxFoodsL.setText("Вместительность хранилища: " + controller.getMaxFoods() + " ед");
    }

    class UpgradeListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            if(checkValid()) {
                controller.upMaxFoods(500);
                upgradeLvl.lvlUp(upgradeLvl.UP_FOODSTORAGE);
                update();
            }
        }
    }

    private boolean checkValid(){
        if(foods < upCost){
            JOptionPane.showMessageDialog(null, "У вас недостаточно ресурсов!");
            return false;
        } else {
            controller.changeFood(-upCost);
        }
        return true;

    }
}
