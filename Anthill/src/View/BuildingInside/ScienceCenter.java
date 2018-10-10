package View.BuildingInside;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ScienceCenter extends JDialog {
    private JButton upAtack = new JButton("Атака +1");
    private JButton upHealth = new JButton("Здоровье +1");
    private JButton upConsuming = new JButton("Потребление -1");
    private JButton upAnthil = new JButton("Места +20");

    private int lvlAtack = 0;
    private int maxLvlAtack = 5;
    //private int

    public ScienceCenter(){

        this.getContentPane().setLayout(new BoxLayout(this.getContentPane(), BoxLayout.Y_AXIS));

        upAtack.addActionListener(new UpAtackListener());
        upHealth.addActionListener(new UpHealthListener());
        upConsuming.addActionListener(new UpConsumingListener());
        upAnthil.addActionListener(new UpAnthilListener());

        paintUpFunctions();

        setModal(true);
        setSize(500, 200);
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);
    }

    void paintUpFunctions(){
        JPanel atack = new JPanel();
        JPanel health = new JPanel();
        JPanel consuming = new JPanel();
        JPanel anthil = new JPanel();

        atack.add(new JLabel("Увеличение атаки: "));
        atack.add(upAtack);

        health.add(new JLabel("Увеличение здоровья: "));
        health.add(upHealth);

        consuming.add(new JLabel("Уменьшения потребления пищи: "));
        consuming.add(upConsuming);

        anthil.add(new JLabel("Увеличение кол-ва мест в муравейнике: "));
        anthil.add(upAnthil);

        add(atack);
        add(health);
        add(consuming);
        add(anthil);

//        JPanel left = new JPanel();
//        JPanel right = new JPanel();
//        left.setLayout(new BoxLayout(left, BoxLayout.Y_AXIS));
//        right.setLayout(new BoxLayout(right, BoxLayout.Y_AXIS));
//
//        left.add(new JLabel("Увеличение атаки: "));
//        left.add(new JLabel("Увеличение здоровья: "));
//        left.add(new JLabel("Уменьшения потребления пищи: "));
//        left.add(new JLabel("Увеличение кол-ва мест в муравейнике: "));
//
//        right.add(upAtack);
//        right.add(upHealth);
//        right.add(upConsuming);
//        right.add(upAnthil);
//
//        add(left);
//        add(right);
    }

    private class UpAtackListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent actionEvent) {

        }
    }

    private class UpHealthListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent actionEvent) {

        }
    }

    private class UpConsumingListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent actionEvent) {

        }
    }

    private class UpAnthilListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent actionEvent) {

        }
    }
}
