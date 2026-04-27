public class GaleriaFotos {
    Foto cabeza;
    Foto cola;
    Foto actual;

    public GaleriaFotos() {
        cabeza = null;
        cola = null;
        actual = null;
    }

    public boolean estaVacia() {
        return cabeza == null;
    }

    public void agregarFoto(String titulo, String fecha, boolean esFavorita) {
        Foto nueva = new Foto(titulo, fecha, esFavorita);

        if (estaVacia()) {
            nueva.siguiente = nueva;
            nueva.anterior = nueva;
            cabeza = nueva;
            cola = nueva;
        } else {
            cola.siguiente = nueva;
            nueva.anterior = cola;
            nueva.siguiente = cabeza;
            cabeza.anterior = nueva;
            cola = nueva;
        }

        actual = nueva;
    }

    public void siguiente() {
        if (estaVacia()) {
            System.out.println("La galería está vacía.");
            return;
        }

        actual = actual.siguiente;
        System.out.println("Foto siguiente:");
        mostrarActual();
    }

    public void anterior() {
        if (estaVacia()) {
            System.out.println("La galería está vacía.");
            return;
        }

        actual = actual.anterior;
        System.out.println("Foto anterior:");
        mostrarActual();
    }

    public void toggleFavorita() {
        if (estaVacia()) {
            System.out.println("La galería está vacía.");
            return;
        }

        actual.esFavorita = !actual.esFavorita;

        if (actual.esFavorita) {
            System.out.println("Foto marcada como favorita.");
        } else {
            System.out.println("Foto quitada de favoritas.");
        }

        mostrarActual();
    }

    public void eliminarActual() {
        if (estaVacia()) {
            System.out.println("No hay fotos para eliminar.");
            return;
        }

        System.out.println("Eliminando foto: " + actual.titulo);

        if (cabeza == cola) {
            cabeza = null;
            cola = null;
            actual = null;
            return;
        }

        Foto siguiente = actual.siguiente;

        actual.anterior.siguiente = actual.siguiente;
        actual.siguiente.anterior = actual.anterior;

        if (actual == cabeza) {
            cabeza = actual.siguiente;
        }

        if (actual == cola) {
            cola = actual.anterior;
        }

        actual = siguiente;
    }

    public void mostrarActual() {
        if (estaVacia()) {
            System.out.println("No hay foto actual.");
            return;
        }

        System.out.println("\n=== Foto actual ===");
        System.out.println("Título: " + actual.titulo);
        System.out.println("Fecha: " + actual.fecha);
        System.out.println("Favorita: " + (actual.esFavorita ? "Sí" : "No"));
    }

    public void mostrarGaleria() {
        if (estaVacia()) {
            System.out.println("La galería está vacía.");
            return;
        }

        System.out.println("\n=== Galería de Fotos ===");

        Foto temp = cabeza;
        int numero = 1;

        do {
            String marcaActual = temp == actual ? "[▶] " : "[ ] ";
            String favorita = temp.esFavorita ? "[★] " : "[ ] ";

            System.out.println(marcaActual + favorita + numero + ". "
                    + temp.titulo
                    + " | Fecha: " + temp.fecha);

            temp = temp.siguiente;
            numero++;
        } while (temp != cabeza);

        System.out.println("(galería circular: después de la última foto vuelve a la primera)");
    }
}
