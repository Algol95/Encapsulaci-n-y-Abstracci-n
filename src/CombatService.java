import java.util.Random;

public class CombatService {

    private final Random rng = new Random();

    public void playerAttack(Player player, Enemy enemy) {
        int damage = computePlayerDamage(player, enemy);
        applyDamageToEnemy(enemy, damage);
        System.out.println("\n" + player.getName() + " ataca causando " + damage + " puntos de daño.");
    }

    public void enemyAttack(Player player, Enemy enemy) {
        int base = enemy.getAttack() - player.getDefense();
        if (base < 0)
            base = 0;

        int dmgToPlayer;
        if (player.isDefending()) {
            player.setCriticalBonus(player.getCriticalBonus() + 0.15f);
            dmgToPlayer = base / 2;
            System.out.println("\n" + player.getName() + " está defendiendo, probabilidad de golpe crítico aumentada.");
        } else {
            dmgToPlayer = base;
        }

        applyDamageToPlayer(player, dmgToPlayer);
        System.out.println(enemy.getName() + " ataca causando " + dmgToPlayer + " puntos de daño.");
    }

    private int computePlayerDamage(Player player, Enemy enemy) {
        int totalAttack = player.getAttack() - enemy.getDefense();
        if (totalAttack < 0)
            totalAttack = 0;

        if (isCriticalHit(player)) {
            totalAttack *= 2;
            System.out.println("\n¡Golpe crítico!");
        }
        return totalAttack;
    }

    private boolean isCriticalHit(Player player) {
        float chance = player.getCriticalChance() + player.getCriticalBonus();
        if (chance < 0f)
            chance = 0f;
        return rng.nextFloat() < chance;
    }

    private void applyDamageToEnemy(Enemy enemy, int netDamage) {
        if (netDamage < 0)
            netDamage = 0;
        int newHealth = enemy.getHealth() - netDamage;
        if (newHealth < 0)
            newHealth = 0;
        enemy.setHealth(newHealth);
        System.out.println(enemy.getName() + " ha recibido " + netDamage + " puntos de daño. Salud restante: "
                + enemy.getHealth());
    }

    private void applyDamageToPlayer(Player player, int netDamage) {
        if (netDamage < 0)
            netDamage = 0;
        int newHealth = player.getHealth() - netDamage;
        if (newHealth < 0)
            newHealth = 0;
        player.setHealth(newHealth);
        System.out.println(player.getName() + " ha recibido " + netDamage + " puntos de daño. Salud restante: "
                + player.getHealth());
    }
}
