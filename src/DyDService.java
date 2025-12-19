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

        Player p = new Player(sc.nextLine(), 100, 15, 25, .2f);
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
        System.out.println("\nElige tu acción: 1. Atacar 2. Defender");
        int action = sc.nextInt();
        switch (action) {
            case 1 -> {
                dService.entityAttack(p, e);
            }
            case 2 -> {
                p.setDefending(true);
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
