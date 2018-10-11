package Model;

public class UpgradeLvl {
    public static final int UP_ATTACK = 1;
    public static final int UP_HEALTH = 2;
    public static final int UP_ANTHILL = 3;
    public static final int UP_CONSUMING = 4;
    public static final int UP_FOODSTORAGE = 5;
    public static final int UP_COWSHED = 6;

    private int attackLvl = 0;
    private int healthLvl = 0;
    private int anthillLvl = 0;
    private int consumingLvl = 0;
    private int foodStorageLvl = 0;
    private int cowshedLvl = 0;

    private int beginCostUpAttack = 2;
    private int beginCostUpHealth = 2;
    private int beginCostUpAnthill = 50;
    private int beginCostUpConsuming = 500;
    private int beginCostUpFoodStorage = 500;
    private int beginCostUpCowshed = 500;

    public int calcCost(int upgrade){
        int upgradeCost;
        int upgradeLvl;

        if(UP_ATTACK == upgrade){
            upgradeCost = beginCostUpAttack;
            upgradeLvl = attackLvl;
        } else if(UP_HEALTH == upgrade){
            upgradeCost = beginCostUpHealth;
            upgradeLvl = healthLvl;
        } else if(UP_ANTHILL == upgrade){
            upgradeCost = beginCostUpAnthill;
            upgradeLvl = anthillLvl;
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

    public void lvlUp(int upgrade){
        if(UP_ATTACK == upgrade){
            attackLvl++;
        } else if(UP_HEALTH == upgrade){
            healthLvl++;
        } else if(UP_ANTHILL == upgrade){
            anthillLvl++;
        } else if(UP_CONSUMING == upgrade){
            consumingLvl++;
        } else if(UP_FOODSTORAGE == upgrade){
            foodStorageLvl++;
        } else if(UP_COWSHED == upgrade){
            cowshedLvl++;
        } else return;
    }

    public int getAttackLvl() {
        return attackLvl;
    }

    public int getHealthLvl() {
        return healthLvl;
    }

    public int getAnthillLvl() {
        return anthillLvl;
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
