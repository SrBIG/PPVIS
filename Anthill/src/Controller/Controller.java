package Controller;

import Model.Action.Raid;
import Model.Ant;
import Model.Characteristics;
import View.MainFrame;

import javax.swing.*;
import java.util.ArrayList;

public class Controller {
    private int numAnts = 0;
    private int maxAnts = 100;
    private Characteristics characteristics;
    MainFrame frame;
    Raid raid;


    public Controller(MainFrame frame){
        this.frame = frame;
        characteristics = new Characteristics();
    }

    public void beginRaid(ArrayList<Ant> antsInRaid) {
        raid = new Raid(antsInRaid);
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
