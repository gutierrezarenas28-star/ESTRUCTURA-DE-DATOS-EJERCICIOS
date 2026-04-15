public class CarruselAnuncios {
    Anuncio cabeza;
    Anuncio cola;

    public CarruselAnuncios() {
        this.cabeza = null;
        this.cola = null;
    }

    public void insertarAlFinal(String titulo, int duracionSegundos, int vecesRepetido, String categoria) {
        Anuncio nuevo = new Anuncio(titulo, duracionSegundos, vecesRepetido, categoria);

        if (cabeza == null) {
            cabeza = nuevo;
            cola = nuevo;
            nuevo.siguiente = cabeza;
        } else {
            cola.siguiente = nuevo;
            nuevo.siguiente = cabeza;
            cola = nuevo;
        }
    }

    public void insertarAlInicio(String titulo, int duracionSegundos, int vecesRepetido, String categoria) {
        Anuncio nuevo = new Anuncio(titulo, duracionSegundos, vecesRepetido, categoria);

        if (cabeza == null) {
            cabeza = nuevo;
            cola = nuevo;
            nuevo.siguiente = cabeza;
        } else {
            nuevo.siguiente = cabeza;
            cola.siguiente = nuevo;
            cabeza = nuevo;
        }
    }

    public void eliminar(String titulo) {
        if (cabeza == null) {
            return;
        }

        if (cabeza.titulo.equalsIgnoreCase(titulo)) {
            if (cabeza == cola) {
                cabeza = null;
                cola = null;
            } else {
                cabeza = cabeza.siguiente;
                cola.siguiente = cabeza;
            }
            return;
        }

        Anuncio anterior = cabeza;
        Anuncio actual = cabeza.siguiente;

        while (actual != cabeza) {
            if (actual.titulo.equalsIgnoreCase(titulo)) {
                anterior.siguiente = actual.siguiente;
                if (actual == cola) {
                    cola = anterior;
                }
                return;
            }
            anterior = actual;
            actual = actual.siguiente;
        }
    }

    public void mostrar() {
        if (cabeza == null) {
            System.out.println("No hay anuncios en el carrusel.");
            return;
        }

        Anuncio actual = cabeza;
        do {
            System.out.println("Título: " + actual.titulo +
                               " | Duración: " + actual.duracionSegundos + " s" +
                               " | Repetido: " + actual.vecesRepetido +
                               " | Categoría: " + actual.categoria);
            actual = actual.siguiente;
        } while (actual != cabeza);
    }

    public boolean estaVacia() {
        return cabeza == null;
    }

    public void reproducir(int ciclos) {
        if (cabeza == null) {
            System.out.println("No hay anuncios para reproducir.");
            return;
        }

        int tiempoTotal = 0;
        Anuncio masRepetido = cabeza;

        for (int i = 1; i <= ciclos; i++) {
            System.out.println("\nCiclo " + i + ":");
            Anuncio actual = cabeza;

            do {
                actual.vecesRepetido++;
                tiempoTotal += actual.duracionSegundos;

                System.out.println("En pantalla: " + actual.titulo +
                                   " | Categoría: " + actual.categoria +
                                   " | Duración: " + actual.duracionSegundos + " s" +
                                   " | Veces repetido: " + actual.vecesRepetido);

                if (actual.vecesRepetido > masRepetido.vecesRepetido) {
                    masRepetido = actual;
                }

                actual = actual.siguiente;
            } while (actual != cabeza);
        }

        Anuncio actual = cabeza.siguiente;
        while (actual != cabeza) {
            if (actual.vecesRepetido > masRepetido.vecesRepetido) {
                masRepetido = actual;
            }
            actual = actual.siguiente;
        }

        System.out.println("\n==============================================");
        System.out.println("Anuncio más repetido: " + masRepetido.titulo);
        System.out.println("Categoría: " + masRepetido.categoria);
        System.out.println("Veces repetido: " + masRepetido.vecesRepetido);
        System.out.println("Tiempo total acumulado en pantalla: " + tiempoTotal + " segundos");
        System.out.println("==============================================");
    }
}
