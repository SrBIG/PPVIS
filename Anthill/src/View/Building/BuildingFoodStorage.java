package View.Building;

import Controller.Controller;
import View.BuildingInside.FoodStorage;


public class BuildingFoodStorage extends Building{

    public BuildingFoodStorage(Controller controller){
        super(controller);
        rename("Хранилище еды");
        setColor(173, 13, 45);
    }

    @Override
    protected void run() {
        new FoodStorage(controller.getFoods(), controller.getMaxFoods(), controller.getConsuming());
    }
}
