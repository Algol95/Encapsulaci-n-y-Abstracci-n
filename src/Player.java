/**
 * Representa un jugador en el juego Debugers & Dragons.
 * Contiene atributos y métodos relacionados con el jugador.
 * 
 * @author Gaysper
 */
public class Player extends Entity {

    private boolean isDefending;
    private float criticalChance;
    private float criticalBonus;

    /**
     * Constructor de la clase Player.
     * 
     * @param name
     * @param health
     * @param defense
     * @param attack
     * @param criticalChance
     */
    public Player(String name, int health, int defense, int attack, float criticalChance) {
        super(name, health, defense, attack);
        this.criticalChance = criticalChance;
    }

    // Getters y Setters

    public boolean isDefending() {
        return isDefending;
    }

    public void setDefending(boolean isDefending) {
        this.isDefending = isDefending;
    }

    public float getCriticalChance() {
        return criticalChance;
    }

    public void setCriticalChance(float criticalChance) {
        this.criticalChance = criticalChance;
    }

    public float getCriticalBonus() {
        return criticalBonus;
    }

    public void setCriticalBonus(float criticalBonus) {
        this.criticalBonus = criticalBonus;
    }

}
