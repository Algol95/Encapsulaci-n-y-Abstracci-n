public class Enemy extends Entity {

    /**
     * Constructor de la clase Enemy.
     * 
     * @param name
     * @param health
     * @param defense
     * @param attack
     */
    public Enemy(String name, int health, int defense, int attack) {
        super(name, health, defense, attack);
    }

    // Getters/Setters e isAlive() heredados de Entity

    // Comportamiento específico de Enemy puede añadirse aquí
}
