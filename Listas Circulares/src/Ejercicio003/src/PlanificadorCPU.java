public class PlanificadorCPU {
    Proceso cabeza;
    Proceso cola;

    public PlanificadorCPU() {
        this.cabeza = null;
        this.cola = null;
    }

    public void insertarAlFinal(String nombre, int pid, int tiempoRestante, int prioridad) {
        Proceso nuevo = new Proceso(nombre, pid, tiempoRestante, prioridad);

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

    public void mostrar() {
        if (cabeza == null) {
            System.out.println("No hay procesos en la cola.");
            return;
        }

        Proceso actual = cabeza;
        do {
            System.out.println("Nombre: " + actual.nombre +
                               " | PID: " + actual.pid +
                               " | Tiempo restante: " + actual.tiempoRestante +
                               " | Prioridad: " + actual.prioridad);
            actual = actual.siguiente;
        } while (actual != cabeza);
    }

    public boolean estaVacia() {
        return cabeza == null;
    }

    public void eliminarPorPid(int pid) {
        if (cabeza == null) {
            return;
        }

        if (cabeza.pid == pid) {
            if (cabeza == cola) {
                cabeza = null;
                cola = null;
            } else {
                cabeza = cabeza.siguiente;
                cola.siguiente = cabeza;
            }
            return;
        }

        Proceso anterior = cabeza;
        Proceso actual = cabeza.siguiente;

        while (actual != cabeza) {
            if (actual.pid == pid) {
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

    public void ejecutar(int quantum) {
        if (cabeza == null) {
            System.out.println("No hay procesos para ejecutar.");
            return;
        }

        String ordenFinalizacion = "";
        Proceso actual = cabeza;
        Proceso anterior = cola;

        while (cabeza != null) {
            System.out.println("\nEjecutando proceso: " + actual.nombre +
                               " | PID: " + actual.pid +
                               " | Tiempo restante antes: " + actual.tiempoRestante);

            actual.tiempoRestante -= quantum;

            if (actual.tiempoRestante <= 0) {
                System.out.println("Proceso terminado: " + actual.nombre);

                if (ordenFinalizacion.equals("")) {
                    ordenFinalizacion = actual.nombre;
                } else {
                    ordenFinalizacion += " -> " + actual.nombre;
                }

                if (actual == cabeza && actual == cola) {
                    cabeza = null;
                    cola = null;
                    actual = null;
                } else if (actual == cabeza) {
                    cabeza = cabeza.siguiente;
                    cola.siguiente = cabeza;
                    actual = cabeza;
                } else if (actual == cola) {
                    anterior.siguiente = cabeza;
                    cola = anterior;
                    actual = cabeza;
                } else {
                    anterior.siguiente = actual.siguiente;
                    actual = actual.siguiente;
                }
            } else {
                System.out.println("Tiempo restante después: " + actual.tiempoRestante);
                anterior = actual;
                actual = actual.siguiente;
            }
        }

        System.out.println("\n==============================================");
        System.out.println("Todos los procesos terminaron.");
        System.out.println("Orden de finalización: " + ordenFinalizacion);
        System.out.println("==============================================");
    }
}
