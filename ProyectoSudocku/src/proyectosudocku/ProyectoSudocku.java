/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectosudocku;

public class ProyectoSudocku {

    private Joc j;
     
    public ProyectoSudocku(){
        
    } 
   
    public static void main(String[] args) {
       
        ProyectoSudocku ps = new ProyectoSudocku();
        ps.crearJoc();
    }
    
    private void crearJoc(){
        this.j = new Joc();
    }
    
}
