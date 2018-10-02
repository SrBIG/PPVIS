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

    private JPanel viewRaid = new JPanel();
    JTextField antsForRaid = new JTextField();
    JButton sendToRaid = new JButton("Отправить в рейд");
    JButton comeback = new JButton("Вернуть рейд");
    JButton endIfDead = new JButton("Завершить");
    JButton collectLoot = new JButton("Собрать добычу");

    public TownHall(Controller controller) {
        this.controller = controller;
        setName("Ратуша");
        getContentPane().setLayout(new BoxLayout(this.getContentPane(), BoxLayout.Y_AXIS));
        update();

        info.add(viewNumAnts);
        add(info);
        info.setMaximumSize(new Dimension(300, 20));

        viewRaidWithStatus();
        add(viewRaid);

        exit.addActionListener(new ExitListener());
        add(exit);

        setModal(true);
        setSize(300, 400);
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);
    }

    private void viewRaidWithStatus(){
        viewRaid.removeAll();
        viewRaid.setPreferredSize(new Dimension(300, 100));

        if(controller.getRaid() == null || controller.getRaid().getStatus() == 0){  // 0 - рейда не существует
            viewRaid.add(new JLabel("Введите кол-во муравьёв для рейда:"));
            antsForRaid.setPreferredSize(new Dimension(300, 20));
            viewRaid.add(antsForRaid);
            sendToRaid.addActionListener(new RaidListener());
            viewRaid.add(sendToRaid);
            return;
        } else if (controller.getRaid().getStatus() == 1){  // 1 - рейд идёт
            viewRaid.setLayout(new BoxLayout(viewRaid, BoxLayout.Y_AXIS));
            viewRaid.add(new JLabel("Рэйд уже идет!"));
            viewRaid.add(new JLabel("Время рейда: " + controller.getRaid().getTime() + "c"));
            viewRaid.add(new JLabel("Муравьёв в рейде: " + controller.getRaid().getAnts().size()));
            viewRaid.add(new JLabel("Еды найдено: " + controller.getRaid().getFoundFoods() + " ед"));
            viewRaid.add(new JLabel("Тли найдено: " + controller.getRaid().getFoundAphids()));
            comeback.addActionListener(new ComebackListener());
            viewRaid.add(comeback);
            return;
        } else if (controller.getRaid().getStatus() == 2){  // 2 - все мертвы
            viewRaid.add(new JLabel("Все мертвы...!"));
            viewRaid.add(new JLabel("Время рейда: " + controller.getRaid().getTime() + "c"));
            endIfDead.addActionListener(new AllDeadListener());
            viewRaid.add(endIfDead);
            return;
        } else if (controller.getRaid().getStatus() == 3){  // 3 - рейд возвращается
            viewRaid.add(new JLabel("Рэйд возвращается!"));
            viewRaid.add(new JLabel("Время до возвращения: " + controller.getRaid().getTime() + "c"));
            return;
        } else if (controller.getRaid().getStatus() == 4){  // 4 - рейд вернулся
            viewRaid.add(new JLabel("Рейд вернулся"));
            collectLoot.addActionListener(new CollectListener());
            viewRaid.add(collectLoot);
            return;
        }
    }

    private void update(){
        viewNumAnts.setText("Муравьёв: " + controller.getNumAnts());
    }

    class RaidListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            int numAntsForRaid = Integer.parseInt(antsForRaid.getText());

            if(numAntsForRaid < 1) return;

            if (controller.getNumAnts() < numAntsForRaid) {
                JOptionPane.showMessageDialog(null, "У вас недостаточно юнитов!");
                return;
            }

            controller.beginRaid(controller.getSubAnts(numAntsForRaid));
            viewRaidWithStatus();
            update();
            JOptionPane.showMessageDialog(null, "Рэйд начат! Количество юнитов в рейде: " + numAntsForRaid);
        }
    }

    class ComebackListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            if(controller.getRaid().getStatus() == 2) {
                JOptionPane.showMessageDialog(null, "Рэйд мёртв...");
                setVisible(false);
            }
            controller.getRaid().end();
            controller.comebackRaid();
            viewRaidWithStatus();
            update();
        }
    }

    class AllDeadListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            controller.allDeadInRaid();
            viewRaidWithStatus();
        }
    }

    class CollectListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            controller.collectResurs();
            viewRaidWithStatus();
            update();
        }
    }

    class ExitListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            setVisible(false);
        }
    }
}
