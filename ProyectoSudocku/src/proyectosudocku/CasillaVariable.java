package proyectosudocku;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import javax.swing.BorderFactory;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class CasillaVariable extends Casilla implements FocusListener, ActionListener {

    private JTextField ta;
    private Tablero tablero;

    public CasillaVariable(Tablero t, int cuadricula) {
        super(0, cuadricula);
        this.ta = new JTextField(1);
        this.ta.setHorizontalAlignment(JTextField.CENTER);
        this.ta.setBorder(BorderFactory.createLineBorder(Color.black));
        this.ta.addFocusListener(this);
        this.ta.addActionListener(this);
        
        if(this.getCuadricula()%2==0){
          this.ta.setBackground(new Color(210,210,210)); 
        }else{
          this.ta.setBackground(Color.white); 
        }
         
        this.tablero = t;

    }

    public JTextField getTextField() {
        return ta;
    }
    
    public void focusGained(FocusEvent e){
        this.ta.setBackground(Color.blue);
    }
   
    public void focusLost(FocusEvent e) {
        
        if(this.getCuadricula()%2==0){
          this.ta.setBackground(new Color(210,210,210)); 
        }else{
          this.ta.setBackground(Color.white); 
        }
        
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

    public void actionPerformed(ActionEvent e) {
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
        int v = Integer.parseInt(s);
        this.setValor(v);

        Semaforo semaforo = this.tablero.getJoc().getSemaforo();
        //Comprobamos tablero
        if (this.tablero.comprobarError()) {
            //ERROR
            //cambiar color semaforo
            semaforo.ponerRojo();

        } else {
            if (this.tablero.comprobarLleno()) {
                //TODO CORRECTO
                //cambiar color semaforo
                semaforo.ponerVerde();
                JOptionPane.showMessageDialog(null, "¡Has ganado!");
            } else {
                //No hay INCORRECCIONES POR AHORA
                //cambiar color semaforo
                semaforo.ponerAmarillo();
            }
        }
    }
}
