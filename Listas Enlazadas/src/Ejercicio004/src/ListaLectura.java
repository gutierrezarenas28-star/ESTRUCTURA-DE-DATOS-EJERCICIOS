public class ListaLectura {
    
    Lectura cabeza;

    public ListaLectura() {
        this.cabeza = null;
    }

    // Se agrega al inicio
    public void ingresarLectura(Lectura nuevaLectura) {
        nuevaLectura.siguiente = cabeza;
        cabeza = nuevaLectura;
    }

    public void mostrarLecturas() {
        if (cabeza == null) {
            System.out.println("No hay lecturas registradas...");
            return;
        }

        Lectura actual = cabeza;
        while (actual != null) {
            System.out.println(actual);
            actual = actual.siguiente;
        }
    }

    public void mostrarTemperaturaMasAlta() {
        if (cabeza == null) {
            System.out.println("No hay lecturas registradas...");
            return;
        }

        Lectura actual = cabeza;
        Lectura mayor = cabeza;

        while (actual != null) {
            if (actual.temperatura > mayor.temperatura) {
                mayor = actual;
            }
            actual = actual.siguiente;
        }

        System.out.println("Lectura con la temperatura mas alta:");
        System.out.println(mayor);
    }
}
