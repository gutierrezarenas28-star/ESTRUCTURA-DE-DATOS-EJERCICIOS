public class Anuncio {
    String titulo;
    int duracionSegundos;
    int vecesRepetido;
    String categoria;

    Anuncio siguiente;

    public Anuncio(String titulo, int duracionSegundos, int vecesRepetido, String categoria) {
        this.titulo = titulo;
        this.duracionSegundos = duracionSegundos;
        this.vecesRepetido = vecesRepetido;
        this.categoria = categoria;
        this.siguiente = null;
    }
}
