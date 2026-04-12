public class Navegador {
    Pestaña cabeza;
    Pestaña cola;

    public Navegador() {
        this.cabeza = null;
        this.cola = null;
    }

    public void abrirPestaña(Pestaña pestaña) {
        if (cabeza == null) {
            cabeza = pestaña;
            cola = pestaña;
        } else {
            cola.siguiente = pestaña;
            pestaña.anterior = cola;
            cola = pestaña;
        }
    }

    public Pestaña siguientePestaña(Pestaña pestañaActual) {
        if (pestañaActual.siguiente == null) {
            System.out.println("No hay más pestañas hacia adelante.");
            return pestañaActual;
        }
        return pestañaActual.siguiente;
    }

    public Pestaña pestañaAnterior(Pestaña pestañaActual) {
        if (pestañaActual.anterior == null) {
            System.out.println("No hay más pestañas hacia atrás.");
            return pestañaActual;
        }
        return pestañaActual.anterior;
    }

    public Pestaña buscarPorUrl(String url) {
        Pestaña actual = cabeza;

        while (actual != null) {
            if (actual.url.equals(url)) {
                return actual;
            }
            actual = actual.siguiente;
        }

        return null;
    }

    public Pestaña cerrarPestañaActual(String url, Pestaña pestañaActual) {
        Pestaña eliminar = buscarPorUrl(url);

        if (eliminar == null) {
            System.out.println("No se encontró la pestaña.");
            return pestañaActual;
        }

        if (cabeza == cola) {
            System.out.println("Pestaña cerrada: " + eliminar.tituloPagina);
            cabeza = null;
            cola = null;
            return null;
        }

        if (eliminar == cabeza) {
            System.out.println("Pestaña cerrada: " + eliminar.tituloPagina);
            cabeza = cabeza.siguiente;
            cabeza.anterior = null;

            if (pestañaActual == eliminar) {
                return cabeza;
            }

            return pestañaActual;
        }

        if (eliminar == cola) {
            System.out.println("Pestaña cerrada: " + eliminar.tituloPagina);
            cola = cola.anterior;
            cola.siguiente = null;

            if (pestañaActual == eliminar) {
                return eliminar.anterior;
            }

            return pestañaActual;
        }

        eliminar.anterior.siguiente = eliminar.siguiente;
        eliminar.siguiente.anterior = eliminar.anterior;

        System.out.println("Pestaña cerrada: " + eliminar.tituloPagina);

        if (pestañaActual == eliminar) {
            return eliminar.anterior;
        }

        return pestañaActual;
    }

    public void mostrarPestañas() {
        if (cabeza == null) {
            System.out.println("No hay pestañas abiertas.");
            return;
        }

        Pestaña actual = cabeza;

        while (actual != null) {
            System.out.println("Título: " + actual.tituloPagina +
                               " | URL: " + actual.url +
                               " | Hora: " + actual.horaApertura);
            actual = actual.siguiente;
        }
    }
}
