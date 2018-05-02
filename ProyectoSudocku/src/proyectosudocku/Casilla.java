/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectosudocku;


public class Casilla {
    
    int valor;
    int cuadricula;
    
    public Casilla(int v, int cuadricula){
        this.valor=v;
        this.cuadricula=cuadricula;
    }
    
    public int getValor(){
        return valor;
    }
    
    public int getCuadricula(){
        return this.cuadricula;
    }    
    
    public void setValor(int valor){
        this.valor=valor;
    }
    
}
