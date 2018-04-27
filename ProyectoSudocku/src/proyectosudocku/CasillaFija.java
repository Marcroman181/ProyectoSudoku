/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectosudocku;

import javax.swing.JLabel;

public class CasillaFija extends Casilla{

    private JLabel label;
    
    public CasillaFija(int label){
        super(label);
        String text=String.valueOf(label);
        this.label = new JLabel(text);
        this.label.setHorizontalAlignment(JLabel.CENTER);
        this.label.setVerticalAlignment(JLabel.CENTER);
    }
    
    public JLabel getValorLabel(){
        
        return this.label;
    }
    
}
