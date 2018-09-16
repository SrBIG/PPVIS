package View.Building;

import java.awt.*;

public class BuildingScienceCenter extends Building{

    public BuildingScienceCenter(){
        super();
        rename("Научный центр");
        actionZone.setBackground(new Color(124, 12, 113));
    }

    @Override
    protected void run() {
        super.run();
    }
}
