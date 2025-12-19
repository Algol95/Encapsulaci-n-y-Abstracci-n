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
     * Método para calcular el daño que hace una entidad a otra.
     * 
     * @param attacker Entity - La entidad que realiza el ataque.
     * @param defender Entity - La entidad que recibe el ataque.
     * @return int - El daño calculado.
     */
    public int computeDamageEntity(Entity attacker, Entity defender) {
        int damageTotal = attacker.getAttack() - defender.getDefense();
        if (damageTotal < 0)
            damageTotal = 0;

        if (attacker instanceof Player) {
            if (isCriticalHit((Player) attacker)) {
                damageTotal *= 2;
                System.out.println("\n¡Golpe crítico!");
            }
        } else {
            if (((Player) defender).isDefending()) {
                damageTotal /= 2;
                ((Player) defender).setCriticalBonus(((Player) defender).getCriticalBonus() + .15f);
            }
        }
        return damageTotal;
    }

    /**
     * Método para que una entidad ataque a otra.
     * 
     * @param attacker Entity - La entidad que realiza el ataque.
     * @param defender Entity - La entidad que recibe el ataque.
     */
    public void entityAttack(Entity attacker, Entity defender) {
        int damage = computeDamageEntity(attacker, defender);
        System.out.println("\n" + attacker.getName() + " ataca causando " + damage + " puntos de daño.");
        applyDamageToEntity(defender, damage);
    }

    /**
     * Método para aplicar daño a una entidad.
     * 
     * @param ent    Entity - La entidad que recibe el daño.
     * @param damage int - El daño a aplicar.
     */
    public void applyDamageToEntity(Entity ent, int damage) {
        int newHealth = ent.getHealth() - damage;
        if (newHealth < 0)
            newHealth = 0;
        ent.setHealth(newHealth);

        if (ent instanceof Enemy) {
            System.out.println("La salud restante del " + ent.getName() + " es: " + ent.getHealth());
        } else {
            System.out.println("\nLa salud restante de nuestro heroe " + ent.getName() + " es: " + ent.getHealth());
        }
    }

}
