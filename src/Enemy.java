public class Enemy {
    private String name;
    private int health;
    private int defense;
    private int attack;

    /**
     * Constructor de la clase Enemy.
     * 
     * @param name
     * @param health
     * @param defense
     * @param attack
     */
    public Enemy(String name, int health, int defense, int attack) {
        this.name = name;
        this.health = health;
        this.defense = defense;
        this.attack = attack;
    }

    // Getters y Setters
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

    /**
     * Método para verificar si el enemigo está vivo.
     * 
     * @return true si la salud es mayor que 0, false en caso contrario.
     */
    public boolean isAlive() {
        return health > 0;
    }
}
