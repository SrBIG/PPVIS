package View.Building;

import Controller.Controller;

import java.awt.*;

public class BuildingQueensRoom extends Building{
    private Controller controller;

    public BuildingQueensRoom(Controller controller){
        super(controller);
        this.controller = controller;
        rename("<html>Королева</html>");
        setColor(211, 239, 28);
    }

    @Override
    protected void run() {
        controller.addAnt();
    }
}
