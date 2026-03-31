/*5. Spotify Lite (Lista de Reproducción)
Crea un reproductor de música simplificado que gestione una lista de canciones.
- **La Clase Cancion (Nodo):** Debe contener `titulo` (String), `artista` (String), `duracionSegundos` (int) y `genero` (String).
- **El Problema:** El usuario puede agregar canciones "A continuación" (insertar después de la actual) o "Al final de la cola".
- **Reto:** Implementa un método que sume la duración de todas las canciones y muestre el tiempo total de la lista en formato `MM:SS`. */

import java.util.Scanner;

public class program3 {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int opcion;

        ListaReproduccion lista = new ListaReproduccion();

        do {
            System.out.println("\n==========================================");
            System.out.println("      SPOTIFY LITE - Menu Principal");
            System.out.println("==========================================");
            System.out.println("1. Agregar cancion al final");
            System.out.println("2. Agregar cancion a continuacion");
            System.out.println("3. Mostrar lista de canciones");
            System.out.println("4. Mostrar cancion actual");
            System.out.println("5. Pasar a la siguiente cancion");
            System.out.println("6. Mostrar duracion total");
            System.out.println("0. Salir");
            System.out.println("==========================================");
            System.out.print("Elige una opcion: ");

            if (sc.hasNextInt()) {
                opcion = sc.nextInt();
                sc.nextLine();
            } else {
                System.out.println("Debes ingresar un numero.");
                sc.nextLine();
                opcion = -1;
            }

            switch (opcion) {
                case 1:
                    System.out.print("Titulo: ");
                    String titulo1 = sc.nextLine();

                    System.out.print("Artista: ");
                    String artista1 = sc.nextLine();

                    System.out.print("Duracion en segundos: ");
                    int duracion1 = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Genero: ");
                    String genero1 = sc.nextLine();

                    Cancion cancionFinal = new Cancion(titulo1, artista1, duracion1, genero1);
                    lista.agregarAlFinal(cancionFinal);
                    System.out.println("Cancion agregada al final.");
                    break;

                case 2:
                    System.out.print("Titulo: ");
                    String titulo2 = sc.nextLine();

                    System.out.print("Artista: ");
                    String artista2 = sc.nextLine();

                    System.out.print("Duracion en segundos: ");
                    int duracion2 = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Genero: ");
                    String genero2 = sc.nextLine();

                    Cancion cancionCont = new Cancion(titulo2, artista2, duracion2, genero2);
                    lista.agregarAContinuacion(cancionCont);
                    System.out.println("Cancion agregada a continuacion.");
                    break;

                case 3:
                    System.out.println("Lista de reproduccion:");
                    lista.mostrarCanciones();
                    break;

                case 4:
                    lista.mostrarActual();
                    break;

                case 5:
                    lista.siguienteCancion();
                    break;

                case 6:
                    lista.mostrarDuracionTotal();
                    break;

                case 0:
                    System.out.println("Saliendo del programa...");
                    break;

                default:
                    System.out.println("Opcion no valida.");
            }

        } while (opcion != 0);

        sc.close();
    }
}
