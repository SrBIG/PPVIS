package View.BuildingInside;

import Controller.Controller;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Church extends JDialog {

    Controller controller;
    JTextField sacrifice = new JTextField();
    JButton immolation = new JButton("Принести жертву");

    public Church(Controller controller){
        this.controller = controller;

        add(new JLabel("Введите количество еды, которое желаете принести в жертву богам"), BorderLayout.NORTH);
        add(sacrifice, BorderLayout.CENTER);

        immolation.addActionListener(new ImmolationListener());
        add(immolation, BorderLayout.SOUTH);

        setModal(true);
        setSize(400, 200);
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);
    }

    private class ImmolationListener implements ActionListener{
        int foodsSacrifice;

        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            if(sacrifice.getText().trim().isEmpty()) return;
            foodsSacrifice = Integer.parseInt(sacrifice.getText());

            if (foodsSacrifice > controller.getFoods()) {
                JOptionPane.showMessageDialog(null, "У вас недостаточно ресурсов!");
                return;
            }
            controller.addFoods(-foodsSacrifice);

            godsAnswer();
        }

        private void godsAnswer(){
            int answer = 0;
            int godsGift = 0;
            if(foodsSacrifice < 20){
                answer = (int)(Math.random() * 5);
                switch (answer){
                    case 1:
                        JOptionPane.showMessageDialog(null, "Ты разгневил богов! Боги сожгли твои поля. Потеряно 20 единиц пищи.");
                        controller.addFoods(-20);
                        break;
                    case 2:
                        godsGift = (int)(Math.random()*40 + 1);
                        JOptionPane.showMessageDialog(null, "Боги ниспослали тебе пищу! "+godsGift+" ед.");
                        controller.addFoods(godsGift);
                        break;
                    default:
                        JOptionPane.showMessageDialog(null, "Боги тебя не услышали...");
                }
                return;
            } else if (foodsSacrifice < 100){
                answer = (int)(Math.random()*5);
                switch (answer){
                    case 1:
                        JOptionPane.showMessageDialog(null, "Ты порадовал богов! Погода будет хорошая.");
                        break;
                    case 2:
                        godsGift = (int)(Math.random()*200 + 1);
                        JOptionPane.showMessageDialog(null, "Боги ниспослали тебе пищу! "+godsGift+" ед.");
                        controller.addFoods(godsGift);
                        break;
                    case 3:
                        godsGift = (int)(Math.random()*20 + 1);
                        JOptionPane.showMessageDialog(null, "Боги послали тебе стада! "+godsGift+" голов.");
                        controller.godAphids(godsGift);
                        break;
                    default:
                        JOptionPane.showMessageDialog(null, "Боги тебя не услышали...");
                }
            } else {
                answer = (int)(Math.random()*3);
                switch (answer){
                    case 1:
                        JOptionPane.showMessageDialog(null, "Боги улучшили геном муравьёв. Атака +1.");
                        controller.godAtackUP();
                        break;
                    case 2:
                        JOptionPane.showMessageDialog(null, "Боги улучшили геном муравьёв. Здоровье +1.");
                        controller.godHealthUP();
                        break;
                    default:
                        JOptionPane.showMessageDialog(null, "Боги тебя не услышали...");
                }
            }
        }
    }
}
