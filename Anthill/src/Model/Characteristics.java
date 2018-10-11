package Model;

public class Characteristics {
    private int antMaxHealth;
    private int antAtack;
    private int antEat;

    public Characteristics(){
        antAtack = 1;
        antMaxHealth = 3;
        antEat = 4;
    }

    public int getAntAtack() {
        return antAtack;
    }

    public void setAntAtack(int antAtack) {
        this.antAtack = antAtack;
    }

    public void upAntAtack(int upAtack){
        antAtack+=upAtack;
    }

    public int getAntMaxHealth() {
        return antMaxHealth;
    }

    public void setAntMaxHealth(int antMaxHealth) {
        this.antMaxHealth = antMaxHealth;
    }

    public void upHealth(int upHealth){
        antMaxHealth+=upHealth;
    }

    public int getAntEat() {
        return antEat;
    }

    public void setAntEat(int antEat) {
        this.antEat = antEat;
    }

    public void upConsuming(){
        antEat--;
    }
}
