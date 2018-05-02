package proyectosudocku;

import java.awt.*;
import javax.swing.*;

public class Joc extends JFrame{

    private Tablero tablero;
    private Boton boton;
    private Semaforo semaforo;

    public Joc() {

        //CONFIGURACION VENTANA
        super("Sudoku");
        this.setSize(800, 700);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        GridBagLayout layout = new GridBagLayout();
        this.getContentPane().setLayout(layout); // Le ponemos el GridBagLayout
        this.getContentPane().setBackground(Color.gray);
       
        crearInterfaz();

        this.setVisible(true);
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
        constraints = crearConstraint(3, 2, 1, 1);
        constraints.weightx = 0.0;
        constraints.weighty = 1.0;
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.insets = new Insets(20, 20, 20, 20);
        this.getContentPane().add(this.boton, constraints);

    }

    private void crearSemaforo() {
        
        this.semaforo = new Semaforo();

        GridBagConstraints constraints = new GridBagConstraints();

        constraints = crearConstraint(3, 1, 1, 1);
        constraints.weightx = 0.0;
        constraints.weighty = 0.8;
        constraints.fill = GridBagConstraints.BOTH;
        constraints.insets = new Insets(20, 20, 20, 20);
        this.getContentPane().add(this.semaforo, constraints);
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
        
        this.getContentPane().add(this.tablero, constraints);
    }

    private void cambiarSudoku() {
        //borrar panel de la interfaz
        this.getContentPane().remove(this.tablero);
        //new tablero
        crearTablero();
        this.setVisible(true);
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