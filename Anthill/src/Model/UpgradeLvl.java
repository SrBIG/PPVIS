package Model;

public class UpgradeLvl {
    public static final int UP_ATACK = 1;
    public static final int UP_HEALTH = 2;
    public static final int UP_ANTHIL = 3;
    public static final int UP_CONSUMING = 4;
    public static final int UP_FOODSTORAGE = 5;
    public static final int UP_COWSHED = 6;

    private int atackLvl = 0;
    private int healthLvl = 0;
    private int anthilLvl = 0;
    private int consumingLvl = 0;
    private int foodStorageLvl = 0;
    private int cowshedLvl = 0;

    private int beginCostUpAtack = 2;
    private int beginCostUpHealth = 2;
    private int beginCostUpAnthil = 50;
    private int beginCostUpConsuming = 500;
    private int beginCostUpFoodStorage = 500;
    private int beginCostUpCowshed = 500;

    public int calcCost(int upgrade){
        int upgradeCost;
        int upgradeLvl;

        if(UP_ATACK == upgrade){
            upgradeCost = beginCostUpAtack;
            upgradeLvl = atackLvl;
        } else if(UP_HEALTH == upgrade){
            upgradeCost = beginCostUpHealth;
            upgradeLvl = healthLvl;
        } else if(UP_ANTHIL == upgrade){
            upgradeCost = beginCostUpAnthil;
            upgradeLvl = anthilLvl;
        } else if(UP_CONSUMING == upgrade){
            upgradeCost = beginCostUpConsuming;
            upgradeLvl = consumingLvl;
        } else if(UP_FOODSTORAGE == upgrade){
            upgradeCost = beginCostUpFoodStorage;
            upgradeLvl = foodStorageLvl;
        } else if(UP_COWSHED == upgrade){
            upgradeCost = beginCostUpCowshed;
            upgradeLvl = cowshedLvl;
        } else return 0;

        for(int lvl = 0; lvl <= upgradeLvl; lvl++){
            upgradeCost *= 2;
        }

        return upgradeCost;
    }

    public int getAtackLvl() {
        return atackLvl;
    }

    public int getHealthLvl() {
        return healthLvl;
    }

    public int getAnthilLvl() {
        return anthilLvl;
    }

    public int getConsumingLvl() {
        return consumingLvl;
    }

    public int getFoodStorageLvl() {
        return foodStorageLvl;
    }

    public int getCowshedLvl() {
        return cowshedLvl;
    }
}
