package View.Building;

import Controller.Controller;
import sun.util.resources.cldr.ta.CurrencyNames_ta;

import java.awt.*;

public class BuildingChurch extends Building{
    public BuildingChurch(Controller controller){
        super(controller);
        rename("Капище");
        setColor(102, 108, 232);
    }

    @Override
    protected void run() {
        super.run();
    }
}
