package View.BuildingInside;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ScienceCenter extends JDialog {
    private JButton upAtack = new JButton("");
    private JButton upHealth = new JButton("");
    private JButton upConsuming = new JButton("");
    private JButton upAnthil = new JButton("");

    public ScienceCenter(){

        this.getContentPane().setLayout(new BoxLayout(this.getContentPane(), BoxLayout.Y_AXIS));

        upAtack.addActionListener(new UpAtackListener());
        upHealth.addActionListener(new UpHealthListener());
        upConsuming.addActionListener(new UpConsumingListener());
        upAnthil.addActionListener(new UpAnthilListener());

        paintUpFunctions();

        setModal(true);
        setSize(300, 200);
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);
    }

    void paintUpFunctions(){
        JPanel atack = new JPanel();
        JPanel health = new JPanel();
        JPanel consuming = new JPanel();
        JPanel anthil = new JPanel();

        upAtack.setPreferredSize(new Dimension(70, 25));
        upHealth.setPreferredSize(new Dimension(70, 25));
        upConsuming.setPreferredSize(new Dimension(70, 25));
        upAnthil.setPreferredSize(new Dimension(70, 25));

        atack.add(new JLabel("Атака +1: "));
        atack.add(upAtack);

        health.add(new JLabel("Здоровье +1: "));
        health.add(upHealth);

        consuming.add(new JLabel("Потребление -1: "));
        consuming.add(upConsuming);

        anthil.add(new JLabel("Места +20: "));
        anthil.add(upAnthil);

        add(atack);
        add(health);
        add(consuming);
        add(anthil);
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
