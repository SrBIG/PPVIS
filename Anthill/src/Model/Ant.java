package Model;

public class Ant {
    private int maxHealth;
    private int health;
    private int Atack;

    public Ant(Characteristics characteristics){
        maxHealth = characteristics.getAntMaxHealth();
        Atack = characteristics.getAntAtack();
        health = maxHealth;
    }

    public void healing(){
        health = maxHealth;
    }
}
