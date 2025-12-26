/**
 * Clase Mage que extiende de Player.
 * 
 * @author Gaysper
 */
public class Mage extends Player {

    private int mana;
    private boolean isCastingFireball;
    private boolean isCastFailed;

    /**
     * Constructor de la clase Mage.
     * 
     * @param name
     * @param health
     * @param defense
     * @param attack
     * @param criticalChance
     * @param mana
     */
    public Mage(String name) {
        super(name, 80, 5, 30, 0.05f);
        this.mana = getHealth() * 2;
    }

    /**
     * Método para obtener el mana del mago.
     * 
     * @return int
     */
    public int getMana() {
        return this.mana;
    }

    /**
     * Método para establecer el mana del mago.
     * 
     * @param mana int
     */
    public void setMana(int mana) {
        this.mana = mana;
    }

    /**
     * Método para verificar si el mago está lanzando una bola de fuego.
     * 
     * @return boolean
     */
    public boolean isCastingFireball() {
        return isCastingFireball;
    }

    /**
     * Método para establecer si el mago está lanzando una bola de fuego.
     * 
     * @param isCastingFireball boolean
     */
    public void setCastingFireball(boolean isCastingFireball) {
        this.isCastingFireball = isCastingFireball;
    }

    /**
     * Método para verificar si el lanzamiento de hechizo falló.
     * 
     * @return boolean
     */
    public boolean isCastFailed() {
        return isCastFailed;
    }

    /**
     * Método para establecer si el lanzamiento de hechizo falló.
     * 
     * @param isCastFailed boolean
     */
    public void setCastFailed(boolean isCastFailed) {
        this.isCastFailed = isCastFailed;
    }

    /**
     * Método para conjurar un escudo mágico que aumenta la defensa del mago.
     * 
     * @return boolean
     */
    public boolean spellShield() {
        if (this.mana >= 30) {
            this.mana -= 30;
            setDefense(getDefense() + 15);
            System.out.println("¡" + getName() + "ha conjurado escudos a su alrededor, su defensa a aumentado a "
                    + getDefense() + "!");
            return true;
        }

        System.out.println("¡" + getName() + " no tiene suficiente mana para conjurar escudos, su mana actual es "
                + this.mana + "!");
        return false;
    }

    /**
     * Método para conjurar una curación que restaura la salud del mago.
     * 
     * @return boolean
     */
    public boolean spellHealing() {
        if (this.mana >= 40) {
            this.mana -= 40;
            setHealth(getHealth() + 40);
            System.out.println("¡" + getName() + " se ha curado 40 puntos de vida, su vida actual es "
                    + getHealth() + "!");
            return true;
        }

        System.out.println("¡" + getName() + " no tiene suficiente mana para curarse, su mana actual es "
                + this.mana + "!");
        return false;
    }

    /**
     * Método para lanzar una bola de fuego que inflige daño al enemigo.
     * 
     * @return boolean
     */
    public boolean spellFireball() {
        if (this.mana >= 50) {
            this.mana -= 50;
            System.out.println("¡" + getName() + " ha lanzado una bola de fuego!");
            return this.isCastingFireball = true;
        }
        System.out
                .println("¡" + getName() + " no tiene suficiente mana para lanzar una bola de fuego, su mana actual es "
                        + this.mana + "!");
        this.isCastFailed = true;
        return false;
    }
}
