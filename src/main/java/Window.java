// Importar las clases necesarias
import javax.swing.*;
import java.awt.*;

// Definir la clase Window

/**
 * Window define la clase window las variables de la clase
 */
public class Window {

    // Definir variables de clase
    private static JFrame frame; // La ventana
    private static String title; // El título de la ventana

    // Definir el constructor de la clase

    /**
     * El constructor de la clase Window que crea la ventana de juego
     * @param width
     * @param height
     * @param gridSize
     * @param title
     * @param handler
     */
    public Window(int width, int height, int gridSize, String title, Handler handler) {
        // Asignar el título de la ventana
        Window.title = title;
        // Crear una nueva ventana con el título especificado
        frame = new JFrame(title);

        // Configurar el tamaño de la ventana
        frame.setPreferredSize(new Dimension(width, height));
        frame.setMinimumSize(new Dimension(width, height));
        frame.setMaximumSize(new Dimension(width, height));

        // Evitar que la ventana se pueda cambiar de tamaño
        frame.setResizable(false);

        // Configurar el comportamiento de la ventana al cerrar
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Centrar la ventana en la pantalla
        frame.setLocationRelativeTo(null);

        // Crear un nuevo panel con una cuadrícula y un manejador especificados
        JPanel panel = new Grid(new GridLayout(gridSize, gridSize), handler);

        // Establecer el panel como contenido de la ventana
        frame.setContentPane(panel);

        // Ajustar el tamaño de la ventana al contenido
        frame.pack();

        // Hacer visible la ventana
        frame.setVisible(true);
    }

    // Definir un método estático para actualizar el título de la ventana

    /**
     * update actuaaliza el título con el número de minas y banderas en el juego
     * @param flagged
     */
    public static void update(int flagged) {
        // Actualizar el título con el número de minas y banderas
        frame.setTitle(title + "Mines: " + Game.MINECOUNT + " - Flags: " + flagged);
    }
}
