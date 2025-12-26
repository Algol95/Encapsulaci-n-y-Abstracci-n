/**
 * Clase Player especializada: Mago
 * Ataque alto, defensa baja, crítico moderado.
 * Además: tiene maná y puede curarse.
 */
public class Mage extends Player {

    private int mana;
    private final int maxMana;
    private final int maxHealth;

    public Mage(String name) {
        super(name, 85, 5, 30, 0.20f);
        this.mana = 60;
        this.maxMana = 60;
        this.maxHealth = getHealth();
    }

    public int getMana() {
        return mana;
    }

    public void setMana(int mana) {
        this.mana = Math.min(mana, maxMana);
    }

    /**
     * Intenta curarse gastando maná.
     * Coste: 20 maná, Cura: 30 salud, sin exceder maxHealth.
     * 
     * @return true si la curación se ejecutó, false si faltó maná.
     */
    public boolean heal() {
        int cost = 20;
        int healAmount = 30;
        if (mana < cost) {
            System.out.println("\nNo tienes suficiente maná para curarte.");
            return false;
        }
        mana -= cost;
        int newHealth = Math.min(getHealth() + healAmount, maxHealth);
        setHealth(newHealth);
        System.out.println("\n" + getName() + " lanza Curación (+" + healAmount + ") | Salud: " + getHealth()
                + " | Maná restante: " + mana);
        return true;
    }
}
