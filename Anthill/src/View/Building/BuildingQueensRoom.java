package View.Building;

import java.awt.*;

public class BuildingQueensRoom extends Building{
    public BuildingQueensRoom(){
        super();
        rename("Покои Королевы");
        actionZone.setBackground(new Color(211, 239, 28));
    }

    @Override
    protected void run() {
        super.run();
    }
}
