package View.Building;

import java.awt.*;

public class BuildingFoodStorage extends Building{

    public BuildingFoodStorage(){
        super();
        rename("Хранилище еды");
        actionZone.setBackground(new Color(173, 13, 45));
    }

    @Override
    protected void run() {
        super.run();
    }
}
