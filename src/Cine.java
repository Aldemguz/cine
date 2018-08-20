/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author aldemaro
 */
public class Cine {
    private final int capacidadFila;
    private final int capacidadColumna;
    private Pelicula pelicula;
    private double precioEntrada;
    private Asiento asientos[][];
    
    public Cine(int capacidadFila, int capacidadColumna, Pelicula pelicula, 
            double precioEntrada ){
        if(capacidadColumna<=0 && capacidadFila<=0){
                System.out.println("Capacidad Columna minimo es de 1");
                this.capacidadColumna=1;
                System.out.println("Capacidad Fila minimo es de 1");
                this.capacidadFila=1;
            }
        else{
            if(capacidadColumna>25){
                //A(65) - Z (90)
                System.out.println("Capacidad Columnas maxima es de 25");
                this.capacidadColumna=25;
                this.capacidadFila=capacidadFila;
            }
            else{
                this.capacidadFila= capacidadFila;
                this.capacidadColumna = capacidadColumna;
            }
        }
        //Todo el codigo de arriba, solo verifica que las columas sean de un 
        //caracter A-Z (25 columnas max). y las filas q sean de 1 o más.
        this.pelicula = pelicula;
        this.precioEntrada = precioEntrada;
        asientos = new Asiento[this.capacidadFila][this.capacidadColumna];
        rellenarAsientos();
    }

    public Pelicula getPelicula() {
        return pelicula;
    }

    public void setPelicula(Pelicula pelicula) {
        this.pelicula = pelicula;
    }

    public double getPrecioEntrada() {
        return precioEntrada;
    }

    public void setPrecioEntrada(double precioEntrada) {
        this.precioEntrada = precioEntrada;
    }

    public Asiento[][] getAsientos() {
        return asientos;
    }

    public void setAsientos(Asiento[][] asientos) {
        this.asientos = asientos;
    }
    
    private void rellenarAsientos(){
        for(int i = (this.capacidadFila-1); i>=0;i--){
            for(int j=0;j<this.capacidadColumna;j++){
                //System.out.print("["+i+"|"+(char)(j+'A')+"]");
                asientos[i][j]= new Asiento(i,(char)(j+'A'));
            }
            //System.out.println(" ");
        }
    }
    
    public boolean haySitio(){
        for(int i=0; i<this.capacidadFila;i++){
            for(int j=0;j<this.capacidadColumna;j++){
                if(asientos[i][j].estaVacio())
                    return true;
            }
        }
        return false;
    }
    
    public boolean sePuedeSentar(Espectador e){
        return e.tieneDinero(precioEntrada) && e.edadMinima(pelicula.getEdadMinima());
    }
    
    public boolean butacaLibre(int fila, char columna){
        return asientos[fila][columna-'A'].estaVacio();
    }
    
    public void sentar(int fila, char columna, Espectador e){
        asientos[fila][columna - 'A'].setEspectador(e);
    }
    
    public int getColumnas(){
        return capacidadColumna;
    }
    
    public int getFilas(){
        return capacidadFila;
    }
    
    public void mostrar (){
        System.out.println("Información cine");
        System.out.println("Pelicula reproducida: " + pelicula);
        System.out.println("Precio entrada: " + precioEntrada);
        System.out.println("");
        for (int i = 0; i< capacidadFila; i++) {
            for (int j = 0; j < capacidadColumna; j++) {
                System.out.println(asientos[i][j]);
            }
            System.out.println("");
        }
    }

}


