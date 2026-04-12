/*3. Navegación de Pestañas de Navegador
Imagina un navegador donde puedes moverte entre pestañas abiertas.
- **La Clase Pestana (Nodo):** Debe contener `tituloPagina` (String), `url` (String) y `horaApertura` (String).
- **El Problema:** Las pestañas se abren una tras otra. A veces el usuario quiere cerrar la pestaña actual y el foco debe pasar a la pestaña **anterior**.
- **Reto:** Implementar el método `cerrarPestanaActual(String url)` que busque la pestaña por URL, la elimine de la lista y reconecte el nodo anterior con el siguiente correctamente (¡Cuidado con la Cabeza y la Cola!). */

import java.util.Scanner;

public class Program3 {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int opcion;
        Navegador navegador = new Navegador();
        Pestaña pestañaActual = null;

        do {
            System.out.println("\n==============================================");
            System.out.println("    Navegación de Pestañas — Menú Principal");
            System.out.println("==============================================");
            System.out.println("  [1] Abrir Pestaña");
            System.out.println("  [2] Siguiente Pestaña");
            System.out.println("  [3] Pestaña Anterior");
            System.out.println("  [4] Cerrar Pestaña por URL");
            System.out.println("  [5] Mostrar Pestañas");
            System.out.println();
            System.out.println("  [0] Salir");
            System.out.println("==============================================");
            System.out.print("Elige una opción: ");

            opcion = sc.nextInt();
            System.out.println();

            switch (opcion) {
                case 1:
                    sc.nextLine();
                    System.out.print("Ingrese el título de la página: ");
                    String tituloPagina = sc.nextLine();

                    System.out.print("Ingrese la URL: ");
                    String url = sc.nextLine();

                    System.out.print("Ingrese la hora de apertura: ");
                    String horaApertura = sc.nextLine();

                    Pestaña nuevaPestaña = new Pestaña(tituloPagina, url, horaApertura);
                    navegador.abrirPestaña(nuevaPestaña);

                    if (pestañaActual == null) {
                        pestañaActual = nuevaPestaña;
                    }

                    System.out.println("Pestaña abierta correctamente.");
                    break;

                case 2:
                    if (pestañaActual != null) {
                        System.out.println("Pestaña actual: " + pestañaActual.tituloPagina);
                        pestañaActual = navegador.siguientePestaña(pestañaActual);
                        System.out.println("Ahora estás en: " + pestañaActual.tituloPagina);
                    } else {
                        System.out.println("No hay pestañas abiertas.");
                    }
                    break;

                case 3:
                    if (pestañaActual != null) {
                        System.out.println("Pestaña actual: " + pestañaActual.tituloPagina);
                        pestañaActual = navegador.pestañaAnterior(pestañaActual);
                        System.out.println("Ahora estás en: " + pestañaActual.tituloPagina);
                    } else {
                        System.out.println("No hay pestañas abiertas.");
                    }
                    break;

                case 4:
                    if (navegador.cabeza != null) {
                        sc.nextLine();
                        System.out.print("Ingrese la URL de la pestaña a cerrar: ");
                        String urlCerrar = sc.nextLine();

                        Pestaña cerrada = navegador.buscarPorUrl(urlCerrar);

                        if (cerrada != null) {
                            pestañaActual = navegador.cerrarPestañaActual(urlCerrar, pestañaActual);
                        } else {
                            System.out.println("No se encontró una pestaña con esa URL.");
                        }
                    } else {
                        System.out.println("No hay pestañas abiertas.");
                    }
                    break;

                case 5:
                    navegador.mostrarPestañas();
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
