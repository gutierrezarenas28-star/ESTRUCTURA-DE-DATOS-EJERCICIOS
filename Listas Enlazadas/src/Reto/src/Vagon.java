package Reto.src;

public class Vagon {
    String contenido;
    double pesoToneladas;
    String origen;
    String destino;

    Vagon siguiente;

    public Vagon(String contenido, double pesoToneladas, String origen, String destino) {
        this.contenido = contenido;
        this.pesoToneladas = pesoToneladas;
        this.origen = origen;
        this.destino = destino;
        this.siguiente = null;
    }

    public Vagon getSiguiente(){
        return this.siguiente;
    }
    
}
