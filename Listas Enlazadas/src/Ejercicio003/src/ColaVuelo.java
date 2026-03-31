public class ColaVuelo {
    
    Vuelo cabeza;

    public ColaVuelo() {
        this.cabeza = null;
    }

    public void ingresarVuelo(Vuelo nuevoVuelo) {

        // Si tiene menos de 10 de combustible, entra al inicio
        if (nuevoVuelo.combustibleRestante < 10) {
            nuevoVuelo.siguiente = cabeza;
            cabeza = nuevoVuelo;
        } else {
            // Si no, entra al final
            if (cabeza == null) {
                cabeza = nuevoVuelo;
            } else {
                Vuelo actual = cabeza;
                while (actual.siguiente != null) {
                    actual = actual.siguiente;
                }
                actual.siguiente = nuevoVuelo;
            }
        }
    }

    public void mostrarVuelos() {
        if (cabeza == null) {
            System.out.println("No hay vuelos en espera...");
            return;
        }

        Vuelo actual = cabeza;
        while (actual != null) {
            System.out.println(actual);
            actual = actual.siguiente;
        }
    }

    public void reportarEmergencia(String numeroVuelo) {
        if (cabeza == null) {
            System.out.println("No hay vuelos en la cola...");
            return;
        }

        // Si ya está al inicio
        if (cabeza.numeroVuelo.equalsIgnoreCase(numeroVuelo)) {
            System.out.println("El vuelo ya esta en la primera posicion.");
            return;
        }

        Vuelo anterior = cabeza;
        Vuelo actual = cabeza.siguiente;

        while (actual != null && !actual.numeroVuelo.equalsIgnoreCase(numeroVuelo)) {
            anterior = actual;
            actual = actual.siguiente;
        }

        if (actual == null) {
            System.out.println("No se encontro el vuelo.");
            return;
        }

        // Sacarlo de su posición actual
        anterior.siguiente = actual.siguiente;

        // Moverlo al inicio
        actual.siguiente = cabeza;
        cabeza = actual;

        System.out.println("Emergencia reportada. El vuelo " + numeroVuelo + " fue movido al inicio.");
    }
}
