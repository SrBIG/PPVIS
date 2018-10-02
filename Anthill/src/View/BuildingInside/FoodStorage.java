package View.BuildingInside;

import javax.swing.*;

public class FoodStorage extends JDialog {

    public FoodStorage(int foods, int maxFoods, int consuming){
        getContentPane().setLayout(new BoxLayout(this.getContentPane(), BoxLayout.Y_AXIS));

        add(new JLabel("Количество еды: " + foods + " ед"));
        add(new JLabel("Вместительность хранилища: " + maxFoods + " ед"));
        add(new JLabel("Потребление: " + consuming));
        setModal(true);
        setSize(300, 200);
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);
    }
}
