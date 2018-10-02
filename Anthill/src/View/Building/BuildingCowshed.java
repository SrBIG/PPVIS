package View.Building;

import Controller.Controller;
import View.BuildingInside.Cowshed;

public class BuildingCowshed extends Building{

    public BuildingCowshed(Controller controller){
        super(controller);
        rename("Коровник");
        setColor(0, 206, 10);
    }

    @Override
    protected void run() {
        new Cowshed(controller);
    }
}
