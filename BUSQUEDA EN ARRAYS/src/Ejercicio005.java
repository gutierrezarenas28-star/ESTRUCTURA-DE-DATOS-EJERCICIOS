public class Ejercicio005 {
    /*
    5. Contador de Estudiantes (Registro Académico)
Un profesor tiene un arreglo con las notas finales de 30 estudiantes (ej: `3.5, 4.0, 2.8, 5.0, ...`).
- **El Problema:** El profesor necesita saber exactamente **cuántos estudiantes** sacaron una nota de `5.0`.
- **Algoritmo a usar:** **Búsqueda Lineal con Contador**. Debes recorrer todo el arreglo y, cada vez que encuentres un `5.0`, aumentar una variable contador.
     */

    public static void main(String[] args) {

        double[] notas = {3.5, 4.0, 5.0, 2.8, 5.0, 4.5, 3.9, 5.0,
            3.5, 5.0, 2.4, 4.3, 4.8, 5.0, 3.7, 4.1, 2.9,
            3.3, 4.4, 5.0, 4.9, 3.6,
            2.7, 4.0, 3.8, 5.0
        };

        int contador = 0;

        for (int i = 0; i < notas.length; i++) {

            if (notas[i] == 5.0) {
                contador++;
            }
        }

        System.out.println(" Los estudiantes con nota de 5.0 son:  " +  contador);
    }
}
