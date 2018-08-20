/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author aldemaro
 */
public class Asiento {
    private char columna;
    private int fila;
    private Espectador espectador;
    
    
    public Asiento(int fila,char columna){
        this.fila=fila;
        this.columna = columna;
        this.espectador =null;
    }

    public char getColumna() {
        return columna;
    }

    public void setColumna(char columna) {
        this.columna = columna;
    }

    public int getFila() {
        return fila;
    }

    public void setFila(int fila) {
        this.fila = fila;
    }

    public Espectador getEspectador() {
        return this.espectador;
    }

    public void setEspectador(Espectador espectador) {
        this.espectador = espectador;
    }
    public boolean estaVacio(){
        return espectador ==null;
    }
    
    @Override
    public String toString(){
        if(!estaVacio()){
        return "Asiento Fila:"+this.fila+" Columna: "+this.columna+" espectador: "+
                this.espectador;
        }
        else{
            return"Asiento Fila:"+this.fila+" Columna: "+this.columna+" Está Vacio";
        }
    }
          
    
    
}
