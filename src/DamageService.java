import java.util.Random;

/**
 * Clase DamageService que manejará la lógica relacionada con el daño en el
 * juego.
 * 
 * @author Gaysper
 */
public class DamageService {

    private final Random RNG = new Random();

    /**
     * Método para determinar si el ataque es un golpe crítico.
     * 
     * @return true si el ataque es crítico, false en caso contrario.
     */
    private boolean isCriticalHit(Player p) {
        float chance = p.getCriticalChance() + p.getCriticalBonus();
        return RNG.nextFloat() < chance;
    }

    /**
     * Método para calcular el daño total que un jugador inflige a un enemigo.
     * 
     * @param p Player - El jugador que realiza el ataque.
     * @param e Enemy - La entidad enemiga
     * @return int El daño total infligido al enemigo.
     */
    public int computeDamagePlayer(Player p, Enemy e) {
        int damageTotal = p.getAttack() - e.getDefense();

        if (damageTotal < 0)
            damageTotal = 0;

        if (isCriticalHit(p)) {
            damageTotal *= 2;
            System.out.println("\n¡Golpe crítico!");
        }

        return damageTotal;
    }

    /**
     * Método para que un jugador ataque a un enemigo.
     * 
     * @param p Player - El jugador que realiza el ataque.
     * @param e Enemy - La entidad enemiga
     */
    public void playerAttack(Player p, Enemy e) {
        int damage = computeDamagePlayer(p, e);
        System.out.println("\n" + p.getName() + " ataca causando " + damage + " puntos de daño.");
        applyDamageToEntity(e, damage);
    }

    /**
     * Método para aplicar daño a un enemigo.
     * 
     * @param e      Enemy - La entidad enemiga.
     * @param damage int - El daño a aplicar.
     */
    private void applyDamageToEntity(Entity e, int damage) {
        int newHealth = e.getHealth() - damage;
        if (newHealth < 0)
            newHealth = 0;
        e.setHealth(newHealth);
        System.out.println("\nLa salud restante de " + e.getName() + " es: " + e.getHealth());
    }

    /**
     * Método para que un enemigo ataque a un jugador.
     * 
     * @param e Enemy - La entidad enemiga.
     * @param p Player - El jugador que recibe el ataque.
     */
    public void enemyAttack(Enemy e, Player p) {
        int damage = computeDamageEnemy(e, p);
        System.out.println("\n" + e.getName() + " ataca causando " + damage + " puntos de daño.");
        applyDamageToEntity(p, damage);
    }

    /**
     * Método para calcular el daño total que un enemigo inflige a un jugador.
     * 
     * @param e Enemey - El enemigo que realiza el ataque.
     * @param p Player - El jugador que recibe el ataque.
     * @return int El daño total infligido al jugador.
     */
    public int computeDamageEnemy(Enemy e, Player p) {
        int damageTotal = e.getAttack() - p.getDefense();

        if (damageTotal < 0)
            damageTotal = 0;

        if (p.isDefending()) {
            damageTotal /= 2;
            p.setCriticalBonus(p.getCriticalBonus() + .15f);
            System.out.println(
                    "\n¡" + p.getName() + " se está defendiendo! La probabilidad de golpe crítico ha aumentado a: "
                            + (p.getCriticalChance() + p.getCriticalBonus()) * 100 + "%");
        }

        return damageTotal;
    }

}
