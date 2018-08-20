
import java.util.Scanner;

/*

/**
 *Nos piden hacer un programa orientado a objetos sobre un cine (solo de una sala) 
tiene un conjunto de asientos (8 filas por 9 columnas, por ejemplo).
Del cine nos interesa conocer la película que se está reproduciendo y el precio de 
la entrada en el cine.

De las películas nos interesa saber el título, duración, edad mínima y director.

Del espectador, nos interesa saber su nombre, edad y el dinero que tiene.

Los asientos son etiquetados por una letra (columna) y un número (fila), la fila 
1 empieza al final de la matriz como se muestra en la tabla. También deberemos saber 
si está ocupado o no el asiento.

8 A 8 B 8 C 8 D 8 E 8 F 8 G 8 H 8 I
7 A 7 B 7 C 7 D 7 E 7 F 7 G 7 H 7 I
6 A 6 B 6 C 6 D 6 E 6 F 6 G 6 H 6 I
5 A 5 B 5 C 5 D 5 E 5 F 5 G 5 H 5 I
4 A 4 B 4 C 4 D 4 E 4 F 4 G 4 H 4 I
3 A 3 B 3 C 3 D 3 E 3 F 3 G 3 H 3 I
2 A 2 B 2 C 2 D 2 E 2 F 2 G 2 H 2 I
1 A 1 B 1 C 1 D 1 E 1 F 1 G 1 H 1 I

Realizaremos una pequeña simulación, en el que generaremos muchos espectadores y los
sentaremos aleatoriamente (no podemos donde ya este ocupado).
En esta versión sentaremos a los espectadores de uno en uno.

Solo se podrá sentar si tienen el suficiente dinero, hay espacio libre y tiene edad 
para ver la película, en caso de que el asiento este ocupado le buscamos uno libre.
Los datos del espectador y la película pueden ser totalmente aleatorios.
 * @author aldemaro
 */

// ASCII A(65) - Z(90) = 25 caracteres;
// ASCII a(97) - z(122) = 25 caracteres;
public class Main {

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        int numCol;
        int numFil;
        double precioEntrada;
        Pelicula pelicula = new Pelicula("Buscando a Nemo",125,12,"Aldemaro");
        System.out.println("Indique el numero(>=1) de Filas del cine");
        numFil= Integer.parseInt(entrada.nextLine());
        System.out.println("Indique el numero(1-25) de Columnas del cine");
        numCol= Integer.parseInt(entrada.nextLine());
        System.out.println("Indique el precio de la entrada");
        precioEntrada = Double.valueOf(entrada.nextLine());
        Cine alto_prado = new Cine(numFil,numCol,pelicula,precioEntrada);
        
        System.out.println("Introduce el numero de espectadores: ");
        int numEspectadores = Integer.parseInt(entrada.nextLine());
        
        int cont = 1;
        while(alto_prado.haySitio() && cont<=numEspectadores){
        // Creando el espectador
        String nombre_e = Metodos.nombres[Metodos.genNum(0, Metodos.nombres.length -1)];
        int edad_e = Metodos.genNum(5,30);
        double dinero_e = Metodos.genNum(30,200);
        Espectador e = new Espectador(nombre_e,edad_e,dinero_e);
            if(alto_prado.sePuedeSentar(e)){
                e.pagar(precioEntrada);
                int fila = Metodos.genNum(0,alto_prado.getFilas()-1);
                char col = (char)(Metodos.genNum('A',('A'+alto_prado.getColumnas()-1)));
                //mientras no esté libre la butaca, buscamos otra.
                while(!alto_prado.butacaLibre(fila, col)){
                fila = Metodos.genNum(0,alto_prado.getFilas()-1);
                col = (char)(Metodos.genNum('A',('A'+alto_prado.getColumnas()-1)));
                }
                //Cuando el while termina, debo tener la col y la fila de la butaca
                
                alto_prado.sentar(fila, col, e);
                cont++;
             }
        }
        
        alto_prado.mostrar();
        
    }
    
}
