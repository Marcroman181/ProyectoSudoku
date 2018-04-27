package proyectosudocku;

import java.awt.*;
import javax.swing.*;

public class Joc {

    private JFrame f;
    private Tablero tablero;
    private Boton boton;
    private Semaforo semaforo;

    public Joc() {

        //CONFIGURACION VENTANA
        this.f = new JFrame("Sudoku");
        this.f.setSize(800, 700);
        this.f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        GridBagLayout layout = new GridBagLayout();
        this.f.getContentPane().setLayout(layout); // Le ponemos el GridBagLayout
        this.f.getContentPane().setBackground(Color.LIGHT_GRAY);

        crearInterfaz();

        this.f.setVisible(true);
    }

    public void iniciarJuego() {

    }

    public void reiniciarJuego() {

        cambiarSudoku();
        //reiniciar semaforo
        this.semaforo.ponerAmarillo();
    
    }

    private void crearInterfaz() {


        //Boton
        crearBoton();

        //semaforo
        crearSemaforo();

        //Tablero
        crearTablero();
        
        //tiempo
    //    crearCronometro();

    }

    private void crearBoton() {
        
        this.boton = new Boton(this);
        
        GridBagConstraints constraints = new GridBagConstraints();
        constraints = crearConstraint(3, 1, 1, 1);
        constraints.weightx = 0.0;
        constraints.weighty = 1.0;
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.insets = new Insets(20, 20, 20, 20);
        this.f.getContentPane().add(this.boton.getBoton(), constraints);

    }

    private void crearSemaforo() {
        
        this.semaforo = new Semaforo();

        GridBagConstraints constraints = new GridBagConstraints();

        constraints = crearConstraint(3, 2, 1, 1);
        constraints.weightx = 0.0;
        constraints.weighty = 1.0;
        constraints.fill = GridBagConstraints.BOTH;
        constraints.insets = new Insets(20, 20, 20, 20);
        this.f.getContentPane().add(this.semaforo.getSemafor(), constraints);
    }

    private void crearTablero() {
        
        Sudoku s = new Sudoku();
        this.tablero = new Tablero(this, s.getSudoku());
        
        GridBagConstraints constraints = new GridBagConstraints();

        constraints = crearConstraint(0, 0, 3, 3);
        constraints.weightx = 1.0;
        constraints.weighty = 1.0;
        constraints.fill = GridBagConstraints.BOTH;
        constraints.insets = new Insets(10, 10, 10, 10);
        this.f.getContentPane().add(this.tablero.getPanel(), constraints);
    }

    private void cambiarSudoku() {
        //borrar panel de la interfaz
        this.f.getContentPane().remove(this.tablero.getPanel());
        //new tablero
        crearTablero();
        this.f.setVisible(true);
    }
    
    public Semaforo getSemaforo(){
        return this.semaforo;
    }

    private GridBagConstraints crearConstraint(int x, int y, int width, int height) {

        GridBagConstraints constraints = new GridBagConstraints();
        constraints.gridx = x;
        constraints.gridy = y;
        constraints.gridwidth = width;
        constraints.gridheight = height;
        return constraints;
    }

}
