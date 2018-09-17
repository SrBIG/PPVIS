package Model;

public class Ant {
    private int maxHealth;
    private int health;
    private int atack;
    private int eat;

    public Ant(Characteristics characteristics){
        maxHealth = characteristics.getAntMaxHealth();
        atack = characteristics.getAntAtack();
        eat = characteristics.getAntEat();

        health = maxHealth;
    }

    public void healing(){
        health = maxHealth;
    }

    public int damage(int dmg){
        health -= dmg;
        if (health <= 0){
            return -1;
        } else return 1;
    }
}
