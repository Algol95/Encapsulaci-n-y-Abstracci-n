/**
 * Clase base para entidades del juego (jugadores y enemigos).
 * Contiene atributos comunes y comportamiento compartido.
 */
public abstract class Entity {

    private String name;
    private int health;
    private int defense;
    private int attack;

    protected Entity(String name, int health, int defense, int attack) {
        this.name = name;
        this.health = health;
        this.defense = defense;
        this.attack = attack;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getDefense() {
        return defense;
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }

    public int getAttack() {
        return attack;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public boolean isAlive() {
        return health > 0;
    }
}
