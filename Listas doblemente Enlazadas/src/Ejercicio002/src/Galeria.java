public class Galeria {
     Fotografia cabeza;
    Fotografia cola;

    public Galeria() {
        this.cabeza = null;
        this.cola = null;
    }

    public void agregarFoto(Fotografia foto) {
        if (cabeza == null) {
            cabeza = foto;
            cola = foto;
        } else {
            cola.siguiente = foto;
            foto.anterior = cola;
            cola = foto;
        }
    }

    public Fotografia siguienteFoto(Fotografia fotoActual) {
        if (fotoActual.siguiente == null) {
            System.out.println("No hay más fotos hacia adelante.");
            return fotoActual;
        }
        return fotoActual.siguiente;
    }

    public Fotografia fotoAnterior(Fotografia fotoActual) {
        if (fotoActual.anterior == null) {
            System.out.println("No hay más fotos hacia atrás.");
            return fotoActual;
        }
        return fotoActual.anterior;
    }

    public void reproducirGaleria() {
        System.out.println("Recorriendo galería hacia adelante:");
        Fotografia actual = cabeza;

        while (actual != null) {
            System.out.println("Foto: " + actual.nombreArchivo +
                               " | Tamaño: " + actual.tamanoMB + " MB" +
                               " | Resolución: " + actual.resolucion);
            actual = actual.siguiente;
        }

        System.out.println("\nRecorriendo galería hacia atrás:");
        actual = cola;

        while (actual != null) {
            System.out.println("Foto: " + actual.nombreArchivo +
                               " | Tamaño: " + actual.tamanoMB + " MB" +
                               " | Resolución: " + actual.resolucion);
            actual = actual.anterior;
        }
    }
}
