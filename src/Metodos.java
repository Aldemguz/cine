/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author aldemaro
 */
public class Metodos {
    public static final String nombres[]= {"Aldemaro","Maria","Adrian","Marcos",
        "Carlos","Elba","Albert","Gladymar","Irina","Edicson"};
   
    public static final int genNum(int minimo, int maximo){
        int num = (int) (Math.random() * (minimo - (maximo + 1)) + (maximo + 1));
        return num;
    }
}
