package View.Building;

import java.awt.*;

public class BuildingChurch extends Building{
    public BuildingChurch(){
        super();
        rename("Капище");
        actionZone.setBackground(new Color(102, 108, 232));
    }

    @Override
    protected void run() {
        super.run();
    }
}
