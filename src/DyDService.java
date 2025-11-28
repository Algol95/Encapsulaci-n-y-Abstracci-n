import java.util.Scanner;

public class DyDService {

    private Scanner sc = new Scanner(System.in);

    public void startGame() {
        System.out.println("\n¡Bienvenido a Debugers & Dragons! Ingrese su nombre: ");

        Player p = new Player(sc.nextLine(), 100, 15, 25, 0.2f);
        Enemy e = new Enemy("Dragón", 200, 10, 25);

        System.out.println("\n¡Hola " + p.getName() + "! Te enfrentas a un dragón feroz.");

        while (p.isAlive() && e.isAlive()) {
            System.out.println("\nElige tu acción: 1. Atacar 2. Defender");
            int action = sc.nextInt();
            switch (action) {
                case 1 -> {
                    int damageToEnemy = p.attacking(e.getDefense());
                    e.receiveDamage(damageToEnemy);
                }
                case 2 -> {
                    p.setDefending(true);
                }
                default -> System.out.println("Acción inválida. Pierdes tu turno.");
            }

            if (!e.isAlive()) {
                System.out.println("¡Has derrotado al dragón! ¡Felicidades, " + p.getName() + "!");
            } else {
                p.receiveDamage(e.getAttack());
                p.setDefending(false);
            }

            if (!p.isAlive()) {
                System.out.println(
                        "Has sido derrotado por el dragón. ¡Mejor suerte la próxima vez, " + p.getName() + "!");
            }
        }
    }
}
