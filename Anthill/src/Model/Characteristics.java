package Model;

public class Characteristics {
    private int antMaxHealth;
    private int antAtack;

    public Characteristics(){
        antAtack = 1;
        antMaxHealth = 3;
    }

    public int getAntAtack() {
        return antAtack;
    }

    public void setAntAtack(int antAtack) {
        this.antAtack = antAtack;
    }

    public int getAntMaxHealth() {
        return antMaxHealth;
    }

    public void setAntMaxHealth(int antMaxHealth) {
        this.antMaxHealth = antMaxHealth;
    }
}
