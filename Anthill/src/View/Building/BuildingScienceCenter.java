package View.Building;

import Controller.Controller;

import java.awt.*;

public class BuildingScienceCenter extends Building{

    public BuildingScienceCenter(Controller controller){
        super(controller);
        rename("Научный центр");
        setColor(124, 12, 113);
    }

    @Override
    protected void run() {
        super.run();
    }
}
