package proyectosudocku;


import java.awt.Color;
import javax.swing.JPanel;


public class Semaforo {
    private JPanel semafor;
    
    public Semaforo(){
        this.semafor = new JPanel();
        this.ponerAmarillo();
    }
    
    public void ponerRojo(){
        this.semafor.setBackground(Color.RED);        
    }
    
    public void ponerVerde(){
        this.semafor.setBackground(Color.GREEN);        
    }
    
    public void ponerAmarillo(){
        this.semafor.setBackground(Color.YELLOW);
    }
    
    public JPanel getSemafor(){
        return this.semafor;
    }
}
