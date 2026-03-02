public class ejercicio010 {

    //copiando configuracion
    /*Ejercicio 10 — Copiando configuración
Una app tiene un objeto `int[] configuracion = {1920, 1080, 60}` (resolución y FPS).

- Crea una **copia real** del arreglo (no una referencia) usando un nuevo arreglo y copiando elemento por elemento.
- Modifica la copia y demuestra que el original **no cambia**.
- Comenta la diferencia con la asignación directa.
 */
    public static void main(String[] args) {

        // Arreglo original (resolución y FPS)
        int[] configuracion = {1920, 1080, 60};

        int[] copiaConfiguracion = new int[configuracion.length];
        for (int i = 0; i < configuracion.length; i++) {
            copiaConfiguracion[i] = configuracion[i];
        }

        // Modificamos la copia
        copiaConfiguracion[2] = 120;

        System.out.println("Configuración original:");
        for (int i = 0; i < configuracion.length; i++) {
            System.out.print(configuracion[i] + " ");
        }

        
        System.out.println("\nConfiguración copia:");
        for (int i = 0; i < copiaConfiguracion.length; i++) {
            System.out.print(copiaConfiguracion[i] + " ");
        }

        /*
         EXPLICACIÓN:
         Aquí hicimos una copia REAL creando un nuevo arreglo
         y copiando cada elemento manualmente.

         Esto hace que:
             configuracion  → apunte a un arreglo
             copiaConfiguracion → apunte a OTRO arreglo distinto

         Por eso, al modificar la copia, el original no cambia.
         */
    }
}
