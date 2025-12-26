import java.util.Scanner;

/**
 * Clase DyDService que manejará la lógica principal del juego Debugers &
 * Dragons.
 * 
 * @author Gaysper
 */
public class DyDService {

    private Scanner sc = new Scanner(System.in);
    private DamageService dService = new DamageService();

    /**
     * Inicia el juego Debugers & Dragons.
     */
    public void startGame() {
        System.out.println("\n¡Bienvenido a Debugers & Dragons! Ingrese su nombre: ");
        String playerName = sc.nextLine();

        System.out.println("\nElige tu clase: 1. Guerrero 2. Arquero 3. Mago");
        int classChoice = sc.nextInt();

        Player p;
        switch (classChoice) {
            case 1 -> p = new Warrior(playerName);
            case 2 -> p = new Archer(playerName);
            case 3 -> p = new Mage(playerName);
            default -> {
                System.out.println("Elección inválida. Se te asignará la clase de Guerrero por defecto.");
                p = new Warrior(playerName);
            }
        }
        Enemy e = new Enemy("Dragón", 200, 10, 25);

        System.out.println("\n¡Hola " + p.getName() + "! Te enfrentas a un dragón feroz.");

        while (p.isAlive() && e.isAlive()) {
            actionMenu(p, e);
            enemyTurn(p, e);
        }
    }

    /**
     * Menu de acciones del jugador.
     * 
     * @param p Player - El jugador que realiza la acción.
     * @param e Enemy - La entidad enemiga.
     */
    private void actionMenu(Player p, Enemy e) {
        boolean isMage = p instanceof Mage;
        if (isMage) {
            System.out.println(
                    "\nElige tu acción: 1. Atacar 2. Defender 3. Conjurar escudo 4. Conjurar curación 5. Conjurar bola de fuego");
        } else {
            System.out.println("\nElige tu acción: 1. Atacar 2. Defender");
        }
        int action = sc.nextInt();
        switch (action) {
            case 1 -> {
                dService.entityAttack(p, e);
            }
            case 2 -> {
                p.setDefending(true);
            }
            case 3 -> {
                if (isMage) {
                    ((Mage) p).spellShield();
                } else {
                    System.out.println("Acción inválida. Pierdes tu turno.");
                }
            }
            case 4 -> {
                if (isMage) {
                    ((Mage) p).spellHealing();
                } else {
                    System.out.println("Acción inválida. Pierdes tu turno.");
                }
            }
            case 5 -> {
                if (isMage) {
                    ((Mage) p).spellFireball();
                    dService.entityAttack(p, e);
                    ((Mage) p).setCastingFireball(false);
                } else {
                    System.out.println("Acción inválida. Pierdes tu turno.");
                }
            }
            default -> System.out.println("Acción inválida. Pierdes tu turno.");
        }
    }

    /**
     * Metodo para el turno del enemigo.
     * 
     * @param p Player - Entidad jugador
     * @param e Enemy - Entidad enemiga
     */
    private void enemyTurn(Player p, Enemy e) {
        if (!e.isAlive()) {
            System.out.println("¡Has derrotado al dragón! ¡Felicidades, " + p.getName() + "!");
        } else {
            dService.entityAttack(e, p);
            p.setDefending(false);
        }
        if (!p.isAlive()) {
            System.out.println(
                    "Has sido derrotado por el dragón. ¡Mejor suerte la próxima vez, " + p.getName() + "!");
        }
    }
}
