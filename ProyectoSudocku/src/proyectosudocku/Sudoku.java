/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectosudocku;

import java.util.ArrayList;

public class Sudoku {
    
    private ArrayList<int[][]> sudokus;
    private static int sudokuDado=-1;
    
    public Sudoku(){
        this.sudokus =new ArrayList<int[][]>();
        this.sudokuDado++;
        this.sudokuDado=this.sudokuDado%2;
        crearSudoku();
    }
    
    public boolean addSudoku(int[][] sudoku){
        
        if(sudoku.length!=9 || sudoku[0].length!=9  ){
            return false; //Sudoku incorrecto  ================================>
        }
        
        this.sudokus.add(sudoku);
        return true;
    }
    
    public int[][] getSudoku(){
        return sudokus.get(this.sudokuDado);
    }
    
    public void crearSudoku(){
        int[][] sudoku;
        sudoku = new int[9][9];
        
        sudoku[1][0]=4;
        sudoku[2][0]=7;
        sudoku[3][0]=5;
        sudoku[4][0]=6;
        sudoku[6][0]=1;
        sudoku[8][0]=8;
        
        sudoku[8][1]=6;
        sudoku[7][1]=2;
        sudoku[4][1]=3;
        
        sudoku[1][2]=2;
        sudoku[4][2]=8;
        sudoku[8][2]=7;
        
        sudoku[1][3]=7;
        sudoku[2][3]=4;
        sudoku[5][3]=6;
        sudoku[6][3]=8;
        sudoku[7][3]=5;
        sudoku[8][3]=3;
        
        sudoku[0][4]=3;
        sudoku[6][4]=2;
        
        sudoku[3][5]=3;
        sudoku[6][5]=6;
        sudoku[7][5]=7;
       
        sudoku[1][6]=9;
        sudoku[2][6]=5;
        sudoku[3][6]=8;
        sudoku[5][6]=4;
        sudoku[6][6]=3;
        sudoku[8][6]=2;
        
        sudoku[0][7]=4;
        sudoku[2][7]=6;
        sudoku[3][7]=2;
        sudoku[6][7]=7;
        sudoku[8][7]=5;
        
        sudoku[0][8]=7;
        sudoku[1][8]=3;
        sudoku[2][8]=2;
        sudoku[3][8]=6;
        sudoku[6][8]=4;
        sudoku[8][8]=9;
        
        this.sudokus.add(sudoku);
        
        int[][] sudoku2;
        sudoku2 = new int[9][9];
        
        for(int i=0; i<9; i++){
            for(int j=0; j<9; j++){
               sudoku2[i][j]=7; 
            }
        }
        this.sudokus.add(sudoku2); 
    }
}
