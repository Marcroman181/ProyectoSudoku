package proyectosudocku;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class Tablero extends JPanel {

    private Casilla[][] casillas;
    private Joc juego;

    public Tablero(Joc j){
        super();
        this.juego=j;
        
        this.setBorder(BorderFactory.createMatteBorder(10, 2, 2, 2, Color.BLACK));
        GridBagLayout gbl = new GridBagLayout();
        this.setLayout(gbl);
    }
    
    public Tablero(Joc j, int[][] s) {
        super();
        this.juego=j;
        
        casillas = new Casilla[9][9];
        
        this.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.BLACK));
        GridBagLayout gbl = new GridBagLayout();
        this.setLayout(gbl);
        
        rellenarTablero(s);
    }

    private void rellenarTablero(int[][] s) {

        GridBagConstraints constraints = new GridBagConstraints();
        int cuadricula;
        
        for (int row = 0; row < 9; row++) {

            for (int col = 0; col < 9; col++) {

                constraints = crearConstraint2(row, col);
                
                cuadricula = (col/3+1)+(row/3)*3;
                
                if (s[row][col] != 0) {
                    this.casillas[row][col] = new CasillaFija(s[row][col], cuadricula);
                    this.add(((CasillaFija) this.casillas[row][col]).getValorLabel(), constraints);

                } else {
                    this.casillas[row][col] = new CasillaVariable(this, cuadricula);
                    this.add(((CasillaVariable) this.casillas[row][col]).getTextField(), constraints);
                }

            }
        }
    }

    private GridBagConstraints crearConstraint2(int x, int y) {

        GridBagConstraints constraints = new GridBagConstraints();
        constraints.gridx = x;
        constraints.gridy = y;
        constraints.gridwidth = 1;
        constraints.gridheight = 1;
        constraints.weightx = 1.0;
        constraints.weighty = 1.0;
        constraints.fill = GridBagConstraints.BOTH;
        return constraints;
    }

    public boolean comprobarError() {

        for (int row = 0; row < 9; row++) {
            if (comprobarFila(row)) {
                return true; //ERROR ======================>
            }
        }
        for (int col = 0; col < 9; col++) {
            if (comprobarColumna(col)) {
                return true; //ERROR ======================>
            }
        }
        for (int cuadricula = 0; cuadricula < 9; cuadricula++) {
            if (comprobarCuadricula(cuadricula)) {
                return true; //ERROR ======================>
            }
        }

        return false; // NO ERROR
    }

    private boolean comprobarFila(int row) {

        boolean[] apariciones = new boolean[9];

        for (int j = 0; j < 9; j++) {
            apariciones[j] = false;
        }

        for (int j = 0; j < 9; j++) {

            if (this.casillas[row][j].getValor() != 0) {

                if (apariciones[this.casillas[row][j].getValor() - 1]) {
                    return true;// ERROR =====================================>
                } else {
                    apariciones[this.casillas[row][j].getValor() - 1] = true;
                }
            }
        }
        return false;
    }

    private boolean comprobarColumna(int col) {
        boolean[] apariciones = new boolean[9];

        for (int j = 0; j < 9; j++) {
            apariciones[j] = false;
        }

        for (int j = 0; j < 9; j++) {

            if (this.casillas[j][col].getValor() != 0) {

                if (apariciones[this.casillas[j][col].getValor() - 1]) {
                    return true;// ERROR =====================================>
                } else {
                    apariciones[this.casillas[j][col].getValor() - 1] = true;
                }
            }
        }
        return false;
    }

    private boolean comprobarCuadricula(int i) {

        boolean[] apariciones = new boolean[9];
        int row = ((i) / 3) * 3 + 1;
        int col = ((i) % 3) * 3 + 1;

        for (int j = 0; j < 9; j++) {
            apariciones[j] = false;
        }
        for (int fila = row - 1; fila <= row + 1; fila++) {
            for (int columna = col - 1; columna <= col + 1; columna++) {

                if (this.casillas[fila][columna].getValor() != 0) {

                    if (apariciones[this.casillas[fila][columna].getValor() - 1]) {

                        return true;// ERROR =================================>
                    } else {
                        apariciones[this.casillas[fila][columna].getValor() - 1] = true;
                    }
                }
            }
        }
        return false;
    }

    public boolean comprobarLleno() {

        for (int row = 0; row < 9; row++) {

            for (int col = 0; col < 9; col++) {

                if (this.casillas[row][col].getValor() == 0) {
                    return false; // NO ESTA LLENO ============================>
                }
            }
        }
        return true; //LLENO
    }
    
    public Casilla getCasilla(int row, int col){
        return this.casillas[row][col];
    }
    
    public Joc getJoc(){
        return this.juego;
    }
}