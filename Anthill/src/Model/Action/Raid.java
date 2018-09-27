package Model.Action;


import Model.Ant;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Raid {
    private ArrayList<Ant> antsInRaid;
    private int foundAphids = 0;
    private int foundFoods = 0;

    private int status = 0;
    // 0 - рейда не существует
    // 1 - рейд запущен
    // 2 - все мертвы
    // 3 - рейд возвращается

    private int time = 0;
    private int oneTick = 5;
    private Timer timer;

    public Raid(ArrayList<Ant> ants){
        this.antsInRaid = ants;
    }

    public void beginRaid(){
        status = 1;
        timer = new Timer(oneTick*1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                time += oneTick;
                if(antsInRaid.isEmpty()){
                    end();
                }
                event();
            }
        });
        timer.start();
    }

    public void event(){
        int numberEvents = 5;
        int numEvent = (int)(Math.random()*(numberEvents*2));

        switch (numEvent){
            case 1:
                findAphids();
                break;
            case 2:
                takingDamage();
                break;
            case 3:
                findFoods();
                break;
            case 4:
                foundAnts();
                break;
            case 5:
                deathAphid();
                break;
            default:
                return;
        }
    }

    private void findAphids(){
        int possibleAphids = 5;
        possibleAphids++;
        int numAphids = (int)(Math.random()*possibleAphids);
        foundAphids += numAphids;
    }

    private void deathAphid(){
        if(foundAphids > 0){
            foundAphids--;
        }
    }

    private void findFoods(){
        int possibleAphids = 5;
        possibleAphids++;
        int numFoods = (int)(Math.random()*possibleAphids);
        foundFoods += numFoods;
    }

    private void foundAnts(){
        int chance = 10;
        if((Math.random()*100) < chance){
            antsInRaid.add(new Ant());
        }
    }

    private void takingDamage(){
        int damage = (int)(Math.random()*5);
        Ant ant = antsInRaid.get(antsInRaid.size()-1);
        if(ant.damage(damage) == -1){
            antsInRaid.remove(ant);
        }
    }

    public int getTime(){
        return time;
    }

    public int getStatus(){
        return status;
    }

    public void comeBack(){

    }

    public void end(){
        if(antsInRaid.isEmpty()){
            status = 2;
        } else{
            status = 3;
        }
        timer.stop();
    }

}
