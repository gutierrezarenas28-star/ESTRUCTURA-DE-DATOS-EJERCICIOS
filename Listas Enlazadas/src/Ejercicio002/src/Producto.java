public class Producto {
    

    String nombre;
    int contenido;
    int diasVencer;

    Producto siguiemte;

    public Producto(String nombre, int contenido, int diasVencer) {
        this.nombre = nombre;
        this.contenido = contenido;
        this.diasVencer = diasVencer;
        this.siguiemte = null;
    }

    @Override
    public String toString() {
        return "nombre: " + nombre + ", contenido: " + contenido + ", diasVencer: " + diasVencer ;
    }

    

}
