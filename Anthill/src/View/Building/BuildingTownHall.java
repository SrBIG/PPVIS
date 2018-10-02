package View.Building;

import Controller.Controller;
import View.BuildingInside.TownHall;

public class BuildingTownHall extends Building {

    public BuildingTownHall(Controller controller){
        super(controller);
        rename("Ратуша");
        setColor(244, 170, 66);
    }

    @Override
    protected void run() {
        new TownHall(controller);
    }
}