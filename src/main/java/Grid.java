import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/**
 * Clase Grid la cual se definen variables
 */
public class Grid extends JPanel {

    // Variable privada que indica si una mina ha sido elegida en la creación de celdas
    private boolean picked = false;

    // ArrayList que contiene las posiciones de las minas
    private final ArrayList<Integer> mines = new ArrayList<Integer>();

    // ArrayList de celdas que componen la cuadrícula
    public static ArrayList<Cell> cellGrid = new ArrayList<Cell>();


    /**
     * Constructor de la clase Grid.
     * @param g Objeto GridLayout que indica el diseño de la cuadrícula
     * @param h Objeto Handler para asignar a las celdas creadas
     */
    public Grid(GridLayout g, Handler h) {
        super(g);
        createCells(h);
        addCells();
    }

    /**
     * Método encargado de crear las celdas de la cuadrícula y determinar si contienen una mina o no.
     * @param h objeto Handler para asignar a las celdas creadas
     */
    public void createCells(Handler h) {
        // Calcular el límite superior de la cantidad de celdas en la cuadrícula
        int bound = Game.GRIDSIZE * Game.GRIDSIZE;
        // Agregar las minas a la lista "mines"
        for(int i = 1; i <= Game.MINECOUNT; i++) {
            while(!picked) {
                // Seleccionar una posición de mina al azar
                int minePosition = (int) (Math.random() * bound);
                // Si la posición no se encuentra en la lista "mines", agregarla y establecer "picked"
                // como verdadero para salir del bucle "while"
                if (!mines.contains(minePosition)) {
                    mines.add(minePosition);
                    picked = true;
                }
            }
            // Restablecer "picked" como falso para seleccionar otra posición de mina
            picked = false;
        }

        // Crear las celdas de la cuadrícula
        for(int i = 0; i < bound; i++) {
            if(mines.contains(i)) {
                // Si la posición actual contiene una mina, crear una celda con valor 1 (mina) y agregarla a la lista "cellGrid"
                cellGrid.add(new Cell(1, i, false, false, h));
            } else if(i % Game.GRIDSIZE == 0){
                //Si la posición actual está en el borde izquierdo de la cuadrícula, determinar si hay minas en
                // las posiciones adyacentes y crear una celda con valor 2 (adyacente a minas) o 0 (sin minas) según corresponda
                if(mines.contains(i - Game.GRIDSIZE) ||
                        mines.contains(i - Game.GRIDSIZE + 1) ||
                        mines.contains(i + 1) ||
                        mines.contains(i + Game.GRIDSIZE) ||
                        mines.contains(i + Game.GRIDSIZE + 1)) {
                    cellGrid.add(new Cell(2, i, false, false, h));
                } else {
                    cellGrid.add(new Cell(0, i, false, false, h));
                }
            } else if(i % Game.GRIDSIZE == Game.GRIDSIZE - 1){
                // Si la posición actual está en el borde derecho de la cuadrícula, determinar si hay minas en las
                // posiciones adyacentes y crear una celda con valor 2 (adyacente a minas) o 0 (sin minas) según corresponda
                if(mines.contains(i - Game.GRIDSIZE - 1) ||
                        mines.contains(i - Game.GRIDSIZE) ||
                        mines.contains(i - 1) ||
                        mines.contains(i + Game.GRIDSIZE - 1) ||
                        mines.contains(i + Game.GRIDSIZE)) {
                    cellGrid.add(new Cell(2, i, false, false, h));
                } else {
                    cellGrid.add(new Cell(0, i, false, false, h));
                }
            }else {
                if(mines.contains(i - Game.GRIDSIZE - 1) ||
                        mines.contains(i - Game.GRIDSIZE) ||
                        mines.contains(i - Game.GRIDSIZE + 1) ||
                        mines.contains(i - 1) ||
                        mines.contains(i + 1) ||
                        mines.contains(i + Game.GRIDSIZE - 1) ||
                        mines.contains(i + Game.GRIDSIZE) ||
                        mines.contains(i + Game.GRIDSIZE + 1)) {
                    cellGrid.add(new Cell(2, i, false, false, h));
                } else {
                    cellGrid.add(new Cell(0, i, false, false, h));
                }
            }
        }
    }
    //contiene todas las celdas de la cuadrícula, y se le asigna
    // un objeto Handler para manejar los eventos de clic.
    private void addCells() {
        for (Cell cell : cellGrid) {
            add(cell);
        }
    }
    /**
    public int getNumRows() {
        return 0;
    }

    public int getNumCols() {
        return 0;
    }

    public boolean isCellRevealed(int row, int col) {
        return false;
    }

    public boolean isCellMine(int row, int col) {
        return false;
    }

    public boolean isCellMarked(int row, int col) {
        return false;
    }

    public void markCell(int row, int col) {

    }

    public void revealCell(int row, int col) {

    }
     **/
}