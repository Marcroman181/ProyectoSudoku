package proyectosudocku;


import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.JPanel;


public class Semaforo extends JPanel{

    private JPanel amarillo;
    private JPanel rojo;
    private JPanel verde; 
    
    public Semaforo(){
        super();
        this.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.BLACK));
        GridLayout gl = new GridLayout(3,1);
        this.setLayout(gl);
        
        this.amarillo = new JPanel();
        this.rojo = new JPanel();
        this.verde = new JPanel();
        
        this.rojo.setBorder(BorderFactory.createMatteBorder(2, 2, 0, 2, Color.BLACK));
        this.amarillo.setBorder(BorderFactory.createMatteBorder(0, 2, 2, 2, Color.BLACK));
        this.verde.setBorder(BorderFactory.createMatteBorder(0, 2, 2, 2, Color.BLACK));
        
        this.add(this.rojo);
        this.add(this.amarillo);
        this.add(this.verde);
        
        this.ponerAmarillo();
    }
    
    public void ponerRojo(){
        this.amarillo.setBackground(Color.BLACK);
        this.verde.setBackground(Color.BLACK);
        this.rojo.setBackground(Color.RED);     
    }
    
    public void ponerVerde(){
        this.amarillo.setBackground(Color.BLACK);
        this.verde.setBackground(Color.GREEN);
        this.rojo.setBackground(Color.BLACK);       
    }
    
    public void ponerAmarillo(){
        this.amarillo.setBackground(Color.YELLOW);
        this.verde.setBackground(Color.BLACK);
        this.rojo.setBackground(Color.BLACK);
    }
}
