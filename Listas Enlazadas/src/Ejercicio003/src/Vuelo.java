public class Vuelo {
    
    String numeroVuelo;
    String aerolinea;
    int combustibleRestante;
    int pasajeros;

    Vuelo siguiente;

    public Vuelo(String numeroVuelo, String aerolinea, int combustibleRestante, int pasajeros) {
        this.numeroVuelo = numeroVuelo;
        this.aerolinea = aerolinea;
        this.combustibleRestante = combustibleRestante;
        this.pasajeros = pasajeros;
        this.siguiente = null;
    }

    @Override
    public String toString() {
        return "Numero de vuelo: " + numeroVuelo + 
               ", Aerolinea: " + aerolinea +
               ", Combustible: " + combustibleRestante +
               ", Pasajeros: " + pasajeros;
    }
}
