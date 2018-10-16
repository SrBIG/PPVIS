package Controller;

import Model.Action.Raid;
import Model.Ant;
import Model.Characteristics;
import Model.UpgradeLvl;
import View.MainFrame;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Controller {
    private ArrayList<Ant> ants = new ArrayList<>();
    private int maxAnts = 100;
    private Characteristics characteristics;
    private UpgradeLvl upgradeLvl;
    private MainFrame frame;
    private Raid raid;
    private Thread threadRaid;
    private int starvation = 0;

    private int consuming = 0;
    private int maxFoods = 1000;
    private int foods = 500;
    private int maxAphids = 50;
    private int aphids = 5;

    public Controller(MainFrame frame){
        this.frame = frame;
        characteristics = new Characteristics();
        upgradeLvl = new UpgradeLvl();
        Timer timer = new Timer(5000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                aphidFood();
                antEat();
            }
        });
        timer.start();
    }

    public Raid getRaid(){
        if(raid != null){
            return raid;
        } else return null;
    }

    public void beginRaid(ArrayList<Ant> antsInRaid) {
        frame.needAway(antsInRaid.size());
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

    public void raidEnd(){
        raid.end();
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

    public void collectResource(){
        for(Ant ant : raid.getAnts()){
            ants.add(ant);
            frame.addAnt();
        }
        foods += raid.getFoundFoods();
        aphids += raid.getFoundAphids();
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
        int costAnt = 5;
        if(ants.size() < maxAnts && costAnt < foods) {
            ants.add(new Ant(characteristics));
            frame.addAnt();
            changeFood(-costAnt);
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

    public void killAphid(){
        aphids--;
        foods += 10;
        if(foods>maxFoods) foods = maxFoods;
        frame.update();
    }

    public boolean changeFood(int godsFoods){
        foods += godsFoods;
        if(foods > maxFoods) foods = maxFoods;
        if (foods < 0) foods = 0;
        frame.update();
        return foods == 0 ? false : true;
    }

    public void godAphids(int godsAphids){
        aphids += godsAphids;
        if(aphids > maxAphids) aphids = maxAphids;
    }

    public void godAtackUP(){
        characteristics.upAntAtack(1);
    }

    public void godHealthUP(){
        characteristics.upHealth(1);
    }

    public int getFoods() {
        return foods;
    }

    public int getMaxFoods() {
        return maxFoods;
    }

    public int getAphids() {
        return aphids;
    }

    public int getMaxAphids() {
        return maxAphids;
    }

    public int getConsuming() {
        return consuming;
    }

    public UpgradeLvl getUpgradeLvl() {
        return upgradeLvl;
    }

    public void addAntPlace(int addPlace){
        maxAnts+=addPlace;
        frame.update();
    }

    public Characteristics getCharacteristics(){
        return characteristics;
    }

    private void aphidFood(){
        int oneAphid = 3;
        int aphidsGetFood = oneAphid * aphids;
        changeFood(aphidsGetFood);
    }

    private void antEat(){
        int consuming = 0;
        for(Ant ant : ants){
            consuming += ant.getEat();
        }
        if(!changeFood(-consuming)){
            starvation++;
            if(starvation == 6){
                frame.gameOver();
            }
            frame.warningStarvation(starvation);
        } else starvation = 0;
    }

    public void upMaxFoods(int upFoods){
        maxFoods+=upFoods;
    }
}
