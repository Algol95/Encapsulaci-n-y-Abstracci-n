# Debugers & Dragons 🐲 — Encapsulación, Abstracción, Herencia y Polimorfismo

Este proyecto ejemplifica principios de POO en Java aplicados a un mini–juego por consola: encapsulación, abstracción, herencia, polimorfismo y manejo de errores.

## Objetivos del refactor 🎯

- Separar responsabilidades: las entidades no calculan daño; un servicio lo hace.
- Unificar atributos comunes en una clase base.
- Permitir elegir clase de jugador mediante herencia.
- Mostrar polimorfismo al operar sobre abstracciones.
- Añadir manejo de errores para entradas de usuario.

## Arquitectura y clases principales 🏗️

- Entity (abstracta)
  - Atributos comunes: `name`, `health`, `defense`, `attack`.
  - Métodos: getters/setters y utilidades (por ejemplo, `isAlive()` si está presente).
- Enemy
  - `public class Enemy extends Entity`
  - Constructor: `Enemy(String name, int health, int defense, int attack)`.
- Player
  - `public class Player extends Entity`
  - Estado específico: `isDefending`, `criticalChance`, `criticalBonus`.
  - Base para clases concretas del jugador:
    - Warrior, Archer, Mage (heredan de Player o se instancian como tipos concretos del jugador).
    - Mage: añade comportamiento especial (mana/curación) según las acciones del menú.
- DamageService
  - Centraliza el cálculo/aplicación de daño.
  - Considera ataque, defensa, crítico del jugador y estado de defensa.
- DyDService
  - Orquesta el flujo del juego: bienvenida, selección de clase (Guerrero/Arquero/Mago), bucle de combate.
  - Muestra menú de acciones y delega el daño en `DamageService`.
  - Incluye manejo de errores con `try/catch` para entradas inválidas y evita que el programa se detenga.
- App
  - Punto de entrada (`main`) que inicia `DyDService.startGame()`.

## Principios aplicados ⚙️

- Encapsulación
  - Atributos privados con getters/setters en `Entity`, `Player`, `Enemy`.
- Abstracción
  - `DamageService` oculta la complejidad del cálculo de daño a las entidades.
- Herencia
  - `Enemy` y `Player` extienden `Entity`.
  - Clases concretas del jugador: `Warrior`, `Archer`, `Mage`.
- Polimorfismo
  - Métodos de `DamageService` aceptan parámetros del tipo base (`Entity`/`Player`/`Enemy`) y se comportan según el tipo real.
- Interfaces (ejemplo opcional)
  - Se puede ilustrar herencia múltiple con interfaces como `Defendable` (defensa) y `CriticalStrike` (golpe crítico) implementadas por `Player`. Esto permite programar por capacidades, no por tipos concretos.

## Flujo de juego 🎮

1. Se solicita el nombre del jugador.
2. Se elige la clase: 1. Guerrero, 2. Arquero, 3. Mago.
3. Se presenta un enemigo (“Dragón”) y comienza el combate.
4. Acciones:
   - Comunes: 1. Atacar, 2. Defender.
   - Mago: opciones adicionales como escudo, curación, bola de fuego (si están habilitadas).
5. Turnos alternos entre jugador y enemigo hasta que uno sea derrotado.

## Ejecutar el proyecto ✨

- Abre la carpeta del proyecto.
- Usa “Run” en `App.java` o el botón de ejecución del editor.

## Estructura de carpetas 📂

- `src`: código fuente (`App.java`, `DyDService.java`, `DamageService.java`, `Entity.java`, `Enemy.java`, `Player.java`, y clases de jugador).
- `bin`: compilados.
- `lib`: dependencias (si aplica).

## Próximos pasos 🔥

- Manejo de Errores

## Autor

- [**GaysperVT** - _@Algol95_](https://github.com/Algol95)

[![GaysperVT](https://github.com/Gaysper-Coder/.github/blob/main/Gayspear_Logo.png?raw=true)](https://www.twitch.tv/gayspervt)

