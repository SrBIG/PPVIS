package Controller;

import Model.Action.Raid;
import Model.Ant;
import Model.Characteristics;
import View.MainFrame;

import java.util.ArrayList;

public class Controller {
    private ArrayList<Ant> ants = new ArrayList<>();
    private int maxAnts = 100;
    private Characteristics characteristics;
    private MainFrame frame;
    private Raid raid;
    Thread threadRaid;

    private int foods = 0;
    private int aphids = 0;


    public Controller(MainFrame frame){
        this.frame = frame;
        characteristics = new Characteristics();
    }

    public Raid getRaid(){
        if(raid != null){
            return raid;
        } else return null;
    }

    public void beginRaid(ArrayList<Ant> antsInRaid) {
        for(Ant ant : antsInRaid){
            ants.remove(ant);
        }
        frame.update();
        raid = new Raid(antsInRaid);
        threadRaid = new Thread(new Runnable() {
            @Override
            public void run() {
                raid.beginRaid();
            }
        });
        threadRaid.start();
    }

    public void allDeadInRaid(){
        raid = null;
    }

    public void comebackRaid(){
        if(raid == null) return;
        Thread threadComeback = new Thread(new Runnable() {
            @Override
            public void run() {
                raid.comeback();
            }
        });
        threadComeback.start();
    }

    public void collectResurs(){
        for(Ant ant : raid.getAnts()){
            ants.add(ant);
        }
        foods = raid.getFoundFoods();
        aphids = raid.getFoundAphids();
        raid = null;
        frame.update();
    }

    public ArrayList<Ant> getAnts(){
        return ants;
    }

    public ArrayList<Ant> getSubAnts(int subNum){
        return new ArrayList<>(ants.subList((ants.size()-subNum), ants.size()));
    }

    public int getNumAnts(){
        return ants.size();
    }

    public void addAnt(){
        if(ants.size() < maxAnts) {
            ants.add(new Ant(characteristics));
        }
        frame.update();
    }

    public int getMaxAnts() {
        return maxAnts;
    }

    public void setMaxAnts(int maxAnts) {
        this.maxAnts = maxAnts;
        frame.update();
    }
}
