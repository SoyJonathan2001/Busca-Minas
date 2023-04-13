import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Menu extends JFrame implements ActionListener {

    private JButton button1, button2;

    public Menu() {
        super("Menu");

        // Configuración de la ventana
        setSize(400, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Creación de los botones
        button1 = new JButton("Dummy Level");
        button2 = new JButton("Advanced Level");

        // Configuración de los botones
        button1.addActionListener(this);
        button2.addActionListener(this);

        // Creación del panel de contenido
        JPanel contentPane = new JPanel();
        contentPane.setLayout(new FlowLayout());
        contentPane.add(button1);
        contentPane.add(button2);

        // Asignación del panel de contenido a la ventana
        setContentPane(contentPane);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == button1) {
            // Crear una instancia de la clase "Game" y llamar al método "start"
            Game game = new Game();
            game.start();
        } else if (e.getSource() == button2) {
            /// Crear una instancia de la clase "Game" y llamar al método "start"
            Game game = new Game();
        }
    }

    public static void main(String[] args) {
        Menu menu = new Menu();
        menu.setVisible(true);
    }
}
