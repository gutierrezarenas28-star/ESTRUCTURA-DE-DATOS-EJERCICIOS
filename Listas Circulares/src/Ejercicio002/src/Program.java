/*2. Carrusel de Anuncios (Pantalla Digital)
Una tienda tiene una pantalla que muestra anuncios en rotación continua. Cuando termina el último anuncio, vuelve automáticamente al primero.
- **La Clase Anuncio (Nodo):** Debe contener `titulo` (String), `duracionSegundos` (int), `vecesRepetido` (int) y `categoria` (String - ej: "Oferta", "Marca", "Evento").
- **El Problema:** La pantalla necesita saber cuánto tiempo total lleva encendida y cuál es el anuncio que más veces se ha repetido.
- **Reto:** Implementa el método `reproducir(int ciclos)` que simule `ciclos` pasadas completas por todos los anuncios, incrementando `vecesRepetido` en cada paso e imprimiendo
- qué anuncio está en pantalla. Al finalizar, muestra el anuncio más repetido y el **tiempo total acumulado** en pantalla. */
import java.util.Scanner;

public class Program {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int opcion;
        CarruselAnuncios carrusel = new CarruselAnuncios();

        do {
            System.out.println("\n==============================================");
            System.out.println("     Carrusel de Anuncios — Menú Principal");
            System.out.println("==============================================");
            System.out.println("  [1] Insertar anuncio al final");
            System.out.println("  [2] Insertar anuncio al inicio");
            System.out.println("  [3] Eliminar anuncio");
            System.out.println("  [4] Mostrar anuncios");
            System.out.println("  [5] Reproducir carrusel");
            System.out.println();
            System.out.println("  [0] Salir");
            System.out.println("==============================================");
            System.out.print("Elige una opción: ");

            opcion = sc.nextInt();
            sc.nextLine();
            System.out.println();

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese el título: ");
                    String tituloFinal = sc.nextLine();
                    System.out.print("Ingrese la duración en segundos: ");
                    int duracionFinal = sc.nextInt();
                    System.out.print("Ingrese las veces repetido iniciales: ");
                    int repetidoFinal = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Ingrese la categoría: ");
                    String categoriaFinal = sc.nextLine();

                    carrusel.insertarAlFinal(tituloFinal, duracionFinal, repetidoFinal, categoriaFinal);
                    System.out.println("Anuncio insertado al final.");
                    break;

                case 2:
                    System.out.print("Ingrese el título: ");
                    String tituloInicio = sc.nextLine();
                    System.out.print("Ingrese la duración en segundos: ");
                    int duracionInicio = sc.nextInt();
                    System.out.print("Ingrese las veces repetido iniciales: ");
                    int repetidoInicio = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Ingrese la categoría: ");
                    String categoriaInicio = sc.nextLine();

                    carrusel.insertarAlInicio(tituloInicio, duracionInicio, repetidoInicio, categoriaInicio);
                    System.out.println("Anuncio insertado al inicio.");
                    break;

                case 3:
                    System.out.print("Ingrese el título del anuncio a eliminar: ");
                    String tituloEliminar = sc.nextLine();
                    carrusel.eliminar(tituloEliminar);
                    System.out.println("Operación de eliminación realizada.");
                    break;

                case 4:
                    carrusel.mostrar();
                    break;

                case 5:
                    if (carrusel.estaVacia()) {
                        System.out.println("No hay anuncios en el carrusel.");
                    } else {
                        System.out.print("Ingrese la cantidad de ciclos a reproducir: ");
                        int ciclos = sc.nextInt();
                        carrusel.reproducir(ciclos);
                    }
                    break;

                case 0:
                    System.out.println("¡Saliendo del módulo de Listas Circulares!");
                    break;

                default:
                    System.out.println("Opción no válida.");
            }

        } while (opcion != 0);

        sc.close();
    }
}
