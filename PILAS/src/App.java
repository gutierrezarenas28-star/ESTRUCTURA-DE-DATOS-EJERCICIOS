/*2. Control de Calidad (Línea de Ensamblaje)
Un brazo robótico en una fábrica de motores apila componentes siguiendo una secuencia precisa. Un sensor de visión artificial inspecciona cada pieza después de ser colocada.
- **La Clase Pieza (Nodo):** Debe contener `nombrePieza` (String), `numeroSerie` (String) y `esDefectuosa` (boolean).
- **El Problema:** Si el sensor detecta una pieza defectuosa, la línea de producción debe detenerse inmediatamente.
- **Reto:** Crea un método `limpiarHastaDefecto()` que extraiga (`pop`) todas las piezas de la pila hasta encontrar la primera que tenga `esDefectuosa = true`. El método debe imprimir el nombre de todas las piezas "buenas" que tuvieron que ser retiradas y descartadas antes de llegar a la pieza fallida. */
public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
    }
}
