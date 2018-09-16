package View.Building;

import java.awt.*;

public class BuildingCowshed extends Building{

    public BuildingCowshed(){
        super();
        rename("Коровник");
        actionZone.setBackground(new Color(0, 206, 10));
    }

    @Override
    protected void run() {
        super.run();
    }
}
