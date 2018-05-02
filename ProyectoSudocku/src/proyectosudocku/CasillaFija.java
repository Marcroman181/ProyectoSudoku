/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectosudocku;

import java.awt.Color;
import javax.swing.BorderFactory;
import javax.swing.JLabel;

public class CasillaFija extends Casilla{

    private JLabel label;
    
    public CasillaFija(int label, int cuadricula){
        super(label,cuadricula);
        String text=String.valueOf(label);
        this.label = new JLabel(text);
        this.label.setBorder(BorderFactory.createLineBorder(Color.black));
        this.label.setOpaque(true);
        if(this.getCuadricula()%2==0){
          this.label.setBackground(new Color(210,210,210)); 
        }else{
          this.label.setBackground(Color.white); 
        }
        
        this.label.setHorizontalAlignment(JLabel.CENTER);
        this.label.setVerticalAlignment(JLabel.CENTER);
    }
    
    public JLabel getValorLabel(){
        
        return this.label;
    }
    
}
