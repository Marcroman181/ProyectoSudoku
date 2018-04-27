package proyectosudocku;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

public class Boton implements ActionListener {
    
    private JButton boton;
    private Joc juego; 
            
    public Boton(Joc j){
        this.juego=j;
        
        this.boton = new JButton("Nuevo");
        boton.addActionListener(this);
    }
    
    public void actionPerformed(ActionEvent e) {
     
       System.out.println("BOTON: Ha saltado evento");
       this.juego.reiniciarJuego();
      
      
      //getActionCommand() ==> ens dona el nom del botó
      //getSource ens dona l'objecte que ha generat l'objecte
      //getText extreu el text de l'objecte
      
    }
    
    public JButton getBoton(){
        return this.boton;
    }
}
