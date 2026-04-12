/*2. Carrusel de Imágenes (Galería Interactiva)
Simula el comportamiento de una galería de fotos en una aplicación móvil.
- **La Clase Fotografia (Nodo):** Debe contener `nombreArchivo` (String), `tamanoMB` (double) y `resolucion` (String).
- **El Problema:** El usuario puede avanzar a la "Siguiente Foto" o retroceder a la "Foto Anterior". Si llega al final, no puede avanzar más (a menos que sea circular, pero por ahora manténlo lineal).
- **Reto:** Crea un método `reproducirGaleria()` que recorra toda la lista hacia adelante y luego toda la lista hacia atrás para mostrar todas las fotos. */

import java.util.Scanner;

public class program {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int opcion;
        Galeria galeria = new Galeria();
        Fotografia fotoActual = null;

        do {
            System.out.println("\n==============================================");
            System.out.println("      Carrusel de Imágenes - Menú Principal");
            System.out.println("==============================================");
            System.out.println("  [1] Agregar Foto");
            System.out.println("  [2] Siguiente Foto");
            System.out.println("  [3] Foto Anterior");
            System.out.println("  [4] Reproducir Galería");
            System.out.println();
            System.out.println("  [0] Salir");
            System.out.println("==============================================");
            System.out.print("Elige una opción: ");

            opcion = sc.nextInt();
            System.out.println();

            switch (opcion) {
                case 1:
                    sc.nextLine();
                    System.out.print("Ingrese el nombre del archivo: ");
                    String nombreArchivo = sc.nextLine();

                    System.out.print("Ingrese el tamaño en MB: ");
                    double tamanoMB = sc.nextDouble();
                    sc.nextLine();

                    System.out.print("Ingrese la resolución: ");
                    String resolucion = sc.nextLine();

                    Fotografia nuevaFoto = new Fotografia(nombreArchivo, tamanoMB, resolucion);
                    galeria.agregarFoto(nuevaFoto);

                    if (fotoActual == null) {
                        fotoActual = nuevaFoto;
                    }

                    System.out.println("Foto agregada correctamente.");
                    break;

                case 2:
                    if (fotoActual != null) {
                        System.out.println("Foto actual: " + fotoActual.nombreArchivo);
                        fotoActual = galeria.siguienteFoto(fotoActual);
                        System.out.println("Ahora estás en: " + fotoActual.nombreArchivo);
                    } else {
                        System.out.println("No hay fotos en la galería.");
                    }
                    break;

                case 3:
                    if (fotoActual != null) {
                        System.out.println("Foto actual: " + fotoActual.nombreArchivo);
                        fotoActual = galeria.fotoAnterior(fotoActual);
                        System.out.println("Ahora estás en: " + fotoActual.nombreArchivo);
                    } else {
                        System.out.println("No hay fotos en la galería.");
                    }
                    break;

                case 4:
                    if (galeria.cabeza != null) {
                        galeria.reproducirGaleria();
                    } else {
                        System.out.println("La galería está vacía.");
                    }
                    break;

                case 0:
                    System.out.println("¡Saliendo..!");
                    break;

                default:
                    System.out.println("Opción no válida.");
            }

        } while (opcion != 0);

        sc.close();
    }
}
