public class Cancion {
    
    String titulo;
    String artista;
    int duracionSegundos;
    String genero;

    Cancion siguiente;

    public Cancion(String titulo, String artista, int duracionSegundos, String genero) {
        this.titulo = titulo;
        this.artista = artista;
        this.duracionSegundos = duracionSegundos;
        this.genero = genero;
        this.siguiente = null;
    }

    @Override
    public String toString() {
        return "Titulo: " + titulo +
               ", Artista: " + artista +
               ", Duracion: " + duracionSegundos + " seg" +
               ", Genero: " + genero;
    }
}
