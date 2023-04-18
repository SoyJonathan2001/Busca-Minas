// Importar las clases necesarias
import javax.swing.*;
import java.awt.event.*;

// Definir la clase Cell que extiende de la clase JButton
public class Cell extends JButton {

    // Definir las variables miembro de la clase
    private final int type; // El tipo de celda (0: vacío, 1: mina, 2: número)
    private final int position; // La posición de la celda en la cuadrícula
    private boolean discovered; // Si la celda ha sido descubierta o no
    private boolean flagged; // Si la celda ha sido marcada con una bandera o no

    private final Handler handler; // El manejador para la celda

    // Definir el constructor de la clase
    public Cell(int type, int position, boolean discovered, boolean flagged, Handler handler) {
        // Inicializar las variables miembro
        this.type = type;
        this.position = position;
        this.discovered = discovered;
        this.flagged = flagged;
        this.handler = handler;

        // Agregar un escuchador de eventos de ratón para la celda
        addMouseListener(new MouseListener() {
            // Si la celda es clickeada con el botón derecho del ratón
            @Override
            public void mouseClicked(MouseEvent e) {
                if(SwingUtilities.isRightMouseButton(e)) {
                    rightClickButton();
                } else {
                    clickButton();
                }
            }

            // Métodos no utilizados pero necesarios
            public void mouseEntered(MouseEvent e) {}
            public void mouseExited(MouseEvent e) {}
            public void mousePressed(MouseEvent e) {}
            public void mouseReleased(MouseEvent e) {}
        });
    }

    // Métodos getter para las variables miembro
    public int getType() {
        return type;
    }

    public int getPosition() {
        return position;
    }

    public boolean isDiscovered() {
        return discovered;
    }

    // Método setter para la variable miembro "discovered"
    public void setDiscovered(boolean d) {
        this.discovered = d;
    }

    public boolean isFlagged() {
        return !flagged;
    }

    // Método setter para la variable miembro "flagged"
    public void setFlagged(boolean f) {
        this.flagged = f;
    }

    // Método para cuando se hace click en la celda
    public void clickButton() {
        handler.click(this);
    }

    // Método para cuando se hace click con el botón derecho en la celda
    public void rightClickButton() {
        handler.rightClick(this);
    }
}
