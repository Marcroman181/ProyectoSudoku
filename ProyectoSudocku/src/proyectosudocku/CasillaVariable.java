package proyectosudocku;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class CasillaVariable extends Casilla implements ActionListener {

    private JTextField ta;
    private Tablero tablero;

    public CasillaVariable(Tablero t) {
        super(0);
        this.ta = new JTextField(1);
        this.ta.setHorizontalAlignment(JTextField.CENTER);
        this.ta.addActionListener(this);

        this.tablero = t;

    }

    public JTextField getTextField() {
        return ta;
    }

    public void actionPerformed(ActionEvent e) {
        System.out.println("CASILLA VARIABLE: HA SALTADO EVENTO");
        boolean cambioColor = true;
        String s = this.ta.getText();

        if (!s.equals("")) {

            if (Character.isDigit(s.charAt(0))) {

                //comprbar que es un numero entre 1 y 9 
                int v = Integer.parseInt(s);
                if (v < 1 || v > 9) {
                    cambioColor = false;
                }

            } else {
                cambioColor = false;
            }

        } else {
            s = "0";
        }

        if (cambioColor) {

            this.actualizarColor(s);

        } else {

            //No se ha introducido un numero del 1 al 9
            this.ta.setText("");
            this.setValor(0);
            JOptionPane.showMessageDialog(null, "¡Introduce un número del 1 al 9!");
        }
    }

    private void actualizarColor(String s) {
        //Actualizar valor de la casilla
        System.out.println("CASILLA Actualizada");
        int v = Integer.parseInt(s);
        this.setValor(v);

        Semaforo semaforo = this.tablero.getJoc().getSemaforo();
        //Comprobamos tablero
        if (this.tablero.comprobarError()) {
            //ERROR
            //cambiar color semaforo
            System.out.println("error");
            semaforo.ponerRojo();

        } else {
            if (this.tablero.comprobarLleno()) {
                //TODO CORRECTO
                //cambiar color semaforo
                System.out.println("TODO CORRECTO");
                semaforo.ponerVerde();
            } else {
                //No hay INCORRECCIONES POR AHORA
                //cambiar color semaforo
                System.out.println("Por ahora nada incorrecto");
                semaforo.ponerAmarillo();
            }
        }
    }
}
