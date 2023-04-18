// **Definir la clase Game

/**
 * Definir la clase Game
 */
public class Game {

    // Definir constantes para el ancho, alto y tamaño de la cuadrícula
    public static final int WIDTH = 500;
    public static final int HEIGHT = 500;
    public static final int GRIDSIZE = 8;

    // Definir el número de minas en función del tamaño de la cuadrícula
    public static final int MINECOUNT = (int) Math.round(GRIDSIZE * GRIDSIZE * .1);

    // Definir el constructor de la clase Game
    public Game() {
        // Crear un nuevo manejador
        Handler handler = new Handler();
        // Crear una nueva ventana con las dimensiones y el manejador especificados
        new Window(WIDTH, HEIGHT, GRIDSIZE, "Minesweeper - ", handler);
        // Actualizar el título de la ventana con el número inicial de banderas
        Window.update(0);
    }

    // Definir el método main de la clase Game
    public static void main(String[] args) {
        // Crear un nuevo juego
        new Game();
    }

    // Definir el método start del juego
    public void start() {
    }
}
