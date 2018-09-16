package View.Building;

import java.awt.*;

public class BuildingTownHall extends Building {

    public BuildingTownHall(){
        super();
        rename("Ратуша");
        actionZone.setBackground(new Color(244, 170, 66));
    }

    @Override
    protected void run() {
        super.run();
    }
}