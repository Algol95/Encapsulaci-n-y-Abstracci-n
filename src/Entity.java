/**
 * Clase abstracta que representa una entidad en el juego.
 * 
 * @author Gaysper
 */
public abstract class Entity {

    private String name = "Paco";
    private int health;
    private int defense;
    private int attack;

    /**
     * Constructor de la clase Entity.
     * 
     * @param name
     * @param health
     * @param defense
     * @param attack
     */
    protected Entity(String name, int health, int defense, int attack) {
        this.name = name;
        this.health = health;
        this.defense = defense;
        this.attack = attack;
    }

    /**
     * Método para obtener el nombre de la entidad.
     * 
     * @return String
     */
    public String getName() {
        return this.name;
    }

    /**
     * Método para establecer el nombre de la entidad.
     * 
     * @param name String
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Método para obtener la salud de la entidad.
     * 
     * @return int
     */
    public int getHealth() {
        return this.health;
    }

    /**
     * Método para establecer la salud de la entidad.
     * 
     * @param health int
     */
    public void setHealth(int health) {
        this.health = health;
    }

    /**
     * Método para obtener la defensa de la entidad.
     * 
     * @return int
     */
    public int getDefense() {
        return this.defense;
    }

    /**
     * Método para establecer la defensa de la entidad.
     * 
     * @param defense int
     */
    public void setDefense(int defense) {
        this.defense = defense;
    }

    /**
     * Método para obtener el ataque de la entidad.
     * 
     * @return int
     */
    public int getAttack() {
        return this.attack;
    }

    /**
     * Método para establecer el ataque de la entidad.
     * 
     * @param attack int
     */
    public void setAttack(int attack) {
        this.attack = attack;
    }

    /**
     * Método para verificar si la entidad está viva.
     * 
     * @return boolean
     */
    public boolean isAlive() {
        return this.health > 0;
    }
}
