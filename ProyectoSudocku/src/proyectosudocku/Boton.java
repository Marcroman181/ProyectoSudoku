package proyectosudocku;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

public class Boton extends JButton implements ActionListener {
    
    private Joc juego; 
            
    public Boton(Joc j){
        super("Nuevo Sudoku");
        this.juego=j;
        addActionListener(this);
    }
    
    public void actionPerformed(ActionEvent e) {
     
       this.juego.reiniciarJuego();
      
    }
}
