package View.Building;

import Controller.Controller;
import View.BuildingInside.Church;

public class BuildingChurch extends Building{
    public BuildingChurch(Controller controller){
        super(controller);
        rename("Капище");
        setColor(102, 108, 232);
    }

    @Override
    protected void run() {
        new Church(controller);
    }
}
