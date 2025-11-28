/**
 * Representa un jugador en el juego Debugers & Dragons.
 * Contiene atributos y métodos relacionados con el jugador.
 * 
 * @author Gaysper
 */
public class Player {

    private String name;
    private int health;
    private int defense;
    private int attack;
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
        this.name = name;
        this.health = health;
        this.defense = defense;
        this.attack = attack;
        this.criticalChance = criticalChance;
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

    /**
     * Método para determinar el daño causado por el ataque.
     * 
     * @param enemyDefense La defensa del enemigo.
     * @return El daño total causado después de considerar la defensa enemiga y
     *         posibles golpes críticos.
     */
    public int attacking(int enemyDefense) {

        int totalAttack = attack - enemyDefense;
        if (isCriticalHit()) {
            totalAttack *= 2;
            System.out.println("\n¡Golpe crítico!");
        }
        System.out.println("\n" + name + " ataca causando " + totalAttack + " puntos de daño.");
        return totalAttack;
    }

    /**
     * Método para determinar si el ataque es un golpe crítico.
     * 
     * @return true si el ataque es crítico, false en caso contrario.
     */
    private boolean isCriticalHit() {
        return Math.random() < (criticalChance + criticalBonus);
    }

    /**
     * Método para recibir daño.
     * 
     * @param damage El daño recibido.
     */
    public void receiveDamage(int damage) {
        int dmgTotal;
        if (isDefending) {
            criticalBonus += 0.15f;
            dmgTotal = (damage - defense) / 2;
            health -= dmgTotal;
        } else {
            dmgTotal = damage - defense;
            health -= dmgTotal;
        }
        if (health < 0)
            health = 0;

        System.out.println(name + " ha recibido " + dmgTotal + " puntos de daño. Salud restante: " + health);
    }

    /**
     * Método para verificar si el jugador está vivo.
     * 
     * @return true si la salud es mayor que 0, false en caso contrario.
     */
    public boolean isAlive() {
        return health > 0;
    }
}
