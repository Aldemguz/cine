/*
 
 * @author aldemaro
 */
public class Espectador {
    private String nombre;
    private int edad;
    private double dinero;
    
    public Espectador(String nombre, int edad, double dinero){
        this.nombre = nombre;
        this.edad = edad;
        this.dinero = dinero;
    }

    public String getNombre() {
        return nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public double getDinero() {
        return dinero;
    }

    public void setDinero(double dinero) {
        this.dinero = dinero;
    }
    
     public boolean edadMinima(int edadRequerida){
        return this.edad>=edadRequerida;
    }
     
     public boolean tieneDinero(double precioEntrada){
         return this.dinero >= precioEntrada;
     }
     
     public void pagar(double entrada){
         this.dinero -= entrada;
     }
     
    @Override
     public String toString(){
         return "el nombre del espectador es: "+this.nombre+" de "+this.edad+
                 " años  y con "+this.dinero+" dinero";
     }
}
