package View.Building;

import java.awt.*;

public class BuildingQueensRoom extends Building{
    public BuildingQueensRoom(){
        super();
        rename("<html>Покои<br>Королевы</html>");
        actionZone.setBackground(new Color(211, 239, 28));
    }

    @Override
    protected void run() {
        super.run();
    }
}
