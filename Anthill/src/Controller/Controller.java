package Controller;

import Model.Characteristics;
import View.MainFrame;

import javax.swing.*;

public class Controller {
    private int numAnts = 0;
    private int maxAnts = 100;
    private Characteristics characteristics;
    MainFrame frame;

    public Controller(MainFrame frame){
        this.frame = frame;
        characteristics = new Characteristics();
    }

    public int getNumAnts(){
        return numAnts;
    }

    public void addAnt(){
        if(numAnts < maxAnts) {
            numAnts++;
        }
        frame.update();
    }

    public int getMaxAnts() {
        return maxAnts;
    }

    public void setMaxAnts(int maxAnts) {
        this.maxAnts = maxAnts;
    }
}
