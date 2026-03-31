public class ListaReproduccion {
    Cancion cabeza;
    Cancion actual;

    public ListaReproduccion() {
        this.cabeza = null;
        this.actual = null;
    }

    // Agregar al final
    public void agregarAlFinal(Cancion nuevaCancion) {
        if (cabeza == null) {
            cabeza = nuevaCancion;
            actual = nuevaCancion;
        } else {
            Cancion aux = cabeza;
            while (aux.siguiente != null) {
                aux = aux.siguiente;
            }
            aux.siguiente = nuevaCancion;
        }
    }

    // Agregar despues de la actual
    public void agregarAContinuacion(Cancion nuevaCancion) {
        if (cabeza == null) {
            cabeza = nuevaCancion;
            actual = nuevaCancion;
        } else if (actual == null) {
            agregarAlFinal(nuevaCancion);
        } else {
            nuevaCancion.siguiente = actual.siguiente;
            actual.siguiente = nuevaCancion;
        }
    }

    public void mostrarCanciones() {
        if (cabeza == null) {
            System.out.println("No hay canciones en la lista...");
            return;
        }

        Cancion aux = cabeza;
        while (aux != null) {
            if (aux == actual) {
                System.out.println(aux + "  <-- actual");
            } else {
                System.out.println(aux);
            }
            aux = aux.siguiente;
        }
    }

    public void siguienteCancion() {
        if (actual == null) {
            System.out.println("No hay canciones en la lista...");
        } else if (actual.siguiente == null) {
            System.out.println("Ya estas en la ultima cancion.");
        } else {
            actual = actual.siguiente;
            System.out.println("Ahora suena: " + actual.titulo);
        }
    }

    public void mostrarActual() {
        if (actual == null) {
            System.out.println("No hay cancion actual.");
        } else {
            System.out.println("Cancion actual: " + actual);
        }
    }

    // Reto: sumar duracion total en formato MM:SS
    public void mostrarDuracionTotal() {
        if (cabeza == null) {
            System.out.println("No hay canciones en la lista...");
            return;
        }

        int totalSegundos = 0;
        Cancion aux = cabeza;

        while (aux != null) {
            totalSegundos += aux.duracionSegundos;
            aux = aux.siguiente;
        }

        int minutos = totalSegundos / 60;
        int segundos = totalSegundos % 60;

        System.out.printf("Duracion total: %02d:%02d%n", minutos, segundos);
    }
}
